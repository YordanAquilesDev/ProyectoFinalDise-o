package org.mackas.ui.docente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;
import org.mackas.model.Seccion;
import org.mackas.service.factory.ServiceFactory;
import org.mackas.service.interf.IAlumnoDao;
import org.mackas.service.interf.ICalificacionDao;
import org.mackas.service.interf.IMatriculaDao;
import org.mackas.service.interf.ISeccionDao;

public class SeccionF extends JPanel {

    private Docente docente;
    private ISeccionDao seccionService;
    private IAlumnoDao alumnoService;

    public SeccionF(Docente docente, ISeccionDao seccionService, IAlumnoDao alumnoService) {
        this.docente = docente;
        this.seccionService = seccionService;
        this.alumnoService = alumnoService;

        initComponentsPersonalizado();
        cargarSecciones(); // Vista inicial por defecto dentro de SeccionF
    }

    private void initComponentsPersonalizado() {
        setLayout(new BorderLayout());
        setBackground(new Color(248, 250, 252));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Muestra la cuadrícula con las secciones asignadas al docente.
     */
    public void cargarSecciones() {
        removeAll();

        JPanel panelGrid = new JPanel(new GridLayout(0, 2, 25, 25));
        panelGrid.setBackground(new Color(248, 250, 252));

        List<Seccion> seccionDocente = null;
        if (docente != null) {
            int idDocente = docente.getIdDocente() == 0 ? 1 : docente.getIdDocente();
            seccionDocente = seccionService.findByIdDocente(idDocente);
        }

        if (seccionDocente != null && !seccionDocente.isEmpty()) {
            for (Seccion sec : seccionDocente) {
                // Instanciamos la tarjeta estática y le pasamos la acción (callback) al hacer clic
                SeccionCard seccionCard = new SeccionCard(sec, clickedSeccion -> {
                    // Llamamos al método interno para cargar los alumnos de esta sección
                    cargarAlumnosDeSeccion(clickedSeccion.getId_seccion(), clickedSeccion.getCodigo_seccion());
                });
                panelGrid.add(seccionCard);
            }
        } else {
            JLabel lblVacio = new JLabel("No hay secciones asignadas para este docente.");
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            panelGrid.add(lblVacio);
        }

        add(panelGrid, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Muestra la cuadrícula con los alumnos de la sección seleccionada (Todo dentro de SeccionF).
     */
    public void cargarAlumnosDeSeccion(int idSeccion, String codigoSeccion) {
        removeAll();

        JPanel panelGridAlumnos = new JPanel(new GridLayout(0, 2, 25, 25));
        panelGridAlumnos.setBackground(new Color(248, 250, 252));

        // Obtenemos los alumnos usando el servicio inyectado en SeccionF
        List<Alumno> alumnosSeccion = alumnoService.findByIdSeccion(idSeccion);
        IMatriculaDao matriculaService= ServiceFactory.MatriculaServiceFactory();
        ICalificacionDao calificacionService=ServiceFactory.CalificacionServiceFactory();

        if (alumnosSeccion != null && !alumnosSeccion.isEmpty()) {
            for (Alumno alu : alumnosSeccion) {
                AlumnosF alumnoCard = new AlumnosF(alu, idSeccion,calificacionService,matriculaService);
                panelGridAlumnos.add(alumnoCard);
            }
        } else {
            JLabel lblVacio = new JLabel("No hay alumnos registrados en esta sección.");
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            panelGridAlumnos.add(lblVacio);
        }

        add(panelGridAlumnos, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Clase interna estática que representa la tarjeta visual de cada sección.
     */
    public static class SeccionCard extends JPanel {

        private Seccion seccion;
        private JLabel txtCodigoSeccion;
        private JLabel txtAula;
        private JLabel txtCupoMax;

        // Interfaz funcional para manejar el evento Clic de la tarjeta
        public interface OnSeccionClickListener {
            void onSeccionClick(Seccion seccion);
        }

        public SeccionCard(Seccion seccion, OnSeccionClickListener listener) {
            this.seccion = seccion;
            initComponents();

            // Seteamos los datos de la sección en los Labels
            txtCodigoSeccion.setText("Sección: " + seccion.getCodigo_seccion());
            txtAula.setText("🏫 Aula: " + (seccion.getAula() != null ? seccion.getAula() : "S/N"));
            txtCupoMax.setText("👥 Cupos: " + seccion.getCupo_max());

            setBackground(Color.WHITE);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(226, 232, 240), 1, true),
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            ));

            Dimension dim = new Dimension(480, 95);
            setPreferredSize(dim);
            setMinimumSize(dim);
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 95));
            setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            // Efecto Hover y Evento Clic
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (listener != null) {
                        listener.onSeccionClick(seccion);
                    }
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(new Color(241, 245, 249)); // Slate-100
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(Color.WHITE);
                }
            });
        }

        private void initComponents() {
            txtCodigoSeccion = new JLabel();
            txtAula = new JLabel();
            txtCupoMax = new JLabel();

            txtCodigoSeccion.setFont(new Font("Segoe UI", Font.BOLD, 15));
            txtCodigoSeccion.setForeground(new Color(15, 23, 42));

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
                                                    .addGap(30, 30, 30)
                                                    .addComponent(txtCupoMax)))
                                    .addContainerGap(200, Short.MAX_VALUE))
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
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
    }
}