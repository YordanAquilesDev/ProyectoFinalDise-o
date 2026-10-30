/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.mackas.repository.interf;

import java.util.List;
import org.mackas.model.PeriodoAcademico;

/**
 *
 * @author Administrador
 */
public interface PeriodoAcademicoRepository {
    List<PeriodoAcademico> findAll();
}
