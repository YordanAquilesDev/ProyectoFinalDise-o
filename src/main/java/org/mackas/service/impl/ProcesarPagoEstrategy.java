/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Pension;
import org.mackas.model.patron.PagoEstrategy;
import org.mackas.service.interf.IPensionDao;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class ProcesarPagoEstrategy {
    private PagoEstrategy metodoPago; 
    private IPensionDao pensionDao;  

    public ProcesarPagoEstrategy(IPensionDao pensionDao) {
        this.pensionDao = pensionDao;
    }

    // Permite cambiar la estrategia dinámicamente desde la UI
    public void setMetodoPago(PagoEstrategy metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean procesarYGuardarPago(Pension pension) {
        if (metodoPago == null) {
            throw new IllegalStateException("Debe seleccionar un método de pago.");
        }
        boolean pagoExitoso = metodoPago.procesarPago(pension);

        if (pagoExitoso) {
            return pensionDao.save(pension);
        }

        return false;
    }
}
