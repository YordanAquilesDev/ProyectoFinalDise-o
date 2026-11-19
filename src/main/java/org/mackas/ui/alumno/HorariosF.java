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
        
        txtSemanaNr.setText(semana != null ? semana.toUpperCase() : "DÍA");
        txtAula.setText("🏫 Aula: " + aula);
        txtIdSeccion.setText("Sec. " + id_seccion);
        
        String inicioStr = (hora_inicio != null) ? hora_inicio.toString().substring(0, 5) : "--:--";
        String finStr = (hora_fin != null) ? hora_fin.toString().substring(0, 5) : "--:--";
        txtHorario.setText("🕒 " + inicioStr + " hrs  -  " + finStr + " hrs");

        Dimension dimensionFija = new Dimension(480, 90);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
    }

    private void initComponents() {
        txtSemanaNr = new JLabel();
        txtAula = new JLabel();
        txtHorario = new JLabel();
        txtIdSeccion = new JLabel();

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1, true),
            BorderFactory.createEmptyBorder(14, 18, 14, 18)
        ));

        txtSemanaNr.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtSemanaNr.setForeground(new Color(15, 23, 42));

        txtAula.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtAula.setForeground(new Color(225, 29, 72)); // Rosa/Rojo moderno para destacar ubicación

        txtHorario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtHorario.setForeground(new Color(71, 85, 105));

        txtIdSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtIdSeccion.setForeground(new Color(148, 163, 184));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSemanaNr)
                        .addGap(15, 15, 15)
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