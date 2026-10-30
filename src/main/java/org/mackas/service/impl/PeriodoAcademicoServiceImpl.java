/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.mackas.model.PeriodoAcademico;
import org.mackas.repository.impl.PeriodoAcademicoRepositoryImpl;
import org.mackas.service.interf.PeriodoAcademicoService;

/**
 *
 * @author Administrador
 */
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
private PeriodoAcademicoRepositoryImpl repo= new PeriodoAcademicoRepositoryImpl();
    @Override
    public List<PeriodoAcademico> findAll() {     
        return repo.findAll();
    }
}
