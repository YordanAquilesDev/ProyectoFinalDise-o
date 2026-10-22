/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Usuario;
import org.mackas.service.interf.UserService;
import org.mackas.util.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;

public class UserServiceImpl implements UserService {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public Usuario login(String codigo, String password) {
        Usuario usuarioLogueado = null;
        String sqlLogin = "{CALL sp_login(?, ?)}";

        // Solo cerramos el CallableStatement y el ResultSet, NUNCA la conexión compartida 'mysql'
        try (CallableStatement stmtLogin = mysql.prepareCall(sqlLogin)) {

            stmtLogin.setString(1, codigo);
            stmtLogin.setString(2, password);

            try (ResultSet rs = stmtLogin.executeQuery()) {
                if (rs.next()) {
                    int idUsuario = rs.getInt("id_usuario");
                    String rol = rs.getString("rol");

                    // Dependiendo del rol, cargamos los datos específicos
                    if ("ALUMNO".equals(rol)) {
                        usuarioLogueado =(Usuario) obtenerAlumnoPorIdUsuario(idUsuario);
                    } else if ("DOCENTE".equals(rol)) {
                        usuarioLogueado = obtenerDocentePorIdUsuario(idUsuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja el error según la gestión de excepciones de tu proyecto
        }

        return usuarioLogueado;
    }

    // --- Métodos auxiliares privados para buscar el perfil específico ---
    private Alumno obtenerAlumnoPorIdUsuario(int idUsuario) {
        Alumno alumno = null;
        String sql = "{CALL sp_obtener_alumno_por_usuario(?)}";

        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setIdAlumno(rs.getInt("id_alumno"));
                    //  alumno.setIdUsuario(rs.getInt("id_usuario"));
                    alumno.setIdCarrera(rs.getInt("id_carrera"));
                    alumno.setCodigo(rs.getString("codigo"));
                    alumno.setNombres(rs.getString("nombres"));
                    alumno.setApellidos(rs.getString("apellidos"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setEmail(rs.getString("email"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;
    }

    private Docente obtenerDocentePorIdUsuario(int idUsuario) {
        Docente docente = null;
        String sql = "{CALL sp_obtener_docente_por_usuario(?)}";
        
        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    docente = new Docente();
                    docente.setIdDocente(rs.getInt("id_docente"));
                    docente.setIdUsuario(rs.getInt("id_usuario"));
                    docente.setCodigo(rs.getString("codigo"));
                    docente.setNombres(rs.getString("nombres"));
                    docente.setApellidos(rs.getString("apellidos"));
                    docente.setDni(rs.getString("dni"));
                    docente.setEmail(rs.getString("email"));
                    docente.setTelefono(rs.getString("telefono"));
                    docente.setEspecialidad(rs.getString("especialidad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docente;
    }
    
}
