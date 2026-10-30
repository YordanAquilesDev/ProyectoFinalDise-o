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
import org.mackas.model.Curso;
import org.mackas.repository.interf.CursoRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class CursoRepositoryImpl implements CursoRepository {

    private final Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public List<Curso> finByIdAlumno(int idAlumno) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "{CALL sp_listar_cursos_alumno(?)}";

        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            // Asignar el parámetro de entrada del procedimiento
            stmt.setInt(1, idAlumno);

            try (ResultSet rs = stmt.executeQuery()) {
                // Recorrer los resultados y construir los objetos Curso
                while (rs.next()) {
                    Curso curso = new Curso(
                            rs.getInt("id_curso"),
                            rs.getInt("id_carrera"),
                            rs.getString("codigo_curso"),
                            rs.getString("nombre_curso"),
                            rs.getInt("creditos"),
                            rs.getInt("ciclo_nivel")
                    );
                    cursos.add(curso);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar cursos por alumno: " + e.getMessage());
            e.printStackTrace();
        }

        return cursos;
    }

    @Override
    public Curso save(Curso beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    @Override
    public Curso findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
