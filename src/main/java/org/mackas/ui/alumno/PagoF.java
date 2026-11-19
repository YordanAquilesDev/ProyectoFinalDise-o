package org.mackas.ui.alumno;

import org.mackas.model.Alumno;
import org.mackas.model.Pension;
import org.mackas.service.estrategy.PagoBBVA;
import org.mackas.service.estrategy.PagoBCP;
import org.mackas.service.estrategy.PagoEstrategy;
import org.mackas.service.estrategy.PagoVisa;
import org.mackas.service.impl.ProcesarPagoEstrategy;
import org.mackas.service.interf.IPensionDao;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class PagoF extends JPanel {
    private Alumno alumno;
    private IPensionDao pensionDao;
    private JPanel contenedorTarjetas;

    public PagoF(Alumno alumno, IPensionDao pensionDao) {
        this.alumno = alumno;
        this.pensionDao = pensionDao;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 247, 250));

        // Título superior
        JLabel lblTitulo = new JLabel("Gestión de Pagos de Pensiones - " + alumno.getNombres() + " " + alumno.getApellidos(), JLabel.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(30, 41, 59));
        add(lblTitulo, BorderLayout.NORTH);

        // Contenedor de las tarjetas de pensiones
        contenedorTarjetas = new JPanel();
        contenedorTarjetas.setLayout(new BoxLayout(contenedorTarjetas, BoxLayout.Y_AXIS));
        contenedorTarjetas.setBackground(new Color(245, 247, 250));
        
        JScrollPane scrollPane = new JScrollPane(contenedorTarjetas);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(245, 247, 250));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar las pensiones del alumno
        cargarPensiones();
    }

    private void cargarPensiones() {
        contenedorTarjetas.removeAll();
        
        List<Pension> listaPensiones = pensionDao.findByIdAlumno(alumno.getIdAlumno());

        if (listaPensiones == null || listaPensiones.isEmpty()) {
            JLabel lblVacio = new JLabel("No hay pensiones registradas para este alumno.");
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            contenedorTarjetas.add(lblVacio);
        } else {
            for (Pension p : listaPensiones) {
                contenedorTarjetas.add(crearTarjetaPension(p));
                contenedorTarjetas.add(Box.createRigidArea(new Dimension(0, 15))); // Espacio entre tarjetas
            }
        }
        
        contenedorTarjetas.revalidate();
        contenedorTarjetas.repaint();
    }

    private JPanel crearTarjetaPension(Pension pension) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1, true),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        
        boolean esPagado = "PAGADO".equalsIgnoreCase(pension.getEstado());

        // Información principal
        String infoText = "<html><b style='font-size:12px; color:#1e293b;'>Cuota N° " + pension.getNumeroCuota() + "</b><br>" +
                          "<span style='color:#64748b;'>Monto a pagar: </span><b>S/. " + pension.getMonto() + "</b> | " +
                          "<span style='color:#64748b;'>Vencimiento: </span>" + pension.getFechaVencimiento() + "<br>" +
                          "Estado: <span style='color:" + (esPagado ? "#16a34a" : "#dc2626") + "; font-weight:bold;'>" + pension.getEstado() + "</span></html>";
        
        JLabel lblInfo = new JLabel(infoText);
        card.add(lblInfo, BorderLayout.CENTER);

        // Si está pendiente, agregamos un botón profesional que abrirá la ventana de pago
        if (!esPagado) {
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            panelBoton.setBackground(Color.WHITE);

            JButton btnPagarModal = new JButton("💳 Pagar Ahora");
            btnPagarModal.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btnPagarModal.setBackground(new Color(37, 99, 235)); // Azul corporativo
            btnPagarModal.setForeground(Color.WHITE);
            btnPagarModal.setFocusPainted(false);
            btnPagarModal.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnPagarModal.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

            btnPagarModal.addActionListener(e -> abrirFormularioPago(pension));

            panelBoton.add(btnPagarModal);
            card.add(panelBoton, BorderLayout.EAST);
        }

        // Fijar un tamaño óptimo para la tarjeta tipo lista corporativa
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 95));
        card.setPreferredSize(new Dimension(600, 95));
        return card;
    }

    // --- FORMULARIO MODAL CORREGIDO (Sin problemas de foco ni de clics) ---
    private void abrirFormularioPago(Pension pension) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Pasarela de Pago Segura", true);
        dialog.setSize(440, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        // Panel principal con diseño vertical (BoxLayout Y_AXIS)
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        panelForm.setBackground(Color.WHITE);

        // 1. Encabezado
        JLabel lblEncabezado = new JLabel("Pagar Cuota N° " + pension.getNumeroCuota() + " (S/. " + pension.getMonto() + ")");
        lblEncabezado.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEncabezado.setForeground(new Color(15, 23, 42));
        lblEncabezado.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 2. Combo Método de Pago
        JLabel lblMetodo = new JLabel("Seleccione Entidad / Tarjeta:");
        lblMetodo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblMetodo.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JComboBox<String> cmbMetodos = new JComboBox<>(new String[]{"BCP", "BBVA", "Visa"});
        cmbMetodos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        cmbMetodos.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 3. Número de Tarjeta
        JTextField txtNumeroTarjeta = new JTextField();
        txtNumeroTarjeta.setBorder(BorderFactory.createTitledBorder("Número de Tarjeta (16 dígitos)"));
        txtNumeroTarjeta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        txtNumeroTarjeta.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 4. Panel Doble (Expiración y CVV)
        JPanel panelDoble = new JPanel(new GridLayout(1, 2, 10, 0));
        panelDoble.setBackground(Color.WHITE);
        panelDoble.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        panelDoble.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField txtExpiracion = new JTextField();
        txtExpiracion.setBorder(BorderFactory.createTitledBorder("MM/AA"));
        JTextField txtCvv = new JTextField();
        txtCvv.setBorder(BorderFactory.createTitledBorder("CVV"));
        
        panelDoble.add(txtExpiracion);
        panelDoble.add(txtCvv);

        // 5. Titular
        JTextField txtTitular = new JTextField();
        txtTitular.setBorder(BorderFactory.createTitledBorder("Nombre del Titular"));
        txtTitular.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        txtTitular.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 6. Botón Confirmar
        JButton btnConfirmar = new JButton("Confirmar Pago de S/. " + pension.getMonto());
        btnConfirmar.setBackground(new Color(22, 163, 74)); // Verde éxito
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnConfirmar.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Acción al confirmar pago
        btnConfirmar.addActionListener(e -> {
            if (txtNumeroTarjeta.getText().trim().isEmpty() || txtTitular.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Por favor complete los campos obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String metodoSeleccionado = (String) cmbMetodos.getSelectedItem();
            PagoEstrategy estrategia = switch (metodoSeleccionado) {
                case "BCP" -> new PagoBCP();
                case "BBVA" -> new PagoBBVA();
                case "Visa" -> new PagoVisa();
                default -> null;
            };

            try {
                pension.setEstado("PAGADO");
                pension.setFechaPago(LocalDateTime.now());

                ProcesarPagoEstrategy procesador = new ProcesarPagoEstrategy(pensionDao);
                procesador.setMetodoPago(estrategia);

                boolean exito = procesador.procesarYGuardarPago(pension);

                if (exito) {
                    JOptionPane.showMessageDialog(dialog, "¡Pago procesado exitosamente con " + metodoSeleccionado + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    cargarPensiones(); 
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error al procesar el pago en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Excepción", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ensamblar componentes con espacios visuales limpios (Struts)
        panelForm.add(lblEncabezado);
        panelForm.add(Box.createVerticalStrut(15));
        panelForm.add(lblMetodo);
        panelForm.add(Box.createVerticalStrut(5));
        panelForm.add(cmbMetodos);
        panelForm.add(Box.createVerticalStrut(10));
        panelForm.add(txtNumeroTarjeta);
        panelForm.add(Box.createVerticalStrut(10));
        panelForm.add(panelDoble);
        panelForm.add(Box.createVerticalStrut(10));
        panelForm.add(txtTitular);
        panelForm.add(Box.createVerticalStrut(20));
        panelForm.add(btnConfirmar);

        dialog.add(panelForm, BorderLayout.CENTER);

        // Forzar el foco inicial en el campo de la tarjeta al abrirse la ventana
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                txtNumeroTarjeta.requestFocusInWindow();
            }
        });

        dialog.setVisible(true);
    }
}