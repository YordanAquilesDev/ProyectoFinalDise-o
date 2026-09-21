package org.mackas.model;

import java.util.List;

public class Seccion {
    String codigo_seccion;
    Curso curso;
    List<Alumno> alumnos;
    List<Horario> horarios;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Seccion(String codigo_seccion, Curso curso, List<Alumno> alumnos, List<Horario> horarios) {
        this.codigo_seccion=codigo_seccion;
        this.curso = curso;
        this.alumnos = alumnos;
        this.horarios = horarios;
    }
}
