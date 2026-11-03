/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.model.patron;

import org.mackas.model.Pension;

/**
 *
 * @author LAB-USR-LNORTE
 */
public class PagoVisa implements PagoEstrategy{

    @Override
    public boolean procesarPago(Pension pension) {

      System.out.println("se pago con visa");
        return true;
    }

}
