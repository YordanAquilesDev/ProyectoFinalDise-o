package org.mackas.service.impl;

import org.mackas.model.Docente;
import org.mackas.service.interf.IDocenteDao;

import java.util.List;
import org.mackas.repository.DocenteRepositoryImpl;

public class DocenteServiceImpl
implements IDocenteDao
{
     private IDocenteDao repo= new DocenteRepositoryImpl();
  
    @Override
    public Docente findByIdUser(int idUser) {
      return repo.findByIdUser(idUser);
    }

  
}
