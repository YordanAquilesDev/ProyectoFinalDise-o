/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "{CALL sp_matricula_alumno(?)}";

        try (CallableStatement cst = mysql.prepareCall(sql)) {
            cst.setInt(1, idAlumno);

            try (ResultSet rs = cst.executeQuery()) {
                // Si rs.next() encuentra al menos una fila, significa que tiene una matrícula REGISTRADA
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar matrícula: " + e.getMessage());
            e.printStackTrace();
        }

        // Si no devolvió ningún registro, retorna false
        return false;
    }

    @Override
    public Matricula setMatricula(Matricula mt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
