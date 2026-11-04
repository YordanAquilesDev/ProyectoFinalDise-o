package org.mackas.ui.docente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.mackas.Login;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;
import org.mackas.model.Seccion;
import org.mackas.service.impl.AlumnoServiceImpl;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.impl.SeccionServiceImpl;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.service.interf.IAlumnoDao;
import org.mackas.service.interf.ISeccionDao;

public class DocenteUIF extends JFrame {

    private ISeccionDao secService = new SeccionServiceImpl();
    private IAlumnoDao aluService = new AlumnoServiceImpl();

    private Docente docente;
    private List<Seccion> seccionDocente;

    private JPanel jpContenedor;
    private JScrollPane scrollPane;
    private JLabel lblHeaderTitulo;

    public DocenteUIF(Docente docente) {
        this.docente = docente;
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Portal del Docente - " + (docente != null ? docente.getNombres() : ""));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Nota: Asegúrate de que el idDocente venga autenticado desde el Login. 
        // Si lo fuerzas a 1 para pruebas, déjalo aquí:
        if (this.docente != null) {
            if (this.docente.getIdDocente() == 0) {
                this.docente.setIdDocente(1); 
            }
            this.seccionDocente = secService.findByIdDocente(this.docente.getIdDocente());
        }

        initComponentsPersonalizado();
        listarSecciones();
    }

    private void initComponentsPersonalizado() {
        getContentPane().setBackground(new Color(248, 250, 252)); // Slate-50 suave
        setLayout(new BorderLayout());

        // --- Barra de Menú Moderna ---
        JMenuBar menuPrincipal = new JMenuBar();
        menuPrincipal.setBackground(new Color(15, 23, 42)); // Slate-900
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JMenu mnSecciones = crearEstiloMenu("📚  Mis Secciones");
        JMenu mnSalir = crearEstiloMenu("🚪  Salir");

        mnSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listarSecciones();
            }
        });

        mnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir();
            }
        });

        menuPrincipal.add(mnSecciones);
        menuPrincipal.add(Box.createHorizontalGlue()); // Empuja salir a la derecha
        menuPrincipal.add(mnSalir);
        
        setJMenuBar(menuPrincipal);

        // --- Panel Superior de Título dinámico ---
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 20));
        panelTop.setBackground(new Color(248, 250, 252));
        lblHeaderTitulo = new JLabel("Secciones Asignadas");
        lblHeaderTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblHeaderTitulo.setForeground(new Color(30, 41, 59));
        panelTop.add(lblHeaderTitulo);
        add(panelTop, BorderLayout.NORTH);

        // --- Contenedor Principal de Tarjetas ---
        jpContenedor = new JPanel();
        jpContenedor.setLayout(new GridLayout(0, 2, 25, 25)); 
        jpContenedor.setBackground(new Color(248, 250, 252));
        jpContenedor.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));

        scrollPane = new JScrollPane(jpContenedor);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(248, 250, 252));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    private JMenu crearEstiloMenu(String texto) {
        JMenu menu = new JMenu(texto);
        menu.setForeground(new Color(226, 232, 240));
        menu.setFont(new Font("Segoe UI", Font.BOLD, 13));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        // Evita el fondo gris opaco por defecto en Swing
        menu.setOpaque(true);
        menu.setBackground(new Color(15, 23, 42));

        // Efecto Hover suave
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu.setBackground(new Color(30, 41, 59));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu.setBackground(new Color(15, 23, 42));
            }
        });

        return menu;
    }

    public void listarSecciones() {
        lblHeaderTitulo.setText("📚 Secciones Asignadas");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 25, 25));

        if (seccionDocente != null && !seccionDocente.isEmpty()) {
            for (Seccion sec : seccionDocente) {
                SeccionesF seccionCard = new SeccionesF(sec, clickedSeccion -> {
                    mostrarAlumnosPorSeccion(clickedSeccion.getId_seccion(), clickedSeccion.getCodigo_seccion());
                });
                jpContenedor.add(seccionCard);
            }
        } else {
            JLabel lblVacio = new JLabel("No hay secciones asignadas para este docente.");
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            jpContenedor.add(lblVacio);
        }

        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    public void mostrarAlumnosPorSeccion(int idSeccion, String codigoSeccion) {
        lblHeaderTitulo.setText("👥 Alumnos Matriculados - Sección: " + codigoSeccion);
        List<Alumno> alumnosSeccion = aluService.findByIdSeccion(idSeccion);

        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 25, 25));

        if (alumnosSeccion != null && !alumnosSeccion.isEmpty()) {
            for (Alumno alu : alumnosSeccion) {
                AlumnosF alumnoCard = new AlumnosF(alu, idSeccion);
                jpContenedor.add(alumnoCard);
            }
        } else {
            JLabel lblVacio = new JLabel("No hay alumnos registrados en esta sección.");
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            jpContenedor.add(lblVacio);
        }

        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void salir() {
          Login irALogin=new Login( new UserServiceImpl(), new MatriculaServiceImpl());
        irALogin.setVisible(true);
        this.dispose();
    }
}