package org.mackas.service.impl;

import org.mackas.model.Alumno;
import org.mackas.service.interf.IAlumnoDao;

import java.util.List;
import org.mackas.repository.AlumnoRepositoryImpl;

public class AlumnoServiceImpl
 implements IAlumnoDao
{
    private IAlumnoDao repo= new AlumnoRepositoryImpl();
   
    @Override
    public List<Alumno> findByIdSeccion(int idSeccion) {
        return repo.findByIdSeccion(idSeccion);
    }

    @Override
    public Alumno findByIdUser(int idUser) {
        return repo.findByIdUser(idUser);
    }
}
