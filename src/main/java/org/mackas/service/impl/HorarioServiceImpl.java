/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Time;
import java.util.List;
import org.mackas.model.Horario;
import org.mackas.service.interf.HorariosService;

/**
 *
 * @author Administrador
 */
public class HorarioServiceImpl implements HorariosService {

    @Override
    public List<Horario> findByIdAlumno(int idAlumno) {
        return List.of(
                new Horario(1, 101, "Lunes", Time.valueOf("08:00:00"), Time.valueOf("10:00:00"), "Aula 101"),
                new Horario(2, 102, "Miércoles", Time.valueOf("10:00:00"), Time.valueOf("12:00:00"), "Lab 3"),
                new Horario(3, 103, "Viernes", Time.valueOf("14:00:00"), Time.valueOf("16:00:00"), "Aula 204"),
                 new Horario(1, 101, "Lunes", Time.valueOf("08:00:00"), Time.valueOf("10:00:00"), "Aula 101"),
                new Horario(2, 102, "Miércoles", Time.valueOf("10:00:00"), Time.valueOf("12:00:00"), "Lab 3"),
                new Horario(3, 103, "Viernes", Time.valueOf("14:00:00"), Time.valueOf("16:00:00"), "Aula 204"),
                 new Horario(1, 101, "Lunes", Time.valueOf("08:00:00"), Time.valueOf("10:00:00"), "Aula 101"),
                new Horario(2, 102, "Miércoles", Time.valueOf("10:00:00"), Time.valueOf("12:00:00"), "Lab 3"),
                new Horario(3, 103, "Viernes", Time.valueOf("14:00:00"), Time.valueOf("16:00:00"), "Aula 204")
        );
    }

    @Override
    public Horario save(Horario beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Horario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario update(Horario beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
