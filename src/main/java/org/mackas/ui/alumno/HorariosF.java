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

    private JLabel txtAula;
    private JLabel txtHoraFin;
    private JLabel txtHoraInicio;
    private JLabel txtIdHorario;
    private JLabel txtIdSeccion;
    private JLabel txtSemanaNr;

    public HorariosF(String aula, Time hora_fin, Time hora_inicio, int id_horario, int id_seccion, String semana) {
        initComponents();
        
        txtAula.setText("Aula: " + aula);
        txtHoraFin.setText(hora_fin != null ? hora_fin.toString() : "");
        txtHoraInicio.setText(hora_inicio != null ? hora_inicio.toString() : "");
        txtIdHorario.setText("H-ID: " + id_horario);
        txtIdSeccion.setText("Sección: " + id_seccion);
        txtSemanaNr.setText(semana);

        Dimension dimensionFija = new Dimension(500, 100);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
    }

    private void initComponents() {
        txtIdHorario = new JLabel();
        txtIdSeccion = new JLabel();
        txtSemanaNr = new JLabel();
        txtHoraInicio = new JLabel();
        txtHoraFin = new JLabel();
        txtAula = new JLabel();

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));

        txtIdHorario.setFont(new Font("Segoe UI", Font.BOLD, 11));
        txtIdHorario.setForeground(new Color(14, 165, 233)); // Azul claro / cian

        txtIdSeccion.setFont(new Font("Segoe UI", Font.BOLD, 11));
        txtIdSeccion.setForeground(new Color(100, 116, 139));

        txtSemanaNr.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtSemanaNr.setForeground(new Color(30, 41, 59));

        txtHoraInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtHoraInicio.setForeground(new Color(51, 65, 85));

        txtHoraFin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtHoraFin.setForeground(new Color(51, 65, 85));

        txtAula.setFont(new Font("Segoe UI", Font.BOLD, 13));
        txtAula.setForeground(new Color(234, 88, 12)); // Naranja elegante para destacar el aula

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdHorario)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdSeccion)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAula))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSemanaNr)
                        .addGap(40, 40, 40)
                        .addComponent(txtHoraInicio)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraFin)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdHorario)
                    .addComponent(txtIdSeccion)
                    .addComponent(txtAula))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSemanaNr)
                    .addComponent(txtHoraInicio)
                    .addComponent(txtHoraFin))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}