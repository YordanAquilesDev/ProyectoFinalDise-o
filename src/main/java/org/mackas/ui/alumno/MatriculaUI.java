package org.mackas.ui.alumno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;
import org.mackas.model.Alumno;
import org.mackas.model.DetalleMatricula;
import org.mackas.model.Matricula;
import org.mackas.model.PeriodoAcademico;
import org.mackas.model.Seccion;
import org.mackas.service.factory.ServiceFactory;
import org.mackas.service.interf.*;

public class MatriculaUI extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MatriculaUI.class.getName());

    private IMatriculaDao matService;
    private IPeriodoAcademicoDao perAcService;
    private ISeccionDao secService;

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

    public MatriculaUI(Alumno a,
                       IMatriculaDao matService,
                       IPeriodoAcademicoDao perAcService,
                       ISeccionDao secService) {
        this.matService = matService;
        this.perAcService = perAcService;
        this.secService = secService;
        this.alumno = a;
        initComponents();

        // Configuración de la ventana flexible
        setTitle("Sistema Académico - Registro de Matrícula");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true); // Permitir redimensionar

        // Inicializar modelo de tabla y datos
        model = (DefaultTableModel) tblSeccion.getModel();
        initPeriodos();
    }

    private void initPeriodos() {
        List<PeriodoAcademico> listaPeriodos = perAcService.findAll();
        DefaultComboBoxModel<PeriodoAcademico> comboBoxModel = new DefaultComboBoxModel<>(listaPeriodos.toArray(new PeriodoAcademico[0]));
        cmbPeriodo.setModel(comboBoxModel);

        if (!listaPeriodos.isEmpty()) {
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
        // Ventana principal con BorderLayout general
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(248, 250, 252)); // Fondo SaaS suave
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Usamos GridBagLayout para que todo se expanda de forma fluida
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 1. Título Principal
        lblTitulo = new JLabel("Proceso de Matrícula Estudiantil");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 41, 59));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 20, 0);
        panelPrincipal.add(lblTitulo, gbc);

        // 2. Panel Superior de Selección (Periodo, Sección, Botón Agregar)
        JPanel panelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panelFiltros.setBackground(new Color(248, 250, 252));

        lblPeriodo = new JLabel("Periodo Académico:");
        lblPeriodo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPeriodo.setForeground(new Color(100, 116, 139));

        cmbPeriodo = new JComboBox<>();
        cmbPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbPeriodo.setPreferredSize(new java.awt.Dimension(160, 34));
        cmbPeriodo.addActionListener(this::cmbPeriodoActionPerformed);

        lblSeccion = new JLabel("Sección / Curso:");
        lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSeccion.setForeground(new Color(100, 116, 139));

        cmbSeccion = new JComboBox<>();
        cmbSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbSeccion.setPreferredSize(new java.awt.Dimension(180, 34));

        btnAgregarSecc = new JButton("+ Agregar Curso");
        btnAgregarSecc.setBackground(new Color(16, 185, 129));
        btnAgregarSecc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregarSecc.setForeground(Color.WHITE);
        btnAgregarSecc.setFocusPainted(false);
        btnAgregarSecc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarSecc.setPreferredSize(new java.awt.Dimension(140, 34));
        btnAgregarSecc.addActionListener(this::btnAgregarSeccActionPerformed);

        panelFiltros.add(lblPeriodo);
        panelFiltros.add(cmbPeriodo);
        panelFiltros.add(lblSeccion);
        panelFiltros.add(cmbSeccion);
        panelFiltros.add(btnAgregarSecc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 20, 0);
        panelPrincipal.add(panelFiltros, gbc);

        // 3. Tabla de Cursos Seleccionados (Ocupará todo el espacio flexible)
        tblSeccion = new JTable();
        tblSeccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblSeccion.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "ID Matrícula", "ID Sección", "Promedio", "Estado"
                }
        ));
        tblSeccion.setRowHeight(26);

        jScrollPane1 = new JScrollPane(tblSeccion);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3; gbc.gridheight = 2;
        gbc.weightx = 1.0; gbc.weighty = 1.0; // ¡Clave para que la tabla se expanda en alto y ancho!
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 20, 15);
        panelPrincipal.add(jScrollPane1, gbc);

        // 4. Panel Lateral (Botón Quitar y Monto Total)
        JPanel panelLateral = new JPanel(new GridBagLayout());
        panelLateral.setBackground(new Color(248, 250, 252));
        GridBagConstraints gbcLat = new GridBagConstraints();

        btnQuitarSecc = new JButton("Quitar Selección");
        btnQuitarSecc.setBackground(new Color(239, 68, 68));
        btnQuitarSecc.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnQuitarSecc.setForeground(Color.WHITE);
        btnQuitarSecc.setFocusPainted(false);
        btnQuitarSecc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarSecc.setPreferredSize(new java.awt.Dimension(150, 34));
        btnQuitarSecc.addActionListener(e -> {
            int selectedRow = tblSeccion.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un curso de la tabla para quitar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        lblMontoTotal = new JLabel("Monto Total: S/. 200.00");
        lblMontoTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMontoTotal.setForeground(new Color(30, 41, 59));

        gbcLat.gridx = 0; gbcLat.gridy = 0; gbcLat.anchor = GridBagConstraints.NORTH;
        gbcLat.fill = GridBagConstraints.HORIZONTAL;
        gbcLat.insets = new Insets(0, 0, 15, 0);
        panelLateral.add(btnQuitarSecc, gbcLat);

        gbcLat.gridy = 1;
        panelLateral.add(lblMontoTotal, gbcLat);

        gbc.gridx = 3; gbc.gridy = 2; gbc.gridwidth = 1; gbc.gridheight = 1;
        gbc.weightx = 0.0; gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelPrincipal.add(panelLateral, gbc);

        // 5. Botón Inferior: Confirmar Matrícula (Alineado a la derecha)
        btnMatricularse = new JButton("Confirmar Matrícula");
        btnMatricularse.setBackground(new Color(79, 70, 229));
        btnMatricularse.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnMatricularse.setForeground(Color.WHITE);
        btnMatricularse.setFocusPainted(false);
        btnMatricularse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMatricularse.setPreferredSize(new java.awt.Dimension(190, 42));
        btnMatricularse.addActionListener(this::btnMatricularseActionPerformed);

        gbc.gridx = 3; gbc.gridy = 3; gbc.gridwidth = 1; gbc.gridheight = 1;
        gbc.weightx = 0.0; gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 0, 0, 0);
        panelPrincipal.add(btnMatricularse, gbc);

        add(panelPrincipal, BorderLayout.CENTER);
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

        if (mt1 == null) {
            PeriodoAcademico periodo = (PeriodoAcademico) cmbPeriodo.getSelectedItem();
            mt1 = new Matricula(alumno.getIdAlumno(), periodo.getId_periodo(), 0.0);
        }

        mt1.addSecction(new DetalleMatricula(0, sec.getId_seccion()));

        model.addRow(new Object[]{
                0,
                sec.getId_seccion(),
                0.0,
                "Registrado"
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

                ICursoDao cursoService = ServiceFactory.CursoServiceFactory();
                ICalificacionDao caliService = ServiceFactory.CalificacionServiceFactory();
                IHorarioDao horaService = ServiceFactory.HorarioServiceFactory();
                ICarreraDao carrService = ServiceFactory.CarreaServiceFactory();

                AlumnoUIF alumniUI = new AlumnoUIF(alumno, cursoService, caliService, horaService, carrService);
                alumniUI.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo procesar la matrícula.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}