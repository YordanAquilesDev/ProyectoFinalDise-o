/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.mackas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import org.mackas.model.Alumno;
import org.mackas.model.Docente;
import org.mackas.model.Usuario;
import org.mackas.service.impl.MatriculaServiceImpl;
import org.mackas.service.impl.UserServiceImpl;
import org.mackas.service.interf.UserService;

import org.mackas.ui.alumno.AlumnoUIF;
import org.mackas.ui.alumno.MatriculaUI;
import org.mackas.ui.alumno.Matriculas;
import org.mackas.ui.docente.DocenteUIF;

/**
 *
 * @author Administrador
 */
public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    UserService userService = new UserServiceImpl();
    private MatriculaServiceImpl matriculaService = new MatriculaServiceImpl();

    public Login() {
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setTitle("Sistema Académico - Iniciar Sesión");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        txtCodigo = new JTextField();
        txtPass = new JPasswordField(); // Cambiado a JPasswordField para mayor seguridad
        btnEntrar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Estilo de fondo moderno (Blanco limpio tipo tarjeta corporativa)
        jPanel1.setBackground(new Color(255, 255, 255));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(new Color(30, 41, 59));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("¡Bienvenido!");

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 13));
        jLabel2.setForeground(new Color(100, 116, 139));
        jLabel2.setText("Código de Usuario:");

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 13));
        jLabel3.setForeground(new Color(100, 116, 139));
        jLabel3.setText("Contraseña:");

        txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCodigo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(226, 232, 240)),
                javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));

        txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPass.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new Color(226, 232, 240)),
                javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));

        // Botón con el color institucional elegante (Azul/Morado)
        btnEntrar.setBackground(new Color(79, 70, 229));
        btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setText("Iniciar Sesión");
        btnEntrar.setFocusPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(this::btnEntrarActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtCodigo)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPass)
                                        .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Obtener y limpiar los textos
        String codigo = txtCodigo.getText().trim();
        // Nota: En JPasswordField se usa .getPassword() para extraer la cadena de manera segura
        String password = new String(txtPass.getPassword()).trim();

        // 2. Validar campos vacíos
        if (codigo.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, complete todos los campos.",
                    "Campos Vacíos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 3. Intentar iniciar sesión (Tu lógica original intacta)
        Usuario user = userService.login(codigo, password);

        // 4. Validar si el usuario existe
        if (user == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Código o contraseña incorrectos.",
                    "Error de Autenticación",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 5. Redireccionar según el rol del usuario
        // 5. Redireccionar según el rol del usuario
        if (user instanceof Alumno) {
            Alumno alumno = (Alumno) user;

            
            if (!matriculaService.isMatricula(alumno.getIdAlumno())) {
                // Si NO tiene matrícula, lo mandamos a matricularse
                MatriculaUI mtc = new MatriculaUI(alumno);
                mtc.setVisible(true);
            } else {
                // Si YA tiene matrícula, entra a su panel principal del alumno
                AlumnoUIF alumniUIF = new AlumnoUIF(alumno);
                alumniUIF.setVisible(true);
            }

        } else if (user instanceof Docente) {
            Docente docenteUser = (Docente) user;
            DocenteUIF docenteUIF = new DocenteUIF(docenteUser);
            docenteUIF.setVisible(true);
        }

        // Cerramos la ventana de login al ingresar con éxito
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify
    private JButton btnEntrar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JTextField txtCodigo;
    private JPasswordField txtPass; // Actualizado a JPasswordField
    // End of variables declaration
}
