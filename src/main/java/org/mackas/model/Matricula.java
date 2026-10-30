package org.mackas.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Matricula {
    int id_alumno;
    int id_periodo;
    Time fecha_matricula;
    double monto_total;
    String estado;
    List<DetalleMatricula> detalle_matricula= new ArrayList<>();
    
    public void addSecction(DetalleMatricula dt){
        detalle_matricula.add(dt);
    }

    public Matricula(int id_alumno, int id_periodo, double monto_total) {
        this.id_alumno = id_alumno;
        this.id_periodo = id_periodo;
        this.monto_total = monto_total;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public Time getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(Time fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleMatricula> getDetalle_matricula() {
        return detalle_matricula;
    }

    public void setDetalle_matricula(List<DetalleMatricula> detalle_matricula) {
        this.detalle_matricula = detalle_matricula;
    }
       
}
