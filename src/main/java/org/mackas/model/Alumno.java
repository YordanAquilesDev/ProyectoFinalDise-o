package org.mackas.model;

import java.sql.Date;

public class Alumno extends Usuario {

    private int idAlumno;
    private int idCarrera;
    private String codigo; // Código institucional del alumno (Ej: ALU2026001)
    private Date fechaNacimiento;

    // Constructor vacío
    public Alumno() {
        super();
    }

    // Constructor completo
    public Alumno(int idUsuario, String username, String passwordHash, String rol, boolean estado,
                  int idAlumno, int idCarrera, String codigo, String nombres, String apellidos, 
                  String dni, String email, String telefono, Date fechaNacimiento) {
        super(idUsuario, username, passwordHash, rol, estado);
        this.idAlumno = idAlumno;
        this.idCarrera = idCarrera;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
        // Constructor para crear alumnos
    public Alumno(
                  int idAlumno, int idCarrera, String codigo, String nombres, String apellidos, 
                  String dni, String email, String telefono, Date fechaNacimiento) {
   
        this.idAlumno = idAlumno;
        this.idCarrera = idCarrera;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters específicos de Alumno
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", idUsuario=" + idUsuario +
                ", idCarrera=" + idCarrera +
                ", codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}