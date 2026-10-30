/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.model;

/**
 *
 * @author Administrador
 */
public class DetalleMatricula {
    int id_detalle_matricula;
    int id_matricula;
    int id_seccion;
    double promedio_final;
    String estado;

    public DetalleMatricula(int id_matricula, int id_seccion) {
        this.id_matricula = id_matricula;
        this.id_seccion = id_seccion;
        this.promedio_final=0.0;
        this.estado="PROCESO";
    }

    public DetalleMatricula() {
     }

    public int getId_detalle_matricula() {
        return id_detalle_matricula;
    }

    public void setId_detalle_matricula(int id_detalle_matricula) {
        this.id_detalle_matricula = id_detalle_matricula;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public double getPromedio_final() {
        return promedio_final;
    }

    public void setPromedio_final(double promedio_final) {
        this.promedio_final = promedio_final;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
