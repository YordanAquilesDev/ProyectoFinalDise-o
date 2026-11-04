package org.mackas.model.builder;

import org.mackas.model.Docente;

public class DocenteBuilder {
    private Docente docente = new Docente();

    // Atributos específicos de Docente
    public DocenteBuilder setIdDocente(int idDocente) {
        docente.setIdDocente(idDocente);
        return this;
    }

    public DocenteBuilder setCodigo(String codigo) {
        docente.setCodigo(codigo);
        return this;
    }

    public DocenteBuilder setEspecialidad(String especialidad) {
        docente.setEspecialidad(especialidad);
        return this;
    }

    // Atributos heredados de la clase Usuario
    public DocenteBuilder setIdUsuario(int idUsuario) {
        docente.setIdUsuario(idUsuario);
        return this;
    }

    public DocenteBuilder setUsername(String username) {
        docente.setUsername(username);
        return this;
    }

    public DocenteBuilder setPasswordHash(String passwordHash) {
        docente.setPasswordHash(passwordHash);
        return this;
    }

    public DocenteBuilder setRol(String rol) {
        docente.setRol(rol);
        return this;
    }

    public DocenteBuilder setEstado(boolean estado) {
        docente.setEstado(estado);
        return this;
    }

    public DocenteBuilder setNombres(String nombres) {
        docente.setNombres(nombres);
        return this;
    }

    public DocenteBuilder setApellidos(String apellidos) {
        docente.setApellidos(apellidos);
        return this;
    }

    public DocenteBuilder setDni(String dni) {
        docente.setDni(dni);
        return this;
    }

    public DocenteBuilder setEmail(String email) {
        docente.setEmail(email);
        return this;
    }

    public DocenteBuilder setTelefono(String telefono) {
        docente.setTelefono(telefono);
        return this;
    }

    // Método final para retornar la instancia construida
    public Docente build() {
        return docente;
    }
}