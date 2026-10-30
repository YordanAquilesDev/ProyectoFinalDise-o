package org.mackas.ui.alumno;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.mackas.model.Alumno;
import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;
import org.mackas.model.PeriodoAcademico;
import org.mackas.model.Seccion;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.impl.PeriodoAcademicoServiceImpl;
import org.mackas.service.impl.SeccionServiceImpl;

public class MatriculaUI extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MatriculaUI.class.getName());
    
    private MatriculaServiceImpl matService = new MatriculaServiceImpl();
    private PeriodoAcademicoServiceImpl perAcService = new PeriodoAcademicoServiceImpl();
    private SeccionServiceImpl secService = new SeccionServiceImpl();
    
    private DefaultTableModel model;
    private Alumno alumno;
    private Matricula mt1;

    // Componentes de la UI
    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JLabel lblPeriodo;
    private JLabel lblSeccion;
    private JComboBox<PeriodoAcademico> cmbPeriodo;
    private JComboBox<Seccion> cmbSeccion;
    private JButton btnAgregarSecc;
    private JButton btnQuitarSecc;
    private JTable tblSeccion;
    private JScrollPane jScrollPane1;
    private JLabel lblMontoTotal;
    private JButton btnMatricularse;

    public MatriculaUI(Alumno a) {
        this.alumno = a;
        initComponents();
        
        // Configuración de la ventana
        setTitle("Sistema Académico - Registro de Matrícula");
        setSize(800, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Inicializar modelo de tabla y datos
        model = (DefaultTableModel) tblSeccion.getModel();
        initPeriodos();
    }

    private void initPeriodos() {
        List<PeriodoAcademico> listaPeriodos = perAcService.findAll();
        DefaultComboBoxModel<PeriodoAcademico> comboBoxModel = new DefaultComboBoxModel<>(listaPeriodos.toArray(new PeriodoAcademico[0]));
        cmbPeriodo.setModel(comboBoxModel);
        
        // Si hay periodos, cargamos inicialmente las secciones del primero
        if (listaPeriodos.size() > 0) {
            cargarSeccionesPorPeriodo(listaPeriodos.get(0));
        }
    }

    private void cargarSeccionesPorPeriodo(PeriodoAcademico periodo) {
        cmbSeccion.removeAllItems();
        if (periodo != null) {
            secService.findByIdPeriodo(periodo.getId_periodo()).forEach(s -> {
                cmbSeccion.addItem(s);
            });
            mt1 = new Matricula(alumno.getIdAlumno(), periodo.getId_periodo(), 0.0);
        }
    }

    private void initComponents() {
        panelPrincipal = new JPanel();
        lblTitulo = new JLabel();
        lblPeriodo = new JLabel();
        cmbPeriodo = new JComboBox<>();
        lblSeccion = new JLabel();
        cmbSeccion = new JComboBox<>();
        btnAgregarSecc = new JButton();
        jScrollPane1 = new JScrollPane();
        tblSeccion = new JTable();
        btnQuitarSecc = new JButton();
        lblMontoTotal = new JLabel();
        btnMatricularse = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panelPrincipal.setBackground(new Color(248, 250, 252)); // Fondo gris claro muy moderno tipo SaaS

        // Título Principal
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(30, 41, 59));
        lblTitulo.setText("Proceso de Matrícula Estudiantil");

        // Etiquetas
        lblPeriodo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPeriodo.setForeground(new Color(100, 116, 139));
        lblPeriodo.setText("Periodo Académico:");

        lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSeccion.setForeground(new Color(100, 116, 139));
        lblSeccion.setText("Sección / Curso:");

        // ComboBoxes
        cmbPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbPeriodo.addActionListener(this::cmbPeriodoActionPerformed);

        cmbSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        // Botón Agregar Sección (Estilo Verde Esmeralda)
        btnAgregarSecc.setBackground(new Color(16, 185, 129));
        btnAgregarSecc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarSecc.setForeground(Color.WHITE);
        btnAgregarSecc.setText("+ Agregar Curso");
        btnAgregarSecc.setFocusPainted(false);
        btnAgregarSecc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarSecc.addActionListener(this::btnAgregarSeccActionPerformed);

        // Tabla
        tblSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblSeccion.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Matrícula", "ID Sección", "Promedio", "Estado"
            }
        ));
        tblSeccion.setRowHeight(24);
        jScrollPane1.setViewportView(tblSeccion);

        // Botón Quitar Sección (Estilo Neutro/Rojo sutil)
        btnQuitarSecc.setBackground(new Color(239, 68, 68));
        btnQuitarSecc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnQuitarSecc.setForeground(Color.WHITE);
        btnQuitarSecc.setText("Quitar Selección");
        btnQuitarSecc.setFocusPainted(false);
        btnQuitarSecc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarSecc.addActionListener(e -> {
            int selectedRow = tblSeccion.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
                // Opcional: remover también de tu lista interna mt1 si llevas el control
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un curso de la tabla para quitar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Monto Total
        lblMontoTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMontoTotal.setForeground(new Color(30, 41, 59));
        lblMontoTotal.setText("Monto Total: S/. 0.00");

        // Botón Matricularse (Estilo Principal Azul/Morado)
        btnMatricularse.setBackground(new Color(79, 70, 229));
        btnMatricularse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnMatricularse.setForeground(Color.WHITE);
        btnMatricularse.setText("Confirmar Matrícula");
        btnMatricularse.setFocusPainted(false);
        btnMatricularse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMatricularse.addActionListener(this::btnMatricularseActionPerformed);

        // Layout estructurado mediante GroupLayout
        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitulo)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblPeriodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblSeccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarSecc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQuitarSecc, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(lblMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnMatricularse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodo)
                    .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeccion)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarSecc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btnQuitarSecc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMontoTotal))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMatricularse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void cmbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {
        PeriodoAcademico periodo = (PeriodoAcademico) cmbPeriodo.getSelectedItem();
        if (periodo != null) {
            cargarSeccionesPorPeriodo(periodo);
        }
    }

    private void btnAgregarSeccActionPerformed(java.awt.event.ActionEvent evt) {
        Seccion sec = (Seccion) cmbSeccion.getSelectedItem();
        if (sec == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una sección válida.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación opcional si mt1 es null por seguridad
        if (mt1 == null) {
            PeriodoAcademico periodo = (PeriodoAcademico) cmbPeriodo.getSelectedItem();
            mt1 = new Matricula(alumno.getIdAlumno(), periodo.getId_periodo(), 0.0);
        }

        // Agregar el detalle al objeto Matricula
        mt1.addSecction(new DetalleMatricula(0, sec.getId_seccion()));

        // Añadir la fila a la tabla visual
        int idMatriculaTemp = 0; 
        int idSeccion = sec.getId_seccion();
        double promedioInicial = 0.0;
        String estadoInicial = "Registrado";

        model.addRow(new Object[]{
            idMatriculaTemp,
            idSeccion,
            promedioInicial,
            estadoInicial
        });
    }

    private void btnMatricularseActionPerformed(java.awt.event.ActionEvent evt) {
        if (mt1 == null || model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos una sección para matricularse.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Matricula mt = matService.setMatricula(mt1);
            
            if (mt != null) {
                JOptionPane.showMessageDialog(this, "¡Matrícula registrada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                // Redirección al panel del Alumno
                AlumnoUIF alumniUI = new AlumnoUIF(alumno);
                alumniUI.setVisible(true);
                this.dispose(); // Cierra la ventana de matrícula actual
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo procesar la matrícula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            // Ejemplo para pruebas visuales con alumno vacío
            new MatriculaUI(new Alumno()).setVisible(true);
        });
    }
}