/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Pension;
import org.mackas.service.interf.IPensionDao;

/**
 *
 * @author LAB-USR-LNORTE
 */
// creo no sera nesesario el ProcesarPagoEstrategy mejor que lo mande directo al repo
public class PensionServiceImpl implements IPensionDao {

    @Override
    public boolean save(Pension p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Pension> findByIdMatricula(int idMatricula){

    }
    
}
