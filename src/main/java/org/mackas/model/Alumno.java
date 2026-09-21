package org.mackas.model;


import java.util.ArrayList;
import java.util.List;

public class Alumno
        extends Usuario{
   String nombre;
   String apellido;
   Carrera carrera_profesional;
    Calificacion calificacion=new Calificacion("13","14","16","18");
  List<Seccion> secciones;
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Carrera getCarrera_profesional() {
        return carrera_profesional;
    }

    public void setCarrera_profesional(Carrera carrera_profesional) {
        this.carrera_profesional = carrera_profesional;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public Alumno(String telefono,
                  String correo_institucional,
                  String dni,
                  String codigo,
                  String password,
                  String nombre,
                  String apellido,
                  Carrera carrera_profesional
    ) {
        super(telefono, correo_institucional, dni, codigo, password);
        this.apellido=apellido;
        this.nombre=nombre;
        this.carrera_profesional=carrera_profesional;
        this.secciones= new ArrayList<>();
    }

    public void addSeccion(Seccion seccion){
        secciones.add(seccion);
    }
}
