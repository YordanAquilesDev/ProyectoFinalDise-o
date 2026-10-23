package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mackas.model.Alumno;
import org.mackas.repository.interf.AlumnoRepository;

import java.util.List;
import org.mackas.util.ConexionDataBase;
import org.mackas.util.ConexionMySQL;

public class AlumnoRepositoryImpl implements AlumnoRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public Alumno findByCodigo(String codigo) {
        return null;
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
}
