/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.mackas.model.Seccion;
import org.mackas.service.interf.SeccionService;

/**
 *
 * @author Administrador
 */
public class SeccionServiceImpl implements SeccionService {

    @Override
    public List<Seccion> findByIdPeriodo(int idPeriodo) {
        List<Seccion> listaSecciones = new ArrayList<>();

        // Simulamos datos de prueba estáticos en memoria
        // Solo agregaremos secciones si el idPeriodo coincide (por ejemplo, periodo 1 o 2)
        if (idPeriodo == 1) {
            Seccion s1 = new Seccion();
            s1.setId_seccion(101);
            s1.setId_curso(10);
            s1.setId_docente(1);
            s1.setId_periodo(1);
            s1.setCodigo_seccion("SEC-101");
            s1.setAula("Lab-Computo 1");
            s1.setCupo_max(30);
            listaSecciones.add(s1);

            Seccion s2 = new Seccion();
            s2.setId_seccion(102);
            s2.setId_curso(11);
            s2.setId_docente(2);
            s2.setId_periodo(1);
            s2.setCodigo_seccion("SEC-102");
            s2.setAula("Aula 204");
            s2.setCupo_max(25);
            listaSecciones.add(s2);

        } else if (idPeriodo == 2) {
            Seccion s3 = new Seccion();
            s3.setId_seccion(201);
            s3.setId_curso(12);
            s3.setId_docente(3);
            s3.setId_periodo(2);
            s3.setCodigo_seccion("SEC-201");
            s3.setAula("Auditorio B");
            s3.setCupo_max(40);
            listaSecciones.add(s3);
        }

        // Si el idPeriodo no tiene datos configurados, devolverá una lista vacía (sin errores)
        return listaSecciones;
    }
}
