/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository;

import org.mackas.model.Pension;
import org.mackas.model.patron.PagoEstrategy;
import org.mackas.service.interf.IPensionDao;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class PensionRepositoryImpl implements IPensionDao{

    @Override
    public boolean save(Pension p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  public  List<Pension> findByIdMatricula(int idMatricula){
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
