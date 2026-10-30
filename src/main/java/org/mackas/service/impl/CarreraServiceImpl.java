/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Carrera;
import org.mackas.repository.impl.CarreraRepositoryImpl;
import org.mackas.service.interf.CarreraService;

/**
 *
 * @author Administrador
 */
public class CarreraServiceImpl implements CarreraService {

    private CarreraRepositoryImpl repo= new CarreraRepositoryImpl();
    @Override
    public Carrera save(Carrera beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Carrera> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @Override
    public Carrera findById(Integer id) {
        return repo.findById(id);
    }
    
}
