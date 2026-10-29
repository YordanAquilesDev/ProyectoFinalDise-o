package org.mackas.service.impl;

import org.mackas.model.Docente;
import org.mackas.repository.interf.DocenteRepository;

import java.util.List;
import org.mackas.repository.impl.DocenteRepositoryImpl;

public class DocenteServiceImpl
implements DocenteRepository
{
     private DocenteRepositoryImpl repo= new DocenteRepositoryImpl();
  
    @Override
    public Docente findByIdUser(int idUser) {
      return repo.findByIdUser(idUser);
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
