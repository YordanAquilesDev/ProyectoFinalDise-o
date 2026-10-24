/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Usuario;
import org.mackas.service.interf.UserService;
import org.mackas.util.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;

public class UserServiceImpl implements UserService {

    @Override
    public Usuario login(String codigo, String password) {
        return new Alumno();
    }

}
