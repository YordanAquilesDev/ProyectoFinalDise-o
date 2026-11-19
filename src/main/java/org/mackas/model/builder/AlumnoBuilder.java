package org.mackas.model.builder;

import java.sql.Date;
import org.mackas.model.Alumno;

public class AlumnoBuilder {
    private Alumno alumno = new Alumno();

    public AlumnoBuilder setIdAlumno(int idAlumno) {
        alumno.setIdAlumno(idAlumno);
        return this;
    }

    public AlumnoBuilder setIdCarrera(int idCarrera) {
        alumno.setIdCarrera(idCarrera);
        return this;
    }

    public AlumnoBuilder setCodigo(String codigo) {
        alumno.setCodigo(codigo);
        return this;
    }

    public AlumnoBuilder setFechaNacimiento(Date fechaNacimiento) {
        alumno.setFechaNacimiento(fechaNacimiento);
        return this;
    }

    // Atributos heredados de la clase Usuario
    public AlumnoBuilder setIdUsuario(int idUsuario) {
        alumno.setIdUsuario(idUsuario);
        return this;
    }

    public AlumnoBuilder setUsername(String username) {
        alumno.setUsername(username);
        return this;
    }

    public AlumnoBuilder setPasswordHash(String passwordHash) {
        alumno.setPasswordHash(passwordHash);
        return this;
    }

    public AlumnoBuilder setRol(String rol) {
        alumno.setRol(rol);
        return this;
    }

    public AlumnoBuilder setEstado(boolean estado) {
        alumno.setEstado(estado);
        return this;
    }

    public AlumnoBuilder setNombres(String nombres) {
        alumno.setNombres(nombres);
        return this;
    }

    public AlumnoBuilder setApellidos(String apellidos) {
        alumno.setApellidos(apellidos);
        return this;
    }

    public AlumnoBuilder setDni(String dni) {
        alumno.setDni(dni);
        return this;
    }

    public AlumnoBuilder setEmail(String email) {
        alumno.setEmail(email);
        return this;
    }

    public AlumnoBuilder setTelefono(String telefono) {
        alumno.setTelefono(telefono);
        return this;
    }

    // Método final para retornar la instancia construida
    public Alumno build() {
        return alumno;
    }
}