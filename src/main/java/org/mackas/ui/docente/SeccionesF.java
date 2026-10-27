package org.mackas.ui.docente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.mackas.model.Seccion;

public class SeccionesF extends JPanel {

    private Seccion seccion;
    private JLabel txtCodigoSeccion;
    private JLabel txtAula;
    private JLabel txtCupoMax;

    // Interfaz funcional para manejar el evento de clic en la tarjeta
    public interface OnSeccionClickListener {
        void onSeccionClick(Seccion seccion);
    }

    private OnSeccionClickListener clickListener;

    public SeccionesF(Seccion seccion, OnSeccionClickListener listener) {
        this.seccion = seccion;
        this.clickListener = listener;
        initComponents();
        
        // Asignamos los valores de la sección a los textos
        txtCodigoSeccion.setText("Sección: " + seccion.getCodigo_seccion());
        txtAula.setText("Aula: " + seccion.getAula());
        txtCupoMax.setText("Cupos: " + seccion.getCupo_max());

        // Diseño visual de la tarjeta
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        
        Dimension dim = new Dimension(450, 90);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Evento de clic para desplegar los alumnos
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (clickListener != null) {
                    clickListener.onSeccionClick(seccion);
                }
            }
        });
    }

    private void initComponents() {
        txtCodigoSeccion = new JLabel();
        txtAula = new JLabel();
        txtCupoMax = new JLabel();

        txtCodigoSeccion.setFont(new Font("Segoe UI", Font.BOLD, 15));
        txtCodigoSeccion.setForeground(new Color(30, 41, 59));

        txtAula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtAula.setForeground(new Color(100, 116, 139));

        txtCupoMax.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtCupoMax.setForeground(new Color(16, 185, 129));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoSeccion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtAula)
                        .addGap(40, 40, 40)
                        .addComponent(txtCupoMax)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigoSeccion)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAula)
                    .addComponent(txtCupoMax))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }
}