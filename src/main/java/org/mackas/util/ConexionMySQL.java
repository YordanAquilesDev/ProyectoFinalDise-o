package org.mackas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Patron Singlenton
public class ConexionMySQL implements ConexionDataBase {
  
    Connection connection;
    private static ConexionMySQL instance;

    private ConexionMySQL() {
        connection = getConexion();
    }

    @Override
    public  Connection getConexion() {
     
        String url = "jdbc:mysql://localhost:3306/DB_universidad?useSSL=false&serverTimezone=UTC";
        String usuario = "root";
        String password = "root";
        try {
          
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null; 
        }
    }

    public  static ConexionMySQL getInstance() {
        if (instance == null) {
            instance = new ConexionMySQL();
        }
        return instance;
    }
    
  
}

