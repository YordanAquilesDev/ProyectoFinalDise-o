/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.List;
import org.mackas.model.Pension;
import org.mackas.repository.PensionRepositoryImpl;
import org.mackas.service.interf.IPensionDao;

/**
 *
 * @author LAB-USR-LNORTE
 */
// creo no sera nesesario el ProcesarPagoEstrategy mejor que lo mande directo al repo
public class PensionServiceImpl implements IPensionDao {
    private IPensionDao repo ;
    public PensionServiceImpl(IPensionDao repo){
        this.repo = repo;
    }


    @Override
    public boolean save(Pension p) {
     return repo.save(p);
    }

    @Override
    public List<Pension> findByIdAlumno(int idAlumno) {
        return repo.findByIdAlumno(idAlumno);
    }

}
