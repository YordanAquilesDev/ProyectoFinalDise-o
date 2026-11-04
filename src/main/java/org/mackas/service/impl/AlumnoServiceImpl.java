package org.mackas.service.impl;

import org.mackas.model.Alumno;
import org.mackas.service.interf.IAlumnoDao;

import java.sql.SQLException;
import java.util.List;
import org.mackas.repository.AlumnoRepositoryImpl;

public class AlumnoServiceImpl implements IAlumnoDao {
    private IAlumnoDao repo;
    public AlumnoServiceImpl(IAlumnoDao repoDao){
        this.repo=repoDao;
    }

   
    @Override
    public List<Alumno> findByIdSeccion(int idSeccion) {
        return repo.findByIdSeccion(idSeccion);
    }

    @Override
    public Alumno findByIdUser(int idUser) throws SQLException {
        return repo.findByIdUser(idUser);
    }
}
