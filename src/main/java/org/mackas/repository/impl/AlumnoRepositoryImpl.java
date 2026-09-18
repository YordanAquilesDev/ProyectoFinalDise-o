package org.mackas.repository.impl;

import org.mackas.model.Alumno;
import org.mackas.repository.interf.AlumnoRepository;

import java.util.List;

public class AlumnoRepositoryImpl  implements AlumnoRepository {


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
        return List.of();
    }

    @Override
    public Alumno update(Alumno beans) {
        return null;
    }
}
