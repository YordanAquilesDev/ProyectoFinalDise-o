/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.mackas.model.Pension;

import org.mackas.service.interf.IPensionDao;
import org.mackas.util.singlenton.ConexionMySQL;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class PensionRepositoryImpl implements IPensionDao {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public boolean save(Pension p) {
        String sql = "{CALL sp_pagar_pension_alumno(?, ?, ?)}";

        // Asume que tienes una clase para obtener la conexión (ej. Conexion.getConexion())
        try (Connection cn = mysql; CallableStatement cstmt = cn.prepareCall(sql)) {

            // Asignamos los parámetros que espera el Stored Procedure
            cstmt.setInt(1, p.getIdAlumno());
            cstmt.setInt(2, p.getIdPension());

            // Convertimos LocalDateTime a Timestamp para que MySQL lo entienda perfectamente
            if (p.getFechaPago() != null) {
                cstmt.setTimestamp(3, java.sql.Timestamp.valueOf(p.getFechaPago()));
            } else {
                cstmt.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            }

            // Ejecutamos la actualización (retorna true si afecta filas)
            int filasAfectadas = cstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error al guardar/actualizar el pago de pensión: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Pension> findByIdAlumno(int idAlumno) {
        String sql = "{call sp_pensiones_pendientes_alumno(?)}";
        List<Pension> listaPensiones = new ArrayList<>();

        try (CallableStatement cst = mysql.prepareCall(sql)) {
            cst.setInt(1, idAlumno);

            try (ResultSet rs = cst.executeQuery()) {
                while (rs.next()) {
                    Pension pension = new Pension();
                    pension.setIdPension(rs.getInt("id_pension"));
                    pension.setIdAlumno(rs.getInt("id_alumno"));
                    pension.setIdMatricula(rs.getInt("id_matricula"));
                    pension.setNumeroCuota(rs.getInt("numero_cuota"));
                    pension.setMonto(rs.getDouble("monto"));
                    pension.setMontoMora(rs.getDouble("monto_mora"));

                    // Conversión segura de fechas de SQL a LocalDate/LocalDateTime
                    if (rs.getDate("fecha_vencimiento") != null) {
                        pension.setFechaVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                    }

                    if (rs.getTimestamp("fecha_pago") != null) {
                        pension.setFechaPago(rs.getTimestamp("fecha_pago").toLocalDateTime());
                    }

                    pension.setEstado(rs.getString("estado"));

                    listaPensiones.add(pension);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pensiones pendientes: " + e.getMessage());
            e.printStackTrace();
        }

        return listaPensiones;
    }

}
