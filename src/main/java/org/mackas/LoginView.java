package org.mackas;


import org.mackas.config.Data;
import org.mackas.ui.alumno.AlumnoView;
import org.mackas.ui.docente.DocenteView;

import javax.swing.*;
import java.awt.*;
import org.mackas.ui.docente.HomeDocenteView;

public class LoginView extends JFrame {

    private final Data data;

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JComboBox<String> cbRol;
    private JButton btnIngresar;

    public LoginView(Data data) {
        this.data = data;
        initUI();
        data.Init();
    }

    private void initUI() {
        setTitle("Sistema Académico - Inicio de Sesión");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        gbc.gridwidth = 1; // Restablecer ancho de celda

        // Selección de Rol
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Tipo de Usuario:"), gbc);

        cbRol = new JComboBox<>(new String[]{"Alumno", "Docente", "Administrador"});
        gbc.gridx = 1;
        panel.add(cbRol, gbc);

        // Código / Usuario
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Código / Correo:"), gbc);

        txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Contraseña:"), gbc);

        txtPassword = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        // Botón de Ingreso
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnIngresar.setBackground(new Color(0, 122, 255));
        btnIngresar.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnIngresar, gbc);

        add(panel);

        // Acción al hacer clic en Ingresar
        btnIngresar.addActionListener(e -> autenticar());
    }

    private void autenticar() {
        String rol = (String) cbRol.getSelectedItem();
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if ("Alumno".equals(rol)) {
            // Abre la vista del alumno y oculta la ventana de login
            AlumnoView alumnoView = new AlumnoView(data);
            alumnoView.mostrarPanelAlumno();
            this.dispose(); // Cierra la pantalla de Login
        } else if ("Docente".equals(rol)) {
            // Abre la vista del docente y oculta la pantalla de login
            HomeDocenteView docenteView = new HomeDocenteView(data.docente1);
            docenteView.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Módulo de Administrador en desarrollo.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}