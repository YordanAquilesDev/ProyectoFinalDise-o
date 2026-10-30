package org.mackas.model;


public class Seccion {
    int id_seccion;
    int id_curso;
    int id_docente;
    int id_periodo;
    String codigo_seccion;
    String aula;
    int cupo_max;

    public String toString(){
        return "Seccion" + codigo_seccion;
    }
    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_docente() {
        return id_docente;
    }

    public void setId_docente(int id_docente) {
        this.id_docente = id_docente;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getCupo_max() {
        return cupo_max;
    }

    public void setCupo_max(int cupo_max) {
        this.cupo_max = cupo_max;
    }

}
