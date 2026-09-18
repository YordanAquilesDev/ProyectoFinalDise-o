package org.mackas.model;

public  abstract  class Usuario {
    String codigo;
    String password;
    public Usuario(String codigo,String password){
        this.codigo=codigo;
        this.password=password;
    }


}
