package org.mackas.repository.impl;

import java.sql.Connection;
import org.mackas.model.Docente;
import org.mackas.repository.interf.DocenteRepository;

import java.util.List;
import org.mackas.util.ConexionMySQL;

public class DocenteRepositoryImpl implements DocenteRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();
    @Override
    public Docente findById(String codigo) {
        return null;
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
    public Docente update(Docente beans) {
        return null;
    }

    @Override
    public Docente findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
