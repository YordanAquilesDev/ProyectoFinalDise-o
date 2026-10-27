package org.mackas.ui.docente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;
import org.mackas.model.Seccion;
import org.mackas.service.impl.AlumnoServiceImpl;
import org.mackas.service.impl.SeccionServiceImpl;
import org.mackas.service.interf.AlumnoService;
import org.mackas.service.interf.SeccionService;

public class DocenteUIF extends JFrame {

    private SeccionService secService = new SeccionServiceImpl();
    private AlumnoService aluService = new AlumnoServiceImpl();

    private Docente docente;
    private List<Seccion> seccionDocente;

    private JPanel jpContenedor;
    private JScrollPane scrollPane;

    public DocenteUIF(Docente docente) {
        this.docente = docente;
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Portal del Docente - " + (docente != null ? docente.getNombres() : ""));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        docente.setIdDocente(1);
        if (docente != null) {
            this.seccionDocente = secService.findByIdDocente(docente.getIdDocente());
        }

        initComponentsPersonalizado();

        // Al abrir la ventana, cargamos por defecto sus secciones
        listarSecciones();
    }

    private void initComponentsPersonalizado() {
        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(new BorderLayout());

        // Barra de Menú Moderna
        JMenuBar menuPrincipal = new JMenuBar();
        menuPrincipal.setBackground(new Color(30, 41, 59));
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JMenu mnSecciones = crearEstiloMenu("📚 Mis Secciones");
        JMenu mnCerrarSesion = crearEstiloMenu("🚪 Salir");

        // Evento para volver a ver las secciones principales
        mnSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarSecciones();
            }
        });

        mnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // Cierra esta ventana
                // Aquí podrías abrir tu Login si lo deseas
            }
        });

        menuPrincipal.add(mnSecciones);
        menuPrincipal.add(mnCerrarSesion);
        setJMenuBar(menuPrincipal);

        // Contenedor principal de tarjetas
        jpContenedor = new JPanel();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20)); // Cuadrícula de 2 columnas
        jpContenedor.setBackground(new Color(245, 247, 250));
        jpContenedor.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // ScrollPane para evitar que se desborde el contenido
        scrollPane = new JScrollPane(jpContenedor);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(245, 247, 250));

        add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    private JMenu crearEstiloMenu(String texto) {
        JMenu menu = new JMenu(texto);
        menu.setForeground(Color.WHITE);
        menu.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return menu;
    }

    // Método para listar las secciones del docente en pantalla
    public void listarSecciones() {
        System.out.println("Mostrando las secciones");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20));
        System.out.println(seccionDocente);
        if (seccionDocente != null) {
            for (Seccion sec : seccionDocente) {
                System.out.println(sec);
                // Instanciamos la tarjeta de sección y le pasamos el listener de clic
                SeccionesF seccionCard = new SeccionesF(sec, clickedSeccion -> {
                    // Al hacer clic en una sección, mostramos los alumnos matriculados en ella
                    mostrarAlumnosPorSeccion(clickedSeccion.getId_seccion(), clickedSeccion.getCodigo_seccion());
                });

                jpContenedor.add(seccionCard);
            }
        }

        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    // Método para que el docente vea los alumnos de una sección específica
    public void mostrarAlumnosPorSeccion(int idSeccion, String codigoSeccion) {
        List<Alumno> alumnosSeccion = aluService.findByIdSeccion(idSeccion);

        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20));

        if (alumnosSeccion != null && !alumnosSeccion.isEmpty()) {
            for (Alumno alu : alumnosSeccion) {
                AlumnosF alumnoCard = new AlumnosF(alu);
                jpContenedor.add(alumnoCard);
            }
        } else {
            System.out.println("No hay alumnos en la sección: " + codigoSeccion);
        }

        jpContenedor.revalidate();
        jpContenedor.repaint();
    }
}
