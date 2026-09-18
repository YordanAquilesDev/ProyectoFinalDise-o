package org.mackas.util;

import java.sql.Connection;


// Patron Singlenton
public class ConexionMySQL implements ConexionDataBase{
    Connection connection;
    ConexionMySQL instance;
    private ConexionMySQL(){
        connection= getConexion();
    }

    @Override
    public Connection getConexion() {
        return null;
    }

    public ConexionMySQL getInstance(){
        if(instance==null){
            instance= new ConexionMySQL();
        }
        return instance;
    }
}
