/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Matricula;
import org.mackas.repository.impl.MatriculaRepositoryImpl;
import org.mackas.service.interf.MatriculaService;

/**
 *
 * @author Administrador
 */
public class MatriculaServiceImpl implements MatriculaService{
private MatriculaRepositoryImpl repo= new MatriculaRepositoryImpl();
    @Override
    public Matricula setMatricula(Matricula mt) {
        // much mas logicxa 
        return null;
     }

    @Override
    public boolean isMatricula(int idAlumno) {
        return repo.isMatricula(idAlumno);
       }
    
    
    
}
