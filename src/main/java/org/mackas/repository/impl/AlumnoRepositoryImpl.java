package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mackas.model.Alumno;
import org.mackas.repository.interf.AlumnoRepository;

import java.util.List;
import org.mackas.util.ConexionMySQL;

public class AlumnoRepositoryImpl implements AlumnoRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public Alumno findByIdUser(int  idUser) {
       Alumno alumno = null;
        String sql = "{CALL sp_alumno_usuario(?)}";

        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            stmt.setInt(1, idUser);
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

    @Override
    public Alumno save(Alumno beans) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "{CALL sp_listar_alumnos()}";

        // Usamos try-with-resources para cerrar automáticamente el CallableStatement y el ResultSet
        try (CallableStatement cstmt = mysql.prepareCall(sql); ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno();

                // Mapeo de columnas devueltas por el procedimiento almacenado
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setIdCarrera(rs.getInt("id_carrera"));
                alumno.setCodigo(rs.getString("codigo"));
                alumno.setNombres(rs.getString("nombres"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setDni(rs.getString("dni"));
                alumno.setEmail(rs.getString("email"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setFechaNacimiento(rs.getDate("fecha_nacimiento"));

                listaAlumnos.add(alumno);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar alumnos: " + e.getMessage());
            e.printStackTrace();
        }

        return listaAlumnos;
    }

    @Override
    public Alumno update(Alumno beans) {
        return null;
    }

    @Override
    public Alumno findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
    public List<Alumno> findByIdSeccion(int idSeccion) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        // Llamada al Stored Procedure usando la sintaxis de JDBC
        String sql = "{CALL sp_listar_alumnos_seccion(?)}";

        try (PreparedStatement pstmt = mysql.prepareStatement(sql)) {
            // Asignamos el parámetro de entrada (id_seccion)
            pstmt.setInt(1, idSeccion);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Recorremos cada registro devuelto por el procedimiento
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    
                    // Mapeamos los campos del ResultSet con los atributos del modelo Alumno
                    alumno.setIdAlumno(rs.getInt("id_alumno"));
                    alumno.setIdCarrera(rs.getInt("id_carrera"));
                    alumno.setNombres(rs.getString("nombres"));
                    alumno.setApellidos(rs.getString("apellidos"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setEmail(rs.getString("email"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setFechaNacimiento(rs.getDate("fecha_nacimiento"));                    
                    // Nota: Si en tu procedure o tabla también devuelves el código institucional, 
                    // asegúrate de agregarlo al SELECT del procedure y mapearlo aquí:
                    // alumno.setCodigo(rs.getString("codigo"));

                    listaAlumnos.add(alumno);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Aquí puedes manejar la excepción según tu arquitectura (lanzar una RuntimeException, etc.)
        }

        return listaAlumnos;
    }
}
