package org.mackas.config;

import org.mackas.model.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Data {
    Carrera ing_software = new Carrera("Ing. Software");
    Carrera ing_sistemas = new Carrera("Ing. Sistemas");

    List<Horario> horarios = List.of(
            new Horario("12/06/2026", "10:30", "11:30"),
            new Horario("13/06/2026", "10:30", "11:30"),
            new Horario("14/06/2026", "10:30", "11:30"),
            new Horario("15/06/2026", "10:30", "11:30"),
            new Horario("16/06/2026", "10:30", "11:30")
    );

    List<Alumno> alumnos = List.of(
            new Alumno("954152964", "juancarlos@gmail.com", "70542412", "U31751923", "Carlos123", "Juan Carlos", "Ronal Caceres", ing_software),
            new Alumno("954152964", "maria@gmail.com", "70542413", "U31751924", "Maria123", "Maria", "Lopez", ing_sistemas)
    );

 public   Seccion seccion1 = new Seccion("11111111111", new Curso("Cálculo II"), alumnos, horarios);

    AtomicInteger i = new AtomicInteger(1);
    List<Alumno> alumnosModificados = alumnos.stream()
            .map(a -> new Alumno(
                    a.getTelefono(),
                    a.getCorreo_institucional(),
                    a.getDni(),
                    a.getCodigo(),
                    a.getPassword(),
                    "Alumno " + i.getAndIncrement(),
                    a.getApellido(),
                    a.getCarrera_profesional()
            ))
            .toList();

   public Seccion seccion2 = new Seccion("0000000000", new Curso("Cálculo I"), alumnosModificados, horarios);

    // Docentes asignados a sus secciones
    public Docente docente1 = new Docente("954152964", "docente1@utp.edu.pe", "70542412", "D1001", "Pass123", "Roberto", "Gómez");
    public Docente docente2 = new Docente("987654321", "docente2@utp.edu.pe", "70542415", "D1002", "Pass123", "Ana", "Martínez");

    public List<Seccion> seccionesGlobales;
    public Alumno alumnoLogueado;

    public void Init() {
        // Asignamos las secciones a los docentes
        docente1.addSecction(seccion1);
        docente2.addSecction(seccion2);

        // Guardamos las secciones globales del sistema
        seccionesGlobales = List.of(seccion1, seccion2);

        // Alumno para pruebas en la vista
        alumnoLogueado = alumnos.get(0);
        // Si la clase Alumno maneja sus secciones matriculadas:
        alumnoLogueado.addSeccion(seccion1);
        alumnoLogueado.addSeccion(seccion2);
    }

    public List<Docente> getDocentes() {
        return List.of(docente1, docente2);
    }
}