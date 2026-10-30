/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;
import org.mackas.repository.interf.MatriculaRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class MatriculaRepositoryImpl implements MatriculaRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public boolean isMatricula(int idAlumno) {
        String sql = "{call sp_matricula_alumno(?)}";
        boolean tieneMatricula = false;

        try (CallableStatement cst = mysql.prepareCall(sql)) {
            cst.setInt(1, idAlumno);

            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    tieneMatricula = true;
                    System.out.println("✅ El alumno ID " + idAlumno + " SÍ tiene matrícula encontrada (ID Matricula: " + rs.getInt("id_matricula") + ")");
                } else {
                    System.out.println("❌ El alumno ID " + idAlumno + " NO tiene matrículas registradas.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar matrícula: " + e.getMessage());
            e.printStackTrace();
        }

        return tieneMatricula;
    }

    @Override
    public Matricula setMatricula(Matricula mt) {
        String sqlMatricula = "{CALL sp_matricular_alumno(?, ?, ?)}";
        String sqlDetalle = "{CALL sp_detalle_matricula_alumno(?, ?)}";

        int idMatriculaGenerada = 0;

        try {
            // Desactivamos el auto-commit para manejar la Transacción segura
            mysql.setAutoCommit(false);

            // ==========================================
            // PASO 1: Insertar la Cabecera y leer su ID retornado
            // ==========================================
            try (CallableStatement stmtMat = mysql.prepareCall(sqlMatricula)) {

                stmtMat.setInt(1, mt.getId_alumno());
                stmtMat.setInt(2, mt.getId_periodo());
                stmtMat.setDouble(3, mt.getMonto_total());

                // Usamos executeQuery porque nuestro SP ahora devuelve un SELECT con el ID
                try (ResultSet rs = stmtMat.executeQuery()) {
                    if (rs.next()) {
                        idMatriculaGenerada = rs.getInt("id_matricula");
                    }
                }
            }

            // Validamos si se obtuvo el ID correctamente
            if (idMatriculaGenerada == 0) {
                mysql.rollback();
                System.err.println("Error: No se pudo obtener el ID de la matrícula generada.");
                return null;
            }

            // ==========================================
            // PASO 2: Guardar los detalles en bucle (Lote)
            // ==========================================
            try (CallableStatement stmtDet = mysql.prepareCall(sqlDetalle)) {
                for (DetalleMatricula det : mt.getDetalle_matricula()) {
                    stmtDet.setInt(1, idMatriculaGenerada);
                    stmtDet.setInt(2, det.getId_seccion());
                    stmtDet.addBatch();
                }
                stmtDet.executeBatch();
            }

            // ==========================================
            // PASO 3: Confirmar Transacción
            // ==========================================
            mysql.commit();
            return mt;

        } catch (SQLException e) {
            try {
                mysql.rollback(); // Revierte todo si ocurre un error de SQL
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.err.println("SQL Error en setMatricula: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                mysql.setAutoCommit(true); // Restauramos el autocommit por defecto
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public DetalleMatricula search(int idSeccion, int idAlumno) {
        DetalleMatricula detalle = null;
        String sql = "{CALL sp_buscar_detalle_matricula(?, ?)}";

        try (CallableStatement stmt = mysql.prepareCall(sql)) {

            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idSeccion);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    detalle = new DetalleMatricula();
                    detalle.setId_detalle_matricula(rs.getInt("id_detalle_matricula"));
                    detalle.setPromedio_final(rs.getDouble("promedio_final"));
                    detalle.setEstado(rs.getString("estado_curso"));
                    // y los demás mapeos que necesites...
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detalle;
    }

}
