package org.mackas.ui.alumno;

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
import org.mackas.model.Calificacion;
import org.mackas.model.Carrera;
import org.mackas.model.Curso;
import org.mackas.model.Horario;
import org.mackas.service.impl.CalificacionServiceImpl;
import org.mackas.service.impl.CarreraServiceImpl;
import org.mackas.service.impl.CursoServiceImpl;
import org.mackas.service.impl.HorarioServiceImpl;
import org.mackas.service.impl.PensionServiceImpl;
import org.mackas.service.interf.IPensionDao;

public class AlumnoUIF extends JFrame {

    private CursoServiceImpl cursoService = new CursoServiceImpl();
    private CalificacionServiceImpl caliService = new CalificacionServiceImpl();
    private HorarioServiceImpl horaService = new HorarioServiceImpl();
    private CarreraServiceImpl carrService = new CarreraServiceImpl();

    private final Alumno alumno;
    List<Curso> cursosAlumno;
    List<Horario> horariosAlumno;

    private JPanel jpContenedor;
    private JScrollPane scrollPane;
    private JLabel lblHeaderTitulo;

    public AlumnoUIF(Alumno alumno) {
        this.alumno = alumno;
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Portal del Alumno - " + (alumno != null ? alumno.getNombres() : ""));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initComponentsPersonalizado();

        if (alumno != null) {
            cursosAlumno = cursoService.findByIdAlumno(alumno.getIdAlumno());
            horariosAlumno = horaService.findByIdAlumno(alumno.getIdAlumno());
            mostrarCursos(); // Vista por defecto al abrir
        }
    }

    private void initComponentsPersonalizado() {
        getContentPane().setBackground(new Color(248, 250, 252)); // Fondo gris muy suave tipo Tailwind slate-50
        setLayout(new BorderLayout());

        // --- Barra de Menú Superior Estilo Corporativo ---
        JMenuBar menuPrincipal = new JMenuBar();
        menuPrincipal.setBackground(new Color(15, 23, 42)); // Slate-900 (Azul oscuro profundo)
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JMenu mnCursos = crearEstiloMenu("📚  Mis Cursos");
        JMenu mnNotas = crearEstiloMenu("📊  Calificaciones");
        JMenu mnHorarios = crearEstiloMenu("🕒  Horarios");
        JMenu mnPagos = crearEstiloMenu("💳  Pagos");
        JMenu mnPerfil = crearEstiloMenu("👤  Perfil");
        JMenu mnSalir = crearEstiloMenu("🚪  Salir");

        mnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir();
            }
        });
        
        mnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarPerfil();
            }
        });
        
        mnPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarPagos();
            }
        });

        mnCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarCursos();
            }
        });

        mnNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarNotas();
            }
        });

        mnHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarHorarios();
            }
        });

        menuPrincipal.add(mnCursos);
        menuPrincipal.add(mnNotas);
        menuPrincipal.add(mnHorarios);
        menuPrincipal.add(mnPagos);
        
        // Empujar perfil y salir hacia la derecha
        menuPrincipal.add(Box.createHorizontalGlue());
        menuPrincipal.add(mnPerfil);
        menuPrincipal.add(mnSalir);
        
        setJMenuBar(menuPrincipal);

        // --- Panel Superior de Título dinámico ---
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 20));
        panelTop.setBackground(new Color(248, 250, 252));
        lblHeaderTitulo = new JLabel("Mis Cursos Matriculados");
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
        menu.setForeground(new Color(226, 232, 240)); // Texto claro
        menu.setFont(new Font("Segoe UI", Font.BOLD, 13));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        
        // ¡Importante para eliminar la opacidad gris por defecto!
        menu.setOpaque(true);
        menu.setBackground(new Color(15, 23, 42)); // Mismo color oscuro que el JMenuBar (Slate-900)

        // Efecto hover profesional (cambia de color sutilmente al pasar el mouse)
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu.setBackground(new Color(30, 41, 59)); // Slate-800 (Un poco más claro)
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu.setBackground(new Color(15, 23, 42)); // Vuelve al color original
            }
        });

        return menu;
    }
    
    private void mostrarPerfil(){
        lblHeaderTitulo.setText("Mi Perfil de Alumno");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new BorderLayout());
        JLabel lbl = new JLabel("Módulo de perfil en construcción...", JLabel.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        jpContenedor.add(lbl, BorderLayout.CENTER);
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void mostrarCursos() {
        lblHeaderTitulo.setText("📚 Mis Cursos Matriculados");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 25, 25));

        if (cursosAlumno != null) {
            for (Curso c : cursosAlumno) {
                Carrera carr = carrService.findById(c.getId_carrera());
                String nombreCarrera = (carr != null) ? carr.getNombre_carrera() : "Sin Carrera";

                CursosF card = new CursosF(
                    c.getId_curso(),
                    c.getNombre_curso(),
                    c.getCreditos(),
                    nombreCarrera,
                    "Presencial",
                    c.getCiclo_nivel()
                );
                jpContenedor.add(card);
            }
        }
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void mostrarNotas() {
        lblHeaderTitulo.setText("📊 Registro de Calificaciones");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 1, 20, 20)); 

        if (cursosAlumno != null) {
            for (Curso c : cursosAlumno) {
                List<Calificacion> calificacionPorCurso = caliService.findByIdCursoAlumno(c.getId_curso(), alumno.getIdAlumno());
                NotasF cardNotas = new NotasF();
                cardNotas.setNombreCurso("Curso: " + c.getNombre_curso());
                cardNotas.limpiarTabla();

                for (Calificacion ca : calificacionPorCurso) {
                    cardNotas.addNota(ca);
                }
                jpContenedor.add(cardNotas);
            }
        }
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void mostrarHorarios() {
        lblHeaderTitulo.setText("🕒 Horarios de Clases");
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 25, 25));

        if (horariosAlumno != null) {
            horariosAlumno.forEach(h -> {
                HorariosF cardHorario = new HorariosF(
                    h.getAula(),
                    h.getHora_fin(),
                    h.getHora_inicio(),
                    h.getId_horario(),
                    h.getId_seccion(),
                    h.getDia_semana()
                );
                jpContenedor.add(cardHorario);
            });
        }
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }
  
    private void mostrarPagos(){
        lblHeaderTitulo.setText("💳 Gestión de Pensiones y Pagos");
        jpContenedor.removeAll(); 
        jpContenedor.setLayout(new BorderLayout()); 
        
        IPensionDao pensionService = new PensionServiceImpl();
        PagoF pantallaPagos = new PagoF(alumno, pensionService);
        
        jpContenedor.add(pantallaPagos, BorderLayout.CENTER); 
        jpContenedor.revalidate();
        jpContenedor.repaint();
    }

    private void salir(){
        Login irALogin = new Login();
        irALogin.setVisible(true);
        this.dispose();
    }
}