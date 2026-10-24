/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.mackas.model.PeriodoAcademico;
import org.mackas.service.interf.PeriodoAcademicoService;

/**
 *
 * @author Administrador
 */
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {

    @Override
    public List<PeriodoAcademico> findAll() {
        List<PeriodoAcademico> listaPeriodos = new ArrayList<>();

        // Formato: Date.valueOf("YYYY-MM-DD")
        PeriodoAcademico p1 = new PeriodoAcademico(
                1,
                "Ciclo 2026-I",
                Date.valueOf("2026-03-01"),
                Date.valueOf("2026-07-31"),
                true
        );

        PeriodoAcademico p2 = new PeriodoAcademico(
                2,
                "Ciclo 2026-II",
                Date.valueOf("2026-08-15"),
                Date.valueOf("2026-12-20"),
                false
        );

        PeriodoAcademico p3 = new PeriodoAcademico(
                3,
                "Ciclo 2027-I",
                Date.valueOf("2027-03-01"),
                Date.valueOf("2027-07-31"),
                false
        );

        listaPeriodos.add(p1);
        listaPeriodos.add(p2);
        listaPeriodos.add(p3);

        return listaPeriodos;
    }
}
