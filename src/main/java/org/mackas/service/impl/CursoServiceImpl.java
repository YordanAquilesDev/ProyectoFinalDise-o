/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Curso;
import org.mackas.repository.CursoRepositoryImpl;
import org.mackas.service.interf.ICarreraDao;
import org.mackas.service.interf.ICursoDao;

/**
 *
 * @author Administrador
 */
public class CursoServiceImpl implements ICursoDao {

    private ICursoDao repo;
    public CursoServiceImpl(ICursoDao repo){
        this.repo=repo;
    }
    @Override
    public List<Curso> findByIdAlumno(int idAlumno) {
        return repo.findByIdAlumno(idAlumno);
    }

}
