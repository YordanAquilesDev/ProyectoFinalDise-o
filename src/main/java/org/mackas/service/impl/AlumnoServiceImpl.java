package org.mackas.service.impl;

import org.mackas.model.Alumno;
import org.mackas.service.interf.AlumnoService;

import java.util.List;

public class AlumnoServiceImpl
 implements AlumnoService
{
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
    public Alumno update(Alumno beans) {
        return null;
    }

    @Override
    public Alumno findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
