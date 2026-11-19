/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Time;
import java.util.List;
import org.mackas.model.Horario;
import org.mackas.repository.HorarioRepositoryImpl;
import org.mackas.service.interf.IHorarioDao;

/**
 *
 * @author Administrador
 */
public class HorarioServiceImpl implements IHorarioDao {
 private IHorarioDao repo;
 public HorarioServiceImpl(IHorarioDao repo){
     this.repo=repo;
 }
    @Override
    public List<Horario> findByIdAlumno(int idAlumno) {
        return repo.findByIdAlumno(idAlumno);
    }

 
}
