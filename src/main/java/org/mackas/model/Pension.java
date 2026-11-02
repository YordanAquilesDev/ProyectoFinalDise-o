package org.mackas.model;



import java.time.LocalDateTime;


import java.time.LocalDate;

public class Pension {
    private int idPension;
    private int idAlumno;
    private int idMatricula;
    private int numeroCuota;
    private double monto;
    private double montoMora;
    private LocalDate fechaVencimiento;
    private LocalDateTime fechaPago; // Puede ser null si aún no se paga
    private String estado;         // Ej: 'PENDIENTE', 'PAGADO'

    // Constructor vacío
    public Pension() {
        this.montoMora = 0.00;
        this.estado = "PENDIENTE";
    }

    // Constructor completo
    public Pension(int idPension, int idAlumno, int idMatricula, int numeroCuota, 
                   double monto, double montoMora, LocalDate fechaVencimiento, 
                   LocalDateTime fechaPago, String estado) {
        this.idPension = idPension;
        this.idAlumno = idAlumno;
        this.idMatricula = idMatricula;
        this.numeroCuota = numeroCuota;
        this.monto = monto;
        this.montoMora = montoMora;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdPension() {
        return idPension;
    }

    public void setIdPension(int idPension) {
        this.idPension = idPension;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(double montoMora) {
        this.montoMora = montoMora;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cuota N° " + numeroCuota + " - Monto: $" + monto + " [" + estado + "]";
    }
}