package org.mackas.ui.docente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.mackas.model.Alumno;
import org.mackas.model.Calificacion;
import org.mackas.model.DetalleMatricula;
import org.mackas.repository.impl.MatriculaRepositoryImpl;
import org.mackas.repository.interf.MatriculaRepository;
import org.mackas.service.impl.CalificacionServiceImpl;

public class AlumnosF extends JPanel {

    private Alumno alumno;
    private JLabel txtNombreCompleto;
    private JLabel txtDni;
    private JLabel txtEmail;
    private JLabel txtCodigo;
    private JButton btnCalificar; // 🎯 Nuevo botón
    
    private CalificacionServiceImpl caliService = new CalificacionServiceImpl();
    private MatriculaRepository matrRepository = new MatriculaRepositoryImpl();

    int idSeccion = 0;

    public AlumnosF(Alumno alumno, int idSeccion) {
        this.alumno = alumno;
        initComponents();
        this.idSeccion = idSeccion;

        txtNombreCompleto.setText(alumno.getNombres() + " " + alumno.getApellidos());
        txtDni.setText("DNI: " + alumno.getDni());
        txtEmail.setText("Email: " + alumno.getEmail());
        txtCodigo.setText("Código: " + alumno.getCodigo());

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Ajustamos ligeramente el ancho para que entre bien el botón
        Dimension dim = new Dimension(500, 85);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 85));

        // Acción del botón Calificar
        btnCalificar.addActionListener(e -> abrirFormularioCalificacion(alumno));
    }

    // Método que abre un formulario emergente profesional (JDialog)
    private void abrirFormularioCalificacion(Alumno a) {
        // Obtenemos la ventana principal para centrar el diálogo
        Frame parentFrame = (Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog(parentFrame, "Calificar a " + a.getNombres(), true);
        dialog.setSize(350, 280);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes del formulario flotante
        JLabel lblEvaluacion = new JLabel("Nombre Evaluación:");
        JTextField txtEval = new JTextField(15);
        txtEval.setText("Examen Parcial"); // Valor por defecto opcional

        JLabel lblNota = new JLabel("Nota (0 - 20):");
        JTextField txtNota = new JTextField(15);

        JLabel lblPonderado = new JLabel("Ponderado (Ej. 0.30):");
        JTextField txtPond = new JTextField(15);

        JButton btnGuardar = new JButton("Guardar Calificación");
        btnGuardar.setBackground(new Color(79, 70, 229));
        btnGuardar.setForeground(Color.WHITE);

        // Añadir al grid bag layout
        gbc.gridx = 0; gbc.gridy = 0; dialog.add(lblEvaluacion, gbc);
        gbc.gridx = 1; dialog.add(txtEval, gbc);

        gbc.gridx = 0; gbc.gridy = 1; dialog.add(lblNota, gbc);
        gbc.gridx = 1; dialog.add(txtNota, gbc);

        gbc.gridx = 0; gbc.gridy = 2; dialog.add(lblPonderado, gbc);
        gbc.gridx = 1; dialog.add(txtPond, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; 
        dialog.add(btnGuardar, gbc);

        // Lógica al hacer clic en Guardar dentro del formulario
        btnGuardar.addActionListener(e -> {
            try {
                String nombreEval = txtEval.getText().trim();
                if (nombreEval.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Ingrese el nombre de la evaluación.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                double nota = Double.parseDouble(txtNota.getText().trim());
                double ponderado = Double.parseDouble(txtPond.getText().trim());

                // 1. Buscar el detalle de matrícula
                DetalleMatricula detaM = matrRepository.search(idSeccion, a.getIdAlumno());
                if (detaM == null) {
                    JOptionPane.showMessageDialog(dialog, "El alumno no cuenta con un detalle de matrícula en esta sección.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 2. Crear y poblar el objeto Calificacion
                Calificacion cali = new Calificacion();
                cali.setId_detalle_matricula(detaM.getId_detalle_matricula());
                cali.setMombre_evaluacion(nombreEval);
                cali.setNota(nota);
                cali.setPonderado(ponderado);

                // 3. Guardar mediante el servicio
                Calificacion resultado = caliService.save(cali);

                if (resultado != null) {
                    JOptionPane.showMessageDialog(dialog, "¡Calificación registrada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose(); // Cierra el formulario flotante
                } else {
                    JOptionPane.showMessageDialog(dialog, "No se pudo registrar la calificación.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Ingrese valores numéricos válidos en Nota y Ponderado.", "Error de formato", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        dialog.setVisible(true);
    }

    private void initComponents() {
        txtNombreCompleto = new JLabel();
        txtDni = new JLabel();
        txtEmail = new JLabel();
        txtCodigo = new JLabel();
        btnCalificar = new JButton();

        txtNombreCompleto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        txtNombreCompleto.setForeground(new Color(30, 41, 59));

        txtDni.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtDni.setForeground(new Color(100, 116, 139));

        txtEmail.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        txtEmail.setForeground(new Color(79, 70, 229));

        txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txtCodigo.setForeground(new Color(16, 185, 129));

        // Estilo del botón Calificar
        btnCalificar.setText("Calificar");
        btnCalificar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCalificar.setBackground(new Color(79, 70, 229));
        btnCalificar.setForeground(Color.WHITE);
        btnCalificar.setFocusPainted(false);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtNombreCompleto)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                            .addComponent(txtCodigo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtDni)
                            .addGap(30, 30, 30)
                            .addComponent(txtEmail)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addComponent(btnCalificar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombreCompleto)
                                .addComponent(txtCodigo))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDni)
                                .addComponent(txtEmail)))
                        .addComponent(btnCalificar, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE))
        );
    }
}