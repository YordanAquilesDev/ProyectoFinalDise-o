/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.mackas.model.Seccion;
import org.mackas.repository.impl.SeccionRepositoryImpl;
import org.mackas.repository.interf.SeccionRepository;
import org.mackas.service.interf.SeccionService;

/**
 *
 * @author Administrador
 */
public class SeccionServiceImpl implements SeccionService {
 private SeccionRepository repo= new SeccionRepositoryImpl();
    @Override
    public List<Seccion> findByIdPeriodo(int idPeriodo) {
      return repo.findByIdPeriodo(idPeriodo);
    }

    @Override
    public List<Seccion> findByIdDocente(int idDocente) {
       return repo.findByIdDocente(idDocente);
    }
}
