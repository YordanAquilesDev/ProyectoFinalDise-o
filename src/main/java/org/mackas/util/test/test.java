/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.util.test;

import org.mackas.model.Pension;
import org.mackas.model.patron.PagoBCP;
import org.mackas.model.patron.PagoEstrategy;
import org.mackas.service.impl.PensionServiceImpl;
import org.mackas.service.impl.ProcesarPagoEstrategy;
import org.mackas.service.interf.IPensionDao;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class test {
    public static void main(String[] args) {
        PagoEstrategy metodoPago= new PagoBCP();
        IPensionDao pensionDao= new PensionServiceImpl();
        ProcesarPagoEstrategy proPago= new ProcesarPagoEstrategy(pensionDao);
        proPago.procesarYGuardarPago(new Pension());
    
    }
    
}
