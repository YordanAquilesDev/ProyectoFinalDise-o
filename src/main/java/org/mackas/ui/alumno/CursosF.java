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

        txtIdCurso.setText("CÓDIGO: #" + idCurso);
        txtNombre.setText(nombre);
        txtCreditos.setText("⚡ " + creditos + " Créditos");
        txtCarrera.setText(carrera);
        txtModalidad.setText("• " + modalidad);
        txtCiclo.setText("Ciclo " + ciclo);

        Dimension dimensionFija = new Dimension(500, 115);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 115));
    }

    private void initComponents() {
        txtNombre = new JLabel();
        txtModalidad = new JLabel();
        txtIdCurso = new JLabel();
        txtCreditos = new JLabel();
        txtCiclo = new JLabel();
        txtCarrera = new JLabel();

        setBackground(Color.WHITE);
        // Borde fino con sutil separación interna
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1, true),
                BorderFactory.createEmptyBorder(15, 18, 15, 18)
        ));

        txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtNombre.setForeground(new Color(15, 23, 42));

        txtModalidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtModalidad.setForeground(new Color(100, 116, 139));

        txtIdCurso.setFont(new Font("Segoe UI", Font.BOLD, 11));
        txtIdCurso.setForeground(new Color(79, 70, 229)); // Indigo moderno

        txtCreditos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtCreditos.setForeground(new Color(100, 116, 139));

        txtCiclo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtCiclo.setForeground(new Color(16, 185, 129)); // Verde esmeralda

        txtCarrera.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        txtCarrera.setForeground(new Color(148, 163, 184));

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
                                                .addGap(18, 18, 18)
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