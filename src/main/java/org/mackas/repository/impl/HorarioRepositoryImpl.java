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
import org.mackas.model.Horario;
import org.mackas.repository.interf.HorarioRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class HorarioRepositoryImpl implements HorarioRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();


    public List<Horario> findByIdAlumno(int idAlumno) {
        List<Horario> listaHorarios = new ArrayList<>();
        String sql = "{CALL sp_listar_horarios_alumno(?)}";

        try (CallableStatement cstmt = mysql.prepareCall(sql)) {
            // Asignar el parámetro de entrada al procedimiento almacenado
            cstmt.setInt(1, idAlumno);

            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    Horario horario = new Horario();
                    horario.setId_horario(rs.getInt("id_horario"));                 
                    horario.setId_seccion(rs.getInt("id_seccion"));
                    horario.setDia_semana(rs.getString("dia_semana"));

                    // Dependiendo de cómo manejes las horas en tu modelo (Time, LocalTime, String):
                    horario.setHora_inicio(rs.getTime("hora_inicio"));
                    horario.setHora_fin(rs.getTime("hora_fin"));

                    horario.setAula(rs.getString("aula"));

                    listaHorarios.add(horario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar horarios del alumno: " + e.getMessage());
            e.printStackTrace();
        }

        return listaHorarios;
    }

    @Override
    public Horario save(Horario beans) {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Horario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario update(Horario beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
  
}
