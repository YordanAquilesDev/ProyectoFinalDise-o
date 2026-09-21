package org.mackas;

import org.mackas.config.Data;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Aplicar el tema gráfico del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            Data datos = new Data();
            datos.Init(); // Carga de secciones, alumnos y docentes

            // Lanzar la ventana de Login
            LoginView loginView = new LoginView(datos);
            loginView.setVisible(true);
        });
    }
}