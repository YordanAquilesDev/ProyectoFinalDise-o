package org.mackas.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Horario {
   int id_horario;
   int id_seccion;
   String dia_semana;
   Time hora_inicio;
   Time hora_fin;
   String aula;

    public Horario() {
    }

    public Horario(int id_horario, int id_seccion, String dia_semana, Time hora_inicio, Time hora_fin, String aula) {
        this.id_horario = id_horario;
        this.id_seccion = id_seccion;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.aula = aula;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

}
