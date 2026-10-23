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
public List<Calificacion> findByIdCurso(int idCurso) {
    List<Calificacion> lista = new ArrayList<>();
    String sql = "{CALL sp_listar_calificacion_curso(?)}";

    try (CallableStatement stmt = mysql.prepareCall(sql)) {
        // Asignamos el parámetro de entrada del procedimiento
        stmt.setInt(1, idCurso);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Calificacion cal = new Calificacion();
                cal.setId_calificacion(rs.getInt("id_calificacion"));
                cal.setId_detalle_matricula(rs.getInt("id_detalle_matricula"));
                
                // Ojo: En tu modelo tienes escrito 'mombre_evaluacion', 
                // por lo que usamos el setter correspondiente respetando la columna de la BD ("nombre_evaluacion")
                cal.setMombre_evaluacion(rs.getString("nombre_evaluacion"));
                
                cal.setPonderado(rs.getDouble("ponderado"));
                cal.setNota(rs.getDouble("nota"));
                cal.setFecha_registro(rs.getDate("fecha_registro"));

                lista.add(cal);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Opcional: Manejar o propagar la excepción según la arquitectura de tu proyecto
    }

    return lista;
}

    @Override
    public Calificacion save(Calificacion beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
