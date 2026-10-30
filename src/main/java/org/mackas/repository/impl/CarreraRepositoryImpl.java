/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.mackas.model.Carrera;
import org.mackas.repository.interf.CarreraRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class CarreraRepositoryImpl implements CarreraRepository{
    private Connection mysql = ConexionMySQL.getInstance().getConexion();
    @Override
    public Carrera save(Carrera beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carrera findById(Integer id) {
        Carrera carrera = null;
        String sql = "{CALL sp_obtener_carrera(?)}";

        // Asumiendo que 'conexion' es tu objeto Connection de MySQL activo
        try (CallableStatement stmt = mysql.prepareCall(sql)) {

            // Seteamos el parámetro de entrada
            stmt.setInt(1, id);

            // Ejecutamos la consulta y obtenemos el resultado
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    carrera = new Carrera();
                    //seterr
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar carrera por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return carrera; // Retorna el objeto Carrera si lo encuentra, o null si no existe
    }

    @Override
    public List<Carrera> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
