package org.mackas.model;

public class Curso {
 String nombre_curso;

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    Calificacion calificacion=new Calificacion("13","14","16","18");
}
