package org.mackas.model;

import java.util.List;

public class Docente
        extends Usuario{

    public Docente(String codigo, String password) {
        super(codigo, password);
    }
    List<Seccion> secciones;
}
