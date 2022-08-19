package io.github.guisso.jakartacalculadora;

/**
 * Classe Calculadora
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 19/08/2022
 */
public class Calculadora {

    private Double a;
    private Double b;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Calculadora() {
    }

    public Calculadora(Double a, Double b) {
        this.a = a;
        this.b = b;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }
    //</editor-fold>

    public Double somar() {
        return a + b;
    }

    public Double subtrair() {
        return a - b;
    }

    public Double multiplicar() {
        return a * b;
    }

    public Double dividir() {
        return a / b;
    }

}
