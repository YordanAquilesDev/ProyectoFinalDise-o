/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.Horario;
import org.mackas.util.CrudRepository;

/**
 *
 * @author Administrador
 */
public interface HorarioRepository extends CrudRepository<Horario,Integer>{
       List<Horario>  findByIdAlumno(int idAlumno);
}
