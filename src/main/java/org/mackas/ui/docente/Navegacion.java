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
import org.mackas.config.Data;
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

    Data datos = new Data();
    Docente docente;
    Seccion seccion;

    public Navegacion(Seccion seccion) {
        initComponents();
        docente = datos.docente1;
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
        // TODO add your handling code here:
        // TODO add your handling code here:
        // 1. Limpiar el contenedor actual
        contenedor.removeAll();

        // 2. Crear y configurar el nuevo JPanel
        JPanel perfil = new JPanel();
        perfil.setLayout(new java.awt.GridLayout(0, 2, 10, 10)); // Layout para organizar etiquetas y valores

        // Ejemplo de instancia (aquí usas tu objeto docente real)
        // Docente docente = obtenerDocenteActual();
        if (docente != null) {
            perfil.add(new JLabel("Nombre:"));
            perfil.add(new JLabel(docente.getNombre()));

            perfil.add(new JLabel("Apellido:"));
            perfil.add(new JLabel(docente.getApellido()));

            perfil.add(new JLabel("DNI:"));
            perfil.add(new JLabel(docente.getDni()));

            perfil.add(new JLabel("Código:"));
            perfil.add(new JLabel(docente.getCodigo()));

            perfil.add(new JLabel("Correo Institucional:"));
            perfil.add(new JLabel(docente.getCorreo_institucional()));

            perfil.add(new JLabel("Teléfono:"));
            perfil.add(new JLabel(docente.getTelefono()));

            perfil.add(new JLabel("N° de Secciones:"));
            perfil.add(new JLabel(String.valueOf(docente.getSecciones().size())));
        } else {
            perfil.add(new JLabel("No se encontraron datos del docente."));
        }

        // 3. Agregar el panel cargado al contenedor
        contenedor.add(perfil);

        // 4. Refrescar la interfaz gráfica (imprescindible en Swing al modificar componentes dinámicamente)
        contenedor.revalidate();
        contenedor.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    
    contenedor.removeAll();

    // 2. Obtener el curso y los horarios desde la sección
    Curso curso = seccion.getCurso();
    List<Horario> horarios = seccion.getHorarios();
    String nombreCurso = (curso != null) ? curso.getNombre_curso() : "Curso no asignado";

    // 3. Crear el panel principal que contendrá todas las tarjetas
    JPanel panelListaCards = new JPanel();
    // BoxLayout en Y organiza las tarjetas una debajo de otra
    panelListaCards.setLayout(new javax.swing.BoxLayout(panelListaCards, javax.swing.BoxLayout.Y_AXIS));

    if (horarios != null && !horarios.isEmpty()) {
        for (Horario horario : horarios) {
            String aula = (horario.getAula() != null) ? horario.getAula() : "Por asignar";
            int totalAsistentes = (horario.getAlumnosAsistidos() != null) 
                    ? horario.getAlumnosAsistidos().size() 
                    : 0;

            // 4. Crear el JPanel para la tarjeta individual (Card)
            JPanel card = new JPanel();
            card.setLayout(new java.awt.GridLayout(0, 1, 5, 5)); // Organización interna en filas
            card.setBackground(new java.awt.Color(245, 245, 245)); // Color suave de fondo

            // Añadir un borde distintivo y margen a la tarjeta
            card.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createTitledBorder(
                    javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 180, 180), 1, true),
                    " Horario - " + nombreCurso + " "
                ),
                javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15) // Relleno interno (Padding)
            ));

            // 5. Agregar la información dentro de la tarjeta
            card.add(new javax.swing.JLabel("📚 Curso: " + nombreCurso));
            card.add(new javax.swing.JLabel("📅 Fecha: " + horario.getFecha()));
            card.add(new javax.swing.JLabel("⏰ Horario: " + horario.getHora_inicio() + " - " + horario.getHora_final()));
            card.add(new javax.swing.JLabel("🏫 Aula: " + aula));
            card.add(new javax.swing.JLabel("👥 Asistencias registradas: " + totalAsistentes + " alumnos"));

            // Ajustar tamaño máximo para que no se estiren excesivamente en BoxLayout
            card.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 140));

            // Agregar la tarjeta al panel contenedor de lista
            panelListaCards.add(card);
            
            // Espaciador vertical entre tarjetas
            panelListaCards.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 10)));
        }
    } else {
        JLabel lblVacio = new JLabel("No hay horarios registrados para la sección.");
        lblVacio.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelListaCards.add(lblVacio);
    }

    // 6. Colocar el panel de tarjetas dentro de un JScrollPane por si la lista es larga
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(panelListaCards);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Hace el scroll más fluido

    // 7. Configurar layout del contenedor principal y añadir
    contenedor.setLayout(new java.awt.BorderLayout());
    contenedor.add(scrollPane, java.awt.BorderLayout.CENTER);

    // 8. Refrescar la interfaz gráfica
    contenedor.revalidate();
    contenedor.repaint();
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

// 3. Llenar el modelo con los datos de los alumnos
        if (alumnos != null) {
            for (Alumno alumno : alumnos) {
                // Obtener la calificación del alumno (se asume métodos getters en Calificacion)
                Calificacion cal = alumno.getCalificacion();

                String n1 = (cal != null) ? cal.getPC1() : "-"; // Ajusta los getters según tu clase Calificacion
                String n2 = (cal != null) ? cal.getPC2() : "-";
                String n3 = (cal != null) ? cal.getPA() : "-";
                String n4 = (cal != null) ? cal.getEX() : "-";

                String carrera = (alumno.getCarrera_profesional() != null)
                        ? alumno.getCarrera_profesional().toString()
                        : "Sin carrera";

                Object[] fila = {
                    alumno.getCodigo(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    carrera,
                    n1, n2, n3, n4
                };

                model.addRow(fila);
            }
        }

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
