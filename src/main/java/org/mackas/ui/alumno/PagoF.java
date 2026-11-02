package org.mackas.ui.alumno;

import org.mackas.model.Alumno;
import org.mackas.model.Pension;
import org.mackas.model.patron.PagoEstrategy;
import org.mackas.service.impl.PagoBCP;
import org.mackas.service.impl.PagoBBVA;
import org.mackas.service.impl.PagoVisa;
import org.mackas.service.impl.ProcesarPagoEstrategy;
import org.mackas.service.interf.IPensionDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;

public class PagoF extends JPanel {
    private Alumno alumno;
    private IPensionDao pensionDao; // Asume que inyectas o instancias tu DAO/Servicio
    private JPanel contenedorTarjetas;

    public PagoF(Alumno alumno, IPensionDao pensionDao) {
        this.alumno = alumno;
        this.pensionDao = pensionDao;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Título superior
        JLabel lblTitulo = new JLabel("Pensiones de: " + alumno.getNombres() + " " + alumno.getApellidos(), JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Contenedor de las tarjetas de pensiones
        contenedorTarjetas = new JPanel();
        contenedorTarjetas.setLayout(new BoxLayout(contenedorTarjetas, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(contenedorTarjetas);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar las pensiones del alumno
        cargarPensiones();
    }

    private void cargarPensiones() {
        contenedorTarjetas.removeAll();
        
        // Obtenemos la lista de pensiones usando el DAO (puedes adaptarlo a tu método de matrícula o alumno)
        // Ejemplo: List<Pension> lista = pensionDao.findByIdMatricula(...);
        List<Pension> listaPensiones = pensionDao.listarPensionesPendientes(alumno.getIdAlumno()); // O tu método correspondiente

        if (listaPensiones.isEmpty()) {
            contenedorTarjetas.add(new JLabel("No hay pensiones pendientes para este alumno."));
        } else {
            for (Pension p : listaPensiones) {
                contenedorTarjetas.add(crearTarjetaPension(p));
                contenedorTarjetas.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre tarjetas
            }
        }
        
        contenedorTarjetas.revalidate();
        contenedorTarjetas.repaint();
    }

    private JPanel crearTarjetaPension(Pension pension) {
        // Panel principal de la tarjeta
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        
        boolean esPagado = "PAGADO".equalsIgnoreCase(pension.getEstado());
        card.setBackground(esPagado ? new Color(230, 245, 230) : Color.WHITE);

        // Información principal (izquierda)
        String infoText = "<html><b>Cuota N° " + pension.getNumeroCuota() + "</b><br>" +
                          "Monto: S/. " + pension.getMonto() + " | Vencimiento: " + pension.getFechaVencimiento() + "<br>" +
                          "Estado: <span style='color:" + (esPagado ? "green" : "red") + ";'>" + pension.getEstado() + "</span></html>";
        JLabel lblInfo = new JLabel(infoText);
        card.add(lblInfo, BorderLayout.CENTER);

        // Si está pendiente, agregamos el panel expandible de pago
        if (!esPagado) {
            JPanel panelExpansion = new JPanel();
            panelExpansion.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
            panelExpansion.setVisible(false); // Oculto por defecto
            panelExpansion.setBackground(card.getBackground());

            // Controles de pago simulado
            JComboBox<String> cmbMetodos = new JComboBox<>(new String[]{"BCP", "BBVA", "Visa"});
            JTextField txtClaveFalsa = new JTextField(8);
            txtClaveFalsa.setToolTipText("Clave / Código secreto");
            
            JButton btnPagar = new JButton("Pagar Ahora");
            btnPagar.setBackground(new Color(40, 167, 69));
            btnPagar.setForeground(Color.WHITE);

            // Acción al hacer clic en pagar
            btnPagar.addActionListener(e -> {
                String metodoSeleccionado = (String) cmbMetodos.getSelectedItem();
                PagoEstrategy estrategia = switch (metodoSeleccionado) {
                    case "BCP" -> new PagoBCP();
                    case "BBVA" -> new PagoBBVA();
                    case "Visa" -> new PagoVisa();
                    default -> null;
                };

                try {
                    // Actualizamos datos en el objeto pension
                    pension.setEstado("PAGADO");
                    pension.setFechaPago(LocalDateTime.now());

                    ProcesarPagoEstrategy procesador = new ProcesarPagoEstrategy(pensionDao);
                    procesador.setMetodoPago(estrategia);

                    boolean exito = procesador.procesarYGuardarPago(pension);

                    if (exito) {
                        JOptionPane.showMessageDialog(this, "¡Pago realizado con éxito mediante " + metodoSeleccionado + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        cargarPensiones(); // Recarga la lista para actualizar los estados
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al procesar el pago en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Atención", JOptionPane.WARNING_MESSAGE);
                }
            });

            panelExpansion.add(new JLabel("Método:"));
            panelExpansion.add(cmbMetodos);
            panelExpansion.add(new JLabel("Código:"));
            panelExpansion.add(txtClaveFalsa);
            panelExpansion.add(btnPagar);

            card.add(panelExpansion, BorderLayout.SOUTH);

            // Evento para expandir / contraer al hacer clic en la tarjeta
            MouseAdapter expandListener = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean visibleActual = panelExpansion.isVisible();
                    panelExpansion.setVisible(!visibleActual);
                    card.revalidate();
                    card.repaint();
                }
            };

            lblInfo.addMouseListener(expandListener);
            card.addMouseListener(expandListener);
        }

        // Fijar un tamaño máximo para que luzca como tarjeta compacta
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        return card;
    }
}