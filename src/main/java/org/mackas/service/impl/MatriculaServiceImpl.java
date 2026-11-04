/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;
import org.mackas.repository.MatriculaRepositoryImpl;
import org.mackas.service.interf.IMatriculaDao;

/**
 *
 * @author Administrador
 */
public class MatriculaServiceImpl implements IMatriculaDao {

    private IMatriculaDao repo;
    public MatriculaServiceImpl(IMatriculaDao repo){
        this.repo=repo;
    }

    @Override
    public Matricula setMatricula(Matricula mt) {
        return repo.setMatricula(mt);
    }

    @Override
    public boolean isMatricula(int idAlumno) {
        return repo.isMatricula(idAlumno);
    }

    @Override
    public DetalleMatricula search(int idSeccion, int idAlumno) {
        return repo.search(idSeccion, idAlumno);
    }

    @Override
    public Matricula search(int idAlumno){
        return repo.search(idAlumno);
    }


}
