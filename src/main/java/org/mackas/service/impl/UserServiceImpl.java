/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import org.mackas.model.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;
import org.mackas.repository.UserRepositoryImpl;
import org.mackas.repository.UserRepositoryImpl;
import org.mackas.service.interf.IUsuarioDao;
import org.mackas.util.singlenton.ConexionMySQL;

public class UserServiceImpl implements IUsuarioDao {
 private IUsuarioDao repo;
 public UserServiceImpl(IUsuarioDao repoDao){
    this.repo=repoDao;

 }
    @Override
    public Usuario login(String codigo, String password) {
        return repo.login(codigo, password);
    }

}
