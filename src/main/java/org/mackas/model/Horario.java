package org.mackas.model;

import java.util.List;

public class Horario {
    String fecha="12/05/2026";
    String hora_inicio="13.15";
    String hora_final="14.45";
    String aula;

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    List<Alumno> alumnosAsistidos;

    public Horario(String fecha, String hora_inicio, String hora_final) {
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public List<Alumno> getAlumnosAsistidos() {
        return alumnosAsistidos;
    }

    public void setAlumnosAsistidos(List<Alumno> alumnosAsistidos) {
        this.alumnosAsistidos = alumnosAsistidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
