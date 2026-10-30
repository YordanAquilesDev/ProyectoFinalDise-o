package org.mackas.ui.alumno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Time;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class HorariosF extends JPanel {

    private JLabel txtSemanaNr;
    private JLabel txtAula;
    private JLabel txtHorario;
    private JLabel txtIdSeccion;

    public HorariosF(String aula, Time hora_fin, Time hora_inicio, int id_horario, int id_seccion, String semana) {
        initComponents();
        
        // Asignación de valores con formato más limpio y legible
        txtSemanaNr.setText(semana != null ? semana.toUpperCase() : "DÍA");
        txtAula.setText("🏫 Aula: " + aula);
        txtIdSeccion.setText("Sección: " + id_seccion);
        
        // Formatear horas en un solo texto limpio (Ej: 08:00:00 - 10:00:00)
        String inicioStr = (hora_inicio != null) ? hora_inicio.toString().substring(0, 5) : "--:--";
        String finStr = (hora_fin != null) ? hora_fin.toString().substring(0, 5) : "--:--";
        txtHorario.setText("🕒 " + inicioStr + " hrs  -  " + finStr + " hrs");

        // Tamaño optimizado para listar en JScrollPane vertical
        Dimension dimensionFija = new Dimension(480, 85);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));
    }

    private void initComponents() {
        txtSemanaNr = new JLabel();
        txtAula = new JLabel();
        txtHorario = new JLabel();
        txtIdSeccion = new JLabel();

        setBackground(Color.WHITE);
        // Borde elegante con una ligera sombra visual y padding interno
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));

        // Estilos tipográficos modernos
        txtSemanaNr.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtSemanaNr.setForeground(new Color(30, 41, 59)); // Azul oscuro elegante

        txtAula.setFont(new Font("Segoe UI", Font.BOLD, 13));
        txtAula.setForeground(new Color(234, 88, 12)); // Naranja vibrante para el aula

        txtHorario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtHorario.setForeground(new Color(71, 85, 105)); // Gris profesional

        txtIdSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtIdSeccion.setForeground(new Color(148, 163, 184)); // Gris sutil

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSemanaNr)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdSeccion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAula))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHorario)
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSemanaNr)
                    .addComponent(txtIdSeccion)
                    .addComponent(txtAula))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}