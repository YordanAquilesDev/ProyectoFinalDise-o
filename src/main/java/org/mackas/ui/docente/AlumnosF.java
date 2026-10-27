package org.mackas.ui.docente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.mackas.model.Alumno;

public class AlumnosF extends JPanel {

    private Alumno alumno;
    private JLabel txtNombreCompleto;
    private JLabel txtDni;
    private JLabel txtEmail;
    private JLabel txtCodigo;

    public AlumnosF(Alumno alumno) {
        this.alumno = alumno;
        initComponents();

        txtNombreCompleto.setText(alumno.getNombres() + " " + alumno.getApellidos());
        txtDni.setText("DNI: " + alumno.getDni());
        txtEmail.setText("Email: " + alumno.getEmail());
        txtCodigo.setText("Código: " + alumno.getCodigo());

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        Dimension dim = new Dimension(450, 85);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));
    }

    private void initComponents() {
        txtNombreCompleto = new JLabel();
        txtDni = new JLabel();
        txtEmail = new JLabel();
        txtCodigo = new JLabel();

        txtNombreCompleto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtNombreCompleto.setForeground(new Color(30, 41, 59));

        txtDni.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtDni.setForeground(new Color(100, 116, 139));

        txtEmail.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        txtEmail.setForeground(new Color(79, 70, 229));

        txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtCodigo.setForeground(new Color(16, 185, 129));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreCompleto)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(txtCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDni)
                        .addGap(30, 30, 30)
                        .addComponent(txtEmail)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCompleto)
                    .addComponent(txtCodigo))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni)
                    .addComponent(txtEmail))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }
}