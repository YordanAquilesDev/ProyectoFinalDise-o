/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import org.mackas.model.Pension;
import org.mackas.model.patron.PagoEstrategy;

/**
 *
 * @author LAB-USR-LNORTE
 */
public interface IPensionDao {
    boolean save(Pension p);
}
