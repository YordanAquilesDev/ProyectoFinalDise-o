/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Date;
import java.util.List;
import org.mackas.model.Calificacion;
import org.mackas.repository.impl.CalificacionRepositoryImpl;
import org.mackas.service.interf.CalificacionService;

/**
 *
 * @author Administrador
 */
public class CalificacionServiceImpl implements CalificacionService {
private CalificacionRepositoryImpl repo= new CalificacionRepositoryImpl();
    @Override
    public List<Calificacion> findByIdCursoAlumno(int idCurso,int idAlumno) {
       return repo.findByIdCursoAlumno(idCurso,idAlumno);
    }

    @Override
    public Calificacion save(Calificacion beans) {
       return repo.save(beans);
     }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calificacion findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Calificacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
