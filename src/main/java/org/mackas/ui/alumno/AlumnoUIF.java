package org.mackas.ui.alumno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.mackas.model.Alumno;
import org.mackas.model.Calificacion;
import org.mackas.model.Carrera;
import org.mackas.model.Curso;
import org.mackas.model.Horario;
import org.mackas.service.impl.CalificacionServiceImpl;
import org.mackas.service.impl.CarreraServiceImpl;
import org.mackas.service.impl.CursoServiceImpl;
import org.mackas.service.impl.HorarioServiceImpl;

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

    public AlumnoUIF(Alumno alumno) {
        this.alumno = alumno;
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Portal del Alumno - " + (alumno != null ? alumno.getNombres() : ""));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initComponentsPersonalizado();

        if (alumno != null) {
            cursosAlumno = cursoService.findByIdAlumno(alumno.getIdAlumno());
            horariosAlumno = horaService.findByIdAlumno(alumno.getIdAlumno());
        }
    }

    private void initComponentsPersonalizado() {
        // Configuración general de la ventana
        getContentPane().setBackground(new Color(245, 247, 250));
        setLayout(new BorderLayout());

        // Barra de Menú Moderna
        JMenuBar menuPrincipal = new JMenuBar();
        menuPrincipal.setBackground(new Color(30, 41, 59));
        menuPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JMenu mnCursos = crearEstiloMenu("📚 Mis Cursos");
        JMenu mnNotas = crearEstiloMenu("📊 Calificaciones");
        JMenu mnHorarios = crearEstiloMenu("🕒 Horarios");
        JMenu mnPagos = crearEstiloMenu("💳 Pagos");

        // Eventos de clic
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
        setJMenuBar(menuPrincipal);

        // Contenedor principal de tarjetas con diseño de cuadrícula flexible
        jpContenedor = new JPanel();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20)); // 2 columnas para aprovechar mejor el espacio horizontal
        jpContenedor.setBackground(new Color(245, 247, 250));
        jpContenedor.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        // Envolvemos el contenedor en un ScrollPane por si la lista es grande
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

    private void mostrarCursos() {
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20));

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
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 1, 15, 15)); // 1 por fila para que la tabla luzca amplia

        if (cursosAlumno != null) {
            for (Curso c : cursosAlumno) {
                List<Calificacion> calificacionPorCurso = caliService.findByIdCurso(c.getId_curso());
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
        jpContenedor.removeAll();
        jpContenedor.setLayout(new GridLayout(0, 2, 20, 20));

        if (horariosAlumno != null) {
            horariosAlumno.forEach(h -> {
                Horarios cardHorario = new Horarios(
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
}