package org.mackas.model;

public class Curso {
    int id_curso;
    int id_carrera;
    String codigo_curso;
    String nombre_curso;
    int creditos;
    int ciclo_nivel;

    public Curso(int id_curso, int id_carrera, String codigo_curso, String nombre_curso, int creditos, int ciclo_nivel) {
        this.id_curso = id_curso;
        this.id_carrera = id_carrera;
        this.codigo_curso = codigo_curso;
        this.nombre_curso = nombre_curso;
        this.creditos = creditos;
        this.ciclo_nivel = ciclo_nivel;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCiclo_nivel() {
        return ciclo_nivel;
    }

    public void setCiclo_nivel(int ciclo_nivel) {
        this.ciclo_nivel = ciclo_nivel;
    }

    
   
  
 
}
