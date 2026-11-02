/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Date;
import java.util.List;
import org.mackas.model.Calificacion;
import org.mackas.repository.CalificacionRepositoryImpl;
import org.mackas.service.interf.ICalificacionDao;

/**
 *
 * @author Administrador
 */
public class CalificacionServiceImpl implements ICalificacionDao {
private ICalificacionDao repo= new CalificacionRepositoryImpl();

    @Override
    public List<Calificacion> findByIdCursoAlumno(int idCurso,int idAlumno) {
       return repo.findByIdCursoAlumno(idCurso,idAlumno);
    }

    @Override
    public Calificacion save(Calificacion beans) {
       return repo.save(beans);
     }


}
