package org.mackas.ui.alumno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import org.mackas.model.Calificacion;

public class NotasF extends JPanel {

    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel txtCurso;

    public NotasF() {
        initComponents();
        Dimension dimensionFija = new Dimension(1000, 160);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
    }

    public void setNombreCurso(String nombre) {
        txtCurso.setText(nombre);
    }

    public void addNota(Calificacion cali) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(new Object[]{
            cali.getId_calificacion(),
            cali.getId_detalle_matricula(),
            cali.getMombre_evaluacion(), 
            cali.getPonderado(),
            cali.getNota(),
            cali.getFecha_registro()
        });
    }

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
    }

    private void initComponents() {
        txtCurso = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));

        txtCurso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtCurso.setForeground(new Color(30, 41, 59));
        txtCurso.setText("Curso: ");

        jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Calificación", "ID Matrícula", "Evaluación", "Ponderado", "Nota", "Fecha"
            }
        ));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtCurso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCurso)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}