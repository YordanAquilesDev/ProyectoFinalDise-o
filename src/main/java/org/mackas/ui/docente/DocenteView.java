package org.mackas.ui.docente;

import org.mackas.config.Data;
import org.mackas.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DocenteView extends JFrame {

    private final Docente docente;
    private Seccion seccionSeleccionada;
  Data datos= new Data();
    // Componentes interactivos
    private JComboBox<String> comboSecciones;
    private JLabel lblSubtitleHeader;

    // Modelos de tablas
    private DefaultTableModel modelHorarios;
    private DefaultTableModel modelAlumnos;

    // Labels de métricas
    private JLabel lblTotalAlumnos;
    private JLabel lblIngSoftware;
    private JLabel lblIngSistemas;

    public DocenteView(Docente docente) {
        this.docente = docente;
        // Asignamos la primera sección si el docente tiene secciones agregadas
        if (docente.getSecciones() != null && !docente.getSecciones().isEmpty()) {
            this.seccionSeleccionada = docente.getSecciones().get(0);
        }

        initUI();
    }

    private void initUI() {
        docente.addSecction(datos.seccion2);
        setTitle("Portal Docente - Sistema Académico");
        setSize(950, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header superior con selector de sección
        add(createHeaderPanel(), BorderLayout.NORTH);

        // Panel de pestañas central
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 13));

        tabbedPane.addTab("Perfil del Docente", createPerfilPanel());
        tabbedPane.addTab("Horario de Clases", createHorarioPanel());
        tabbedPane.addTab("Alumnos por Sección", createAlumnosPanel());
     //   tabbedPane.add("Cerrar Sesion", )

        add(tabbedPane, BorderLayout.CENTER);

        // Cargar datos en la UI
        actualizarVistaSeccion();
    }

    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout(15, 10));
        header.setBackground(new Color(49, 46, 129)); // Indigo oscuro
        header.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Panel Izquierdo: Títulos
        JPanel pnlTitles = new JPanel(new GridLayout(2, 1, 0, 4));
        pnlTitles.setOpaque(false);

        JLabel title = new JLabel("Panel de Gestión Docente");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        lblSubtitleHeader = new JLabel();
        lblSubtitleHeader.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSubtitleHeader.setForeground(new Color(199, 210, 254));

        pnlTitles.add(title);
        pnlTitles.add(lblSubtitleHeader);

        // Panel Derecho: Selector de Secciones desde el objeto Docente
        JPanel pnlSelector = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        pnlSelector.setOpaque(false);

        JLabel lblSelect = new JLabel("Sección:");
        lblSelect.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblSelect.setForeground(Color.WHITE);

        comboSecciones = new JComboBox<>();
        comboSecciones.setFont(new Font("SansSerif", Font.PLAIN, 13));

        List<Seccion> seccionesDocente = docente.getSecciones();
        if (seccionesDocente != null) {
            for (Seccion s : seccionesDocente) {
                comboSecciones.addItem("Sección #" + s.getCodigo_seccion() + " - " + s.getCurso().getNombre_curso());
            }
        }

        comboSecciones.addActionListener(e -> {
            int index = comboSecciones.getSelectedIndex();
            if (index >= 0 && seccionesDocente != null) {
                seccionSeleccionada = seccionesDocente.get(index);
                actualizarVistaSeccion();
            }
        });

        pnlSelector.add(lblSelect);
        pnlSelector.add(comboSecciones);

        header.add(pnlTitles, BorderLayout.CENTER);
        header.add(pnlSelector, BorderLayout.EAST);
        return header;
    }

    private JPanel createPerfilPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(25, 25, 25, 25));
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblTitle = new JLabel("Información Personal");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTitle.setForeground(new Color(30, 41, 59));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        String[][] datos = {
                {"Nombre Completo:", docente.getNombre() + " " + docente.getApellido()},
                {"Código Docente:", docente.getCodigo()},
                {"DNI:", docente.getDni()},
                {"Correo Electrónico:", docente.getCorreo_institucional()},
                {"Teléfono de Contacto:", docente.getTelefono()}
        };

        for (int i = 0; i < datos.length; i++) {
            gbc.gridy = i + 1;

            gbc.gridx = 0;
            JLabel lblKey = new JLabel(datos[i][0]);
            lblKey.setFont(new Font("SansSerif", Font.BOLD, 13));
            lblKey.setForeground(new Color(100, 116, 139));
            panel.add(lblKey, gbc);

            gbc.gridx = 1;
            JLabel lblValue = new JLabel(datos[i][1]);
            lblValue.setFont(new Font("SansSerif", Font.PLAIN, 13));
            lblValue.setForeground(new Color(15, 23, 42));
            panel.add(lblValue, gbc);
        }

        return panel;
    }

    private JPanel createHorarioPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        String[] columnas = {"Fecha", "Hora Inicio", "Hora Fin", "Curso", "Sección"};
        modelHorarios = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(modelHorarios);
        styleTable(table);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createAlumnosPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        // Agregamos las cabeceras de las notas de la clase Calificacion
        String[] columnas = {
                "Código", "DNI", "Apellidos y Nombres", "Carrera", "Correo", "Teléfono",
                "PC1", "PC2", "PA", "EX"
        };

        modelAlumnos = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(modelAlumnos);
        styleTable(table);

        // Panel de métricas sobre los alumnos
        JPanel panelSummary = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelSummary.setBackground(new Color(241, 245, 249));

        lblTotalAlumnos = new JLabel();
        lblTotalAlumnos.setFont(new Font("SansSerif", Font.BOLD, 12));

        lblIngSoftware = new JLabel();
        lblIngSoftware.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblIngSoftware.setForeground(new Color(37, 99, 235));

        lblIngSistemas = new JLabel();
        lblIngSistemas.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblIngSistemas.setForeground(new Color(79, 70, 229));

        panelSummary.add(lblTotalAlumnos);
        panelSummary.add(new JLabel("|"));
        panelSummary.add(lblIngSoftware);
        panelSummary.add(new JLabel("|"));
        panelSummary.add(lblIngSistemas);

        panel.add(panelSummary, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private void actualizarVistaSeccion() {
        if (seccionSeleccionada == null) {
            lblSubtitleHeader.setText("No hay secciones asignadas.");
            return;
        }

        // 1. Actualizar subtítulo
        lblSubtitleHeader.setText("Curso: " + seccionSeleccionada.getCurso().getNombre_curso()
                + " | Sección: #" + seccionSeleccionada.getCodigo_seccion());

        // 2. Actualizar Tabla de Horarios
        modelHorarios.setRowCount(0);
        List<Horario> horarios = seccionSeleccionada.getHorarios();
        if (horarios != null) {
            for (Horario h : horarios) {
                modelHorarios.addRow(new Object[]{
                        h.getFecha(),
                        h.getHora_inicio(),
                        h.getHora_final(),
                        seccionSeleccionada.getCurso().getNombre_curso(),
                        seccionSeleccionada.getCodigo_seccion()
                });
            }
        }

        // 3. Actualizar Tabla de Alumnos y Métricas
        modelAlumnos.setRowCount(0);
        List<Alumno> alumnos = seccionSeleccionada.getAlumnos();
        if (alumnos != null) {
            for (Alumno a : alumnos) {
                Object[] fila = new Object[]{
                        a.getCodigo(),
                        a.getDni(),
                        a.getApellido() + " " + a.getNombre(),
                        (a.getCarrera_profesional() != null) ? a.getCarrera_profesional().getNombre_carrera() : "N/A",
                        a.getCorreo_institucional(),
                        a.getTelefono(),
                        a.getCalificacion()!= null ? a.getCalificacion().getPC1() : "-",
                        a.getCalificacion() != null ? a.getCalificacion().getPC2() : "-",
                        a.getCalificacion ()!= null ? a.getCalificacion().getPA() : "-",
                        a.getCalificacion() != null ? a.getCalificacion().getEX()  : "-"
                };
                modelAlumnos.addRow(fila);
            }

            long totalSoftware = alumnos.stream()
                    .filter(a -> a.getCarrera_profesional() != null && "Ing. Software".equalsIgnoreCase(a.getCarrera_profesional().getNombre_carrera()))
                    .count();
            long totalSistemas = alumnos.stream()
                    .filter(a -> a.getCarrera_profesional() != null && "Ing. Sistemas".equalsIgnoreCase(a.getCarrera_profesional().getNombre_carrera()))
                    .count();

            lblTotalAlumnos.setText("Total Alumnos: " + alumnos.size());
            lblIngSoftware.setText("Ing. Software: " + totalSoftware);
            lblIngSistemas.setText("Ing. Sistemas: " + totalSistemas);
        }
    }

    private void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(226, 232, 240));
        table.getTableHeader().setForeground(new Color(30, 41, 59));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != 2) { // Centrar todo excepto la columna de nombres
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }
}