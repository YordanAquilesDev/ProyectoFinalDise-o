/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mackas.repository.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mackas.model.PeriodoAcademico;
import org.mackas.repository.interf.PeriodoAcademicoRepository;
import org.mackas.util.ConexionMySQL;

/**
 *
 * @author Administrador
 */
public class PeriodoAcademicoRepositoryImpl implements PeriodoAcademicoRepository {

    private Connection mysql = ConexionMySQL.getInstance().getConexion();

    @Override
    public List<PeriodoAcademico> findAll() {
        List<PeriodoAcademico> lista = new ArrayList<>();
        String sql = "{CALL sp_listar_periodo_academico()}";

        try (CallableStatement stmt = mysql.prepareCall(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PeriodoAcademico periodo = new PeriodoAcademico(
                        rs.getInt("id_periodo"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getBoolean("activo")
                );
                lista.add(periodo);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar periodos académicos: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
