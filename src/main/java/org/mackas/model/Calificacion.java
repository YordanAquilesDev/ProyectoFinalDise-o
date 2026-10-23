package org.mackas.model;

import java.sql.Date;

public class Calificacion {
    int id_calificacion;
    int id_detalle_matricula;
    String mombre_evaluacion;
    double ponderado;
    double nota;
    Date fecha_registro;

    public int getId_calificacion() {
        return id_calificacion;
    }

    public int getId_detalle_matricula() {
        return id_detalle_matricula;
    }

    public String getMombre_evaluacion() {
        return mombre_evaluacion;
    }

    public double getPonderado() {
        return ponderado;
    }

    public double getNota() {
        return nota;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public void setId_detalle_matricula(int id_detalle_matricula) {
        this.id_detalle_matricula = id_detalle_matricula;
    }

    public void setMombre_evaluacion(String mombre_evaluacion) {
        this.mombre_evaluacion = mombre_evaluacion;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
 

}
