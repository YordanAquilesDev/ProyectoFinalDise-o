package org.mackas.ui.alumno;

import org.mackas.config.Data;
import org.mackas.model.Alumno;
import org.mackas.model.Calificacion;
import org.mackas.model.Docente;
import org.mackas.model.Horario;
import org.mackas.model.Seccion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class AlumnoView extends JFrame {

    private final Data data;

    public AlumnoView(Data data) {
        this.data = data;
        initUI();
    }

    private void initUI() {
        setTitle("Panel del Alumno - Sistema Académico");
        setSize(750, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Alumno alumno = data.alumnoLogueado;

        // Panel Superior: Información del Alumno
        JPanel headerPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        headerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Datos del Alumno", TitledBorder.LEFT, TitledBorder.TOP));

        if (alumno != null) {
            headerPanel.add(new JLabel(" Código: " + alumno.getCodigo()));
            headerPanel.add(new JLabel(" Alumno: " + alumno.getNombre() + " " + alumno.getApellido()));
            headerPanel.add(new JLabel(" Carrera: " + (alumno.getCarrera_profesional() != null ? alumno.getCarrera_profesional().getNombre_carrera() : "N/A")));
            headerPanel.add(new JLabel(" Correo: " + alumno.getCorreo_institucional()));
        } else {
            headerPanel.add(new JLabel(" No hay sesión de alumno activa."));
        }

        add(headerPanel, BorderLayout.NORTH);

        // Panel Contenedor de Cursos con Scroll
        JPanel cursosContainer = new JPanel();
        cursosContainer.setLayout(new BoxLayout(cursosContainer, BoxLayout.Y_AXIS));
        cursosContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        List<Seccion> misSecciones = (alumno != null) ? alumno.getSecciones() : null;

        if (misSecciones == null || misSecciones.isEmpty()) {
            cursosContainer.add(new JLabel("No tienes cursos matriculados actualmente."));
        } else {
            for (Seccion seccion : misSecciones) {
                cursosContainer.add(crearPanelCurso(seccion));
                cursosContainer.add(Box.createRigidArea(new Dimension(0, 15))); // Espaciador entre tarjetas
            }
        }

        JScrollPane scrollPane = new JScrollPane(cursosContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel crearPanelCurso(Seccion seccion) {
        JPanel card = new JPanel(new BorderLayout(8, 8));
        card.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Curso: " + seccion.getCurso().getNombre_curso() + " (Sección: " + seccion.getCodigo_seccion() + ")"
        ));

        // 1. Información del Docente (Norte)
        Docente docente = obtenerDocenteDeSeccion(seccion);
        String textoDocente = (docente != null)
                ? docente.getNombre() + " " + docente.getApellido() + " (" + docente.getCorreo_institucional() + ")"
                : "Sin docente asignado";

        JLabel lblDocente = new JLabel(" Docente a cargo: " + textoDocente);
        lblDocente.setFont(new Font("SansSerif", Font.BOLD, 12));
        card.add(lblDocente, BorderLayout.NORTH);

        // 2. Horarios en la parte Central
        DefaultListModel<String> listModel = new DefaultListModel<>();
        if (seccion.getHorarios() != null) {
            for (Horario h : seccion.getHorarios()) {
                listModel.addElement("• Fecha: " + h.getFecha() + " | De: " + h.getHora_inicio() + " a " + h.getHora_final());
            }
        }

        JList<String> listHorarios = new JList<>(listModel);
        listHorarios.setBackground(new Color(245, 245, 245));
        JScrollPane scrollHorarios = new JScrollPane(listHorarios);
        scrollHorarios.setPreferredSize(new Dimension(0, 70));
        card.add(scrollHorarios, BorderLayout.CENTER);

        // 3. Panel de Calificaciones (Sur)
        JPanel panelNotas = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        panelNotas.setBackground(new Color(238, 242, 246));
        panelNotas.setBorder(BorderFactory.createTitledBorder("Calificaciones"));

        Calificacion cal = seccion.getCurso().getCalificacion();
        if (cal != null) {
            // Suponiendo que la clase Calificacion tiene getters como getNota1(), getNota2(), etc.
            // Ajusta los getters según la firma real de tu clase Calificacion
            panelNotas.add(new JLabel("Nota 1: " + obtenerValorOIncierto(cal, 1)));
            panelNotas.add(new JLabel("Nota 2: " + obtenerValorOIncierto(cal, 2)));
            panelNotas.add(new JLabel("Nota 3: " + obtenerValorOIncierto(cal, 3)));
            panelNotas.add(new JLabel("Nota 4: " + obtenerValorOIncierto(cal, 4)));
        } else {
            panelNotas.add(new JLabel("Sin calificaciones registradas"));
        }

        card.add(panelNotas, BorderLayout.SOUTH);

        return card;
    }

    // Método aux para extraer las notas según los getters de la clase Calificacion
    private String obtenerValorOIncierto(Calificacion cal, int indice) {
        if (cal == null) return "-";
        // Si la clase Calificacion usa atributos privados con getters, ajústalos aquí
        try {
            switch (indice) {
                case 1: return cal.getPC1() != null ? cal.getPC1() : "-";
                case 2: return cal.getPC2() != null ? cal.getPC2() : "-";
                case 3: return cal.getPA() != null ? cal.getPA() : "-";
                case 4: return cal.getEX() != null ? cal.getEX() : "-";
                default: return "-";
            }
        } catch (Exception e) {
            return "-";
        }
    }

    private Docente obtenerDocenteDeSeccion(Seccion target) {
        if (data.getDocentes() == null) return null;
        return data.getDocentes().stream()
                .filter(docente -> docente.getSecciones() != null && docente.getSecciones().contains(target))
                .findFirst()
                .orElse(null);
    }

    public void mostrarPanelAlumno() {
        SwingUtilities.invokeLater(() -> this.setVisible(true));
    }
}