/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.mackas.ui.docente;

import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.mackas.model.Alumno;
import org.mackas.model.Calificacion;
import org.mackas.model.Curso;
import org.mackas.model.Docente;
import org.mackas.model.Horario;
import org.mackas.model.Seccion;

/**
 *
 * @author Yordan
 */
public class Navegacion extends javax.swing.JPanel {


    Docente docente;
    Seccion seccion;

    public Navegacion(Seccion seccion) {
        initComponents();

        this.seccion = seccion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("Perfil Docente");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Alumnos Seccion");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Horarios");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        jButton4.setText("Cerrar Sesion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(12, 12, 12)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        contenedor.removeAll();

        List<Alumno> alumnos = seccion.getAlumnos();

// 1. Definir los nombres de las columnas
        String[] columnas = {
            "Código", "Nombre", "Apellido", "Carrera",
            "Nota 1", "Nota 2", "Nota 3", "Nota 4"
        };

// 2. Crear el modelo de la tabla e impedir la edición directa de celdas
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas sean de solo lectura
            }
        };

// 4. Crear el JTable con el modelo
        JTable tablaAlumnos = new JTable(model);

// 5. Envolver el JTable en un JScrollPane (imprescindible para ver encabezados)
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tablaAlumnos);

// Si el contenedor no tiene un LayoutManager adecuado (como BorderLayout), asignamos uno
        contenedor.setLayout(new java.awt.BorderLayout());
        contenedor.add(scrollPane, java.awt.BorderLayout.CENTER);

// 6. Refrescar el contenedor principal
        contenedor.revalidate();
        contenedor.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
