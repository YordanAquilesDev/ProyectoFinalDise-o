package org.mackas.model;

public class Calificacion {
    String PC1;
    String PC2;
    String PA;
    String EX;

    public String getPC1() {
        return PC1;
    }

    public Calificacion(String PC1, String PC2, String PA, String EX) {
        this.PC1 = PC1;
        this.PC2 = PC2;
        this.PA = PA;
        this.EX = EX;
    }

    public void setPC1(String PC1) {
        this.PC1 = PC1;
    }

    public String getPC2() {
        return PC2;
    }

    public void setPC2(String PC2) {
        this.PC2 = PC2;
    }

    public String getPA() {
        return PA;
    }

    public void setPA(String PA) {
        this.PA = PA;
    }

    public String getEX() {
        return EX;
    }

    public void setEX(String EX) {
        this.EX = EX;
    }
}
