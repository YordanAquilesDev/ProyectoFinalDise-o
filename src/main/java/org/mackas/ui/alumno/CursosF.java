package org.mackas.ui.alumno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class CursosF extends JPanel {

    private JLabel txtCarrera;
    private JLabel txtCiclo;
    private JLabel txtCreditos;
    private JLabel txtIdCurso;
    private JLabel txtModalidad;
    private JLabel txtNombre;

    public CursosF(int idCurso, String nombre, int creditos, String carrera, String modalidad, int ciclo) {
        initComponents();
        
        txtIdCurso.setText("ID: " + idCurso);
        txtNombre.setText(nombre);
        txtCreditos.setText(creditos + " Créditos");
        txtCarrera.setText(carrera);
        txtModalidad.setText("Modalidad: " + modalidad);
        txtCiclo.setText("Ciclo " + ciclo);

        Dimension dimensionFija = new Dimension(500, 110);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
    }

    private void initComponents() {
        txtNombre = new JLabel();
        txtModalidad = new JLabel();
        txtIdCurso = new JLabel();
        txtCreditos = new JLabel();
        txtCiclo = new JLabel();
        txtCarrera = new JLabel();

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));

        txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtNombre.setForeground(new Color(30, 41, 59));

        txtModalidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtModalidad.setForeground(new Color(100, 116, 139));

        txtIdCurso.setFont(new Font("Segoe UI", Font.BOLD, 11));
        txtIdCurso.setForeground(new Color(79, 70, 229)); // Acento indigo/azul

        txtCreditos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCreditos.setForeground(new Color(100, 116, 139));

        txtCiclo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtCiclo.setForeground(new Color(16, 185, 129)); // Verde sutil

        txtCarrera.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        txtCarrera.setForeground(new Color(100, 116, 139));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdCurso)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCarrera))
                    .addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtModalidad)
                        .addGap(30, 30, 30)
                        .addComponent(txtCreditos)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCiclo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCurso)
                    .addComponent(txtCarrera))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModalidad)
                    .addComponent(txtCreditos)
                    .addComponent(txtCiclo))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}