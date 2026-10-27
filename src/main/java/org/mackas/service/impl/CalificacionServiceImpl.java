/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Date;
import java.util.List;
import org.mackas.model.Calificacion;
import org.mackas.service.interf.CalificacionService;

/**
 *
 * @author Administrador
 */
public class CalificacionServiceImpl implements CalificacionService {

    @Override
    public List<Calificacion> findByIdCurso(int idCurso) {
        Calificacion cal1 = new Calificacion();
        cal1.setId_calificacion(1);
        cal1.setId_detalle_matricula(101);
        cal1.setMombre_evaluacion("Evaluación Parcial");
        cal1.setPonderado(0.40);
        cal1.setNota(15.5);
        // Forma correcta de instanciar java.sql.Date
        cal1.setFecha_registro(new java.sql.Date(System.currentTimeMillis()));

        Calificacion cal2 = new Calificacion();
        cal2.setId_calificacion(2);
        cal2.setId_detalle_matricula(101);
        cal2.setMombre_evaluacion("Evaluación Final");
        cal2.setPonderado(0.60);
        cal2.setNota(17.0);
        cal2.setFecha_registro(new java.sql.Date(System.currentTimeMillis()));

        return List.of(cal1, cal2);
    }

    @Override
    public Calificacion save(Calificacion beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public Calificacion update(Calificacion beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
