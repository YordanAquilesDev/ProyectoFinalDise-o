/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.model.patron;

/**
 *
 * @author LAB-USR-LNORTE
 */

import org.mackas.model.Pension;

public interface PagoEstrategy {
    boolean procesarPago(Pension pension);
}