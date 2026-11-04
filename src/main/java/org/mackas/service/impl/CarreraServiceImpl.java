/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Carrera;
import org.mackas.repository.CarreraRepositoryImpl;
import org.mackas.service.interf.ICarreraDao;

/**
 *
 * @author Administrador
 */
public class CarreraServiceImpl implements ICarreraDao {

    private ICarreraDao repo;
    public CarreraServiceImpl(ICarreraDao repo){
        this.repo=repo;
    }
   
    @Override
    public Carrera findById(Integer id) {
        return repo.findById(id);
    }
    
}
