package org.mackas.model;

import java.util.ArrayList;
import java.util.List;

public class Docente
        extends Usuario{

    String nombre;
    String apellido;

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    List<Seccion> secciones;

    public Docente(String telefono,
                   String correo_institucional,
                   String dni,
                   String codigo,
                   String password,
                   String nombre,
                   String apellido) {
        super(telefono, correo_institucional, dni, codigo, password);
        this.nombre= nombre;
        this.apellido=apellido;
        secciones= new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addSecction(Seccion seccion){
        secciones.add(seccion);
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }
}
