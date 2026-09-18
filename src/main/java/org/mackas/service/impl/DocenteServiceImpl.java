package org.mackas.service.impl;

import org.mackas.model.Docente;
import org.mackas.repository.interf.DocenteRepository;

import java.util.List;

public class DocenteServiceImpl
implements DocenteRepository
{
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
}
