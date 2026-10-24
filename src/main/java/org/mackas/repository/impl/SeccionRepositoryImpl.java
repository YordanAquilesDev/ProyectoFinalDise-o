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
import org.mackas.model.Seccion;
import org.mackas.repository.interf.SeccionRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class SeccionRepositoryImpl implements SeccionRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public List<Seccion> findByIdPeriodo(int idPeriodo) {
        List<Seccion> listaSecciones = new ArrayList<>();
        // Sintaxis JDBC para llamar a un Stored Procedure
        String sql = "{CALL sp_listar_secciones_periodo(?)}";

        try (CallableStatement cstmt = mysql.prepareCall(sql)) {
            // Asignar el parámetro de entrada (el id_periodo)
            cstmt.setInt(1, idPeriodo);

            // Ejecutar la consulta y obtener los resultados
            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    Seccion seccion = new Seccion();

                    // Mapear cada columna del ResultSet a los atributos de la clase Seccion
                    seccion.setId_seccion(rs.getInt("id_seccion"));
                    seccion.setId_curso(rs.getInt("id_curso"));
                    seccion.setCodigo_seccion(rs.getString("codigo_seccion"));
                    seccion.setAula(rs.getString("aula"));
                    seccion.setId_periodo(rs.getInt("id_periodo"));
                    seccion.setCupo_max(rs.getInt("cupo_maximo")); // Ojo: en la BD se llama cupo_maximo

                    // Agregar a la lista
                    listaSecciones.add(seccion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar secciones por periodo: " + e.getMessage());
            e.printStackTrace();
        }

        return listaSecciones;
    }

}
