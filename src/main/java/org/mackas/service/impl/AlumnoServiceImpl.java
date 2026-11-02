package org.mackas.service.impl;

import org.mackas.model.Alumno;
import org.mackas.service.interf.IAlumnoDao;

import java.util.List;
import org.mackas.repository.impl.AlumnoRepositoryImpl;
import org.mackas.repository.interf.AlumnoRepository;

public class AlumnoServiceImpl
 implements IAlumnoDao
{
    private AlumnoRepository repo= new AlumnoRepositoryImpl();
   
    @Override
    public List<Alumno> findByIdSeccion(int idSeccion) {
        return repo.findByIdSeccion(idSeccion);
    }

    @Override
    public Alumno findByIdUser(int idUser) {
        return repo.findByIdUser(idUser);
    }
}
