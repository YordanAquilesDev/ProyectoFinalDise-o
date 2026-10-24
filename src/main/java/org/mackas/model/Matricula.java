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
       
}
