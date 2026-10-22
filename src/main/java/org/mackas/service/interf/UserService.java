/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.interf;

import org.mackas.model.Usuario;

/**
 *
 * @author Administrador
 */
public interface UserService {
   Usuario login(String codigo,String password);
}
