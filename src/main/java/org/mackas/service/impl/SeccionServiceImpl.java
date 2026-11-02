/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Seccion;
import org.mackas.repository.SeccionRepositoryImpl;

import org.mackas.service.interf.ISeccionDao;

/**
 *
 * @author Administrador
 */
public class SeccionServiceImpl implements ISeccionDao {

    private ISeccionDao repo = new SeccionRepositoryImpl();

    @Override
    public List<Seccion> findByIdPeriodo(int idPeriodo) {
        return repo.findByIdPeriodo(idPeriodo);
    }

    @Override
    public List<Seccion> findByIdDocente(int idDocente) {
        return repo.findByIdDocente(idDocente);
    }

    @Override
    public List<Seccion> findByIdAlumno(int idEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
