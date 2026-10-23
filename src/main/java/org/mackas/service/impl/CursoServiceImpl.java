/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Curso;
import org.mackas.repository.impl.CursoRepositoryImpl;
import org.mackas.service.interf.CursoService;

/**
 *
 * @author Administrador
 */
public class CursoServiceImpl implements CursoService {
 private CursoRepositoryImpl repo;
    @Override
   public List<Curso> findByIdAlumno(int idAlumno) {
    // Retorna una lista inmutable con 3 cursos de prueba
    return List.of(
        new Curso(1, 101, "MAT101", "Matemática I", 4, 1),
        new Curso(2, 101, "PROG101", "Programación I", 5, 1),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2),
        new Curso(3, 102, "BD201", "Bases de Datos I", 4, 2)
        
    );
    // return repo.finByIdAlumno(idAlumno);
}

    @Override
    public Curso save(Curso beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso update(Curso beans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Curso findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
