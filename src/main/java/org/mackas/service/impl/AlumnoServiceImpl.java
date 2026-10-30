package org.mackas.service.impl;

import org.mackas.model.Alumno;
import org.mackas.service.interf.AlumnoService;

import java.util.List;
import org.mackas.repository.impl.AlumnoRepositoryImpl;
import org.mackas.repository.interf.AlumnoRepository;

public class AlumnoServiceImpl
 implements AlumnoService
{
    private AlumnoRepository repo= new AlumnoRepositoryImpl();
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
        return List.of();
    }


    @Override
    public Alumno findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findByIdSeccion(int idSeccion) {
        return repo.findByIdSeccion(idSeccion);
    }

    @Override
    public Alumno findByIdUser(int idUser) {
        return repo.findByIdUser(idUser);
    }
}
