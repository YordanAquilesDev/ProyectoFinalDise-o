package org.mackas.model;

public  abstract  class Usuario {
    String telefono;
    String correo_institucional;
    String dni;
    String codigo;
    String password;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_institucional() {
        return correo_institucional;
    }

    public void setCorreo_institucional(String correo_institucional) {
        this.correo_institucional = correo_institucional;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String telefono,
                   String correo_institucional,
                   String dni,
                   String codigo,
                   String password) {
        this.telefono = telefono;
        this.correo_institucional = correo_institucional;
        this.dni = dni;
        this.codigo = codigo;
        this.password = password;
    }
}
