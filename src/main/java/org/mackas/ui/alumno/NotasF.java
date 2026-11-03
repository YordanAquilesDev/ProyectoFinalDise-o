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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.mackas.model.Calificacion;

public class NotasF extends JPanel {

    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JLabel txtCurso;

    public NotasF() {
        initComponents();
        Dimension dimensionFija = new Dimension(1000, 175);
        setPreferredSize(dimensionFija);
        setMinimumSize(dimensionFija);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 175));
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
            cali.getPonderado() + "%",
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
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1, true),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        txtCurso.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtCurso.setForeground(new Color(15, 23, 42));
        txtCurso.setText("Curso: ");

        jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Calificación", "ID Matrícula", "Evaluación", "Ponderado", "Nota", "Fecha de Registro"
            }
        ));
        jTable1.setRowHeight(26);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setBackground(new Color(241, 245, 249));
        jTable1.getTableHeader().setForeground(new Color(51, 65, 85));
        jTable1.setGridColor(new Color(226, 232, 240));

        // Centrar columnas numéricas o de texto corto
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Ponderado
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); // Nota

        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));

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
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}