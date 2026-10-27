/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

  @Override
    public List<Seccion> findByIdDocente(int idDocente) {
        List<Seccion> listaSecciones = new ArrayList<>();
        String sql = "{CALL sp_listar_secciones_docente(?)}";

        try (PreparedStatement pstmt = mysql.prepareStatement(sql)) {
            // Asignamos el parámetro de entrada (id_docente)
            pstmt.setInt(1, idDocente);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Recorremos cada registro devuelto por el procedimiento
                while (rs.next()) {
                    Seccion seccion = new Seccion();
                    
                    // Mapeamos los campos con los atributos de tu modelo Seccion
                    seccion.setId_seccion(rs.getInt("id_seccion"));
                    seccion.setId_curso(rs.getInt("id_curso"));
                    
                    // Nota: Si el id_docente viene implícito por el procedure, 
                    // puedes asignarlo directamente o leerlo si lo incluyes en el SELECT
                    seccion.setId_docente(idDocente); 
                    
                    seccion.setCodigo_seccion(rs.getString("codigo_seccion"));
                    seccion.setAula(rs.getString("aula"));
                    seccion.setId_periodo(rs.getInt("id_periodo"));
                    
                    // Ojo aquí: Mapeamos con el nombre que devuelve el SELECT de tu procedure
                    seccion.setCupo_max(rs.getInt("cupo_maximo")); 

                    listaSecciones.add(seccion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSecciones;
    }

    @Override
    public List<Seccion> findByIdAlumno(int idEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
