package org.mackas.model;

public class Docente extends Usuario {

    private int idDocente;
    private String codigo; // Código institucional del docente (Ej: DOC101)
    private String especialidad;

    public Docente() {
        super();
    }

    public Docente(int idUsuario, String username, String passwordHash, String rol, boolean estado,
                   int idDocente, String codigo, String nombres, String apellidos, 
                   String dni, String email, String telefono, String especialidad) {
        super(idUsuario, username, passwordHash, rol, estado);
        this.idDocente = idDocente;
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}