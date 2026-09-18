package org.mackas.model;

import java.util.List;

public class Alumno
        extends Usuario{
   String nombre;

    public Alumno(String codigo, String password) {
        super(codigo, password);
    }

    Calificacion calificacion;

}
