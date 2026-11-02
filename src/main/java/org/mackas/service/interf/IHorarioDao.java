/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.service.interf;

import java.util.List;
import org.mackas.model.Horario;


/**
 *
 * @author Administrador
 */
public interface IHorarioDao  {
    List<Horario>  findByIdAlumno(int idAlumno);
}
