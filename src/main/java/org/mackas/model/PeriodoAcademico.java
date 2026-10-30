/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.model;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class PeriodoAcademico {
    int id_periodo;
   String nombre; // cicl 3
   Date fecha_inicio;
   Date fecha_fin;
   boolean activo;
   

    public PeriodoAcademico(int id_periodo, String nombre, Date fecha_inicio, Date fecha_fin, boolean activo) {
        this.id_periodo = id_periodo;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.activo = activo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }
     public int getId_periodo() {
        return id_periodo;
    }
     
     public String toString(){
         return "Periodo" + nombre;
     }
}
