package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.Docente;
import org.mackas.repository.interf.DocenteRepository;

import java.util.List;
import org.mackas.util.ConexionMySQL;

public class DocenteRepositoryImpl implements DocenteRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();
    
    @Override
    public Docente findByIdUser(int idUser) {
          Docente docente = null;
        String sql = "{CALL sp_docente_usuario(?)}";
        
        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            stmt.setInt(1, idUser);
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

    @Override
    public Docente save(Docente beans) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Docente> findAll() {
        return List.of();
    }



    @Override
    public Docente findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
