package org.mackas.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.Docente;
import org.mackas.model.builder.DocenteBuilder;
import org.mackas.service.interf.IDocenteDao;
import org.mackas.util.singlenton.ConexionMySQL;

import java.util.List;

public class DocenteRepositoryImpl implements IDocenteDao {

    private Connection mysql;
    public DocenteRepositoryImpl(Connection conx){
        mysql=conx;
    }
    
    @Override
    public Docente findByIdUser(int idUser) {
          Docente docente = null;
        String sql = "{CALL sp_docente_usuario(?)}";
        
        try (CallableStatement stmt = mysql.prepareCall(sql)) {
            stmt.setInt(1, idUser);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    docente = new DocenteBuilder()
                    .setIdDocente(rs.getInt("id_docente"))
                    .setIdUsuario(rs.getInt("id_usuario"))
                   // .setCodigo(rs.getString("codigo"))
                    .setNombres(rs.getString("nombres"))
                    .setApellidos(rs.getString("apellidos"))
                    .setDni(rs.getString("dni"))
                    .setEmail(rs.getString("email"))
                    .setTelefono(rs.getString("telefono"))
                    .setEspecialidad(rs.getString("especialidad"))
                    .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docente;
    }

}
