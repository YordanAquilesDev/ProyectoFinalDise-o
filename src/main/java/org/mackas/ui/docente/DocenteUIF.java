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
import org.mackas.service.factory.ServiceFactory;
import org.mackas.service.impl.AlumnoServiceImpl;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.impl.SeccionServiceImpl;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.service.interf.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.mackas.Login;
import org.mackas.model.Docente;
import org.mackas.service.impl.AlumnoServiceImpl;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.service.interf.IAlumnoDao;
import org.mackas.service.interf.ISeccionDao;

public class DocenteUIF extends JFrame {

    private ISeccionDao seccionService;
    private Docente docente;
    private JPanel jpContenedor;
    private JLabel lblHeaderTitulo;
    private SeccionF seccionPantalla; // Instancia de nuestra pantalla autónoma de secciones

    public DocenteUIF(Docente docente, ISeccionDao seccionService) {
        this.seccionService = seccionService;// Instanciamos el servicio de alumnos
        this.docente = docente;

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Portal del Docente - " + (docente != null ? docente.getNombres() : ""));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (this.docente != null && this.docente.getIdDocente() == 0) {
            this.docente.setIdDocente(1); // Valor por defecto para pruebas si es necesario
        }

        initComponentsPersonalizado();
        cargarVistaSecciones(); // Carga inicial por defecto
    }

    private void initComponentsPersonalizado() {
        getContentPane().setBackground(new Color(248, 250, 252));
        setLayout(new BorderLayout());

        // --- Barra de Menú Moderna ---
        JMenuBar menuPrincipal = new JMenuBar();
        menuPrincipal.setBackground(new Color(15, 23, 42)); // Slate-900
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JMenu mnSecciones = crearEstiloMenu("📚  Mis Secciones");
        JMenu mnSalir = crearEstiloMenu("🚪  Salir");

        // Al hacer clic en "Mis Secciones", ordenamos a SeccionF que vuelva a mostrar sus tarjetas de secciones
        mnSecciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarVistaSecciones();
            }
        });

        mnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir();
            }
        });

        menuPrincipal.add(mnSecciones);
        menuPrincipal.add(Box.createHorizontalGlue()); // Empuja salir hacia la derecha
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

        // --- Contenedor Central Dinámico ---
        jpContenedor = new JPanel(new BorderLayout());
        jpContenedor.setBackground(new Color(248, 250, 252));
        jpContenedor.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));

        add(jpContenedor, BorderLayout.CENTER);
    }

    private JMenu crearEstiloMenu(String texto) {
        JMenu menu = new JMenu(texto);
        menu.setForeground(new Color(226, 232, 240));
        menu.setFont(new Font("Segoe UI", Font.BOLD, 13));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
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

    /**
     * Carga la pantalla SeccionF dentro del contenedor principal,
     * delegando toda la lógica de secciones y alumnos de forma totalmente autónoma.
     */
    public void cargarVistaSecciones() {
        lblHeaderTitulo.setText("📚 Mis Secciones Asignadas");
        jpContenedor.removeAll();
        IAlumnoDao alumnoService= ServiceFactory.AlumnoServiceFactory();
        // 1. Instanciamos SeccionF pasándole sus dependencias
        seccionPantalla = new SeccionF(docente, seccionService, alumnoService);

        // 2. Envolvemos la pantalla en un JScrollPane general para asegurar el scroll correcto
        JScrollPane scrollPane = new JScrollPane(seccionPantalla);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(248, 250, 252));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        jpContenedor.add(scrollPane, BorderLayout.CENTER);
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void salir() {
        IUsuarioDao userService=ServiceFactory.UserServiceFactory();
        IMatriculaDao matriculaService=ServiceFactory.MatriculaServiceFactory();
        Login irALogin = new Login(userService, matriculaService);
        irALogin.setVisible(true);
        this.dispose();
    }
}