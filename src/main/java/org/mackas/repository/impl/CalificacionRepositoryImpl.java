/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mackas.model.Calificacion;
import org.mackas.repository.interf.CalificacionRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class CalificacionRepositoryImpl implements CalificacionRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public List<Calificacion> findByIdCursoAlumno(int idCurso, int idAlumno) {
        List<Calificacion> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_calificacion_curso(?, ?)}"; // 👈 Dos signos de interrogación

        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            // Asignamos ambos parámetros de entrada del procedimiento
            stmt.setInt(1, idCurso);
            stmt.setInt(2, idAlumno); // 👈 Enviamos el ID del alumno

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Calificacion cal = new Calificacion();
                    cal.setId_calificacion(rs.getInt("id_calificacion"));
                    cal.setId_detalle_matricula(rs.getInt("id_detalle_matricula"));
                    cal.setMombre_evaluacion(rs.getString("nombre_evaluacion"));
                    cal.setPonderado(rs.getDouble("ponderado"));
                    cal.setNota(rs.getDouble("nota"));
                    cal.setFecha_registro(rs.getDate("fecha_registro"));

                    lista.add(cal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Calificacion save(Calificacion beans) {
        String sql = "{CALL sp_calificar_alumno(?, ?, ?, ?)}";

        // Suponiendo que 'mysql' es tu método o variable de conexión Connection:
        try (Connection conn = mysql; // O mysql.getConnection() dependiendo de cómo lo manejes
                 CallableStatement stmt = conn.prepareCall(sql)) {

            // Mapeamos los parámetros en el orden del procedimiento almacenado
            stmt.setInt(1, beans.getId_detalle_matricula());
            stmt.setString(2, beans.getMombre_evaluacion()); // Ojo con el nombre en tu modelo
            stmt.setDouble(3, beans.getNota());
            stmt.setDouble(4, beans.getPonderado());

            // Ejecutamos el procedimiento de inserción
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                // Si deseas puedes retornar el mismo objeto indicando éxito
                return beans;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null si falló
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Calificacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion update(Calificacion beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
