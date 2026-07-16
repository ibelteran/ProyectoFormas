package modelo;

import java.util.Objects;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser mayor que cero.");
        }

        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Circulo)) {
            return false;
        }

        Circulo circulo = (Circulo) obj;
        return Double.compare(circulo.radio, radio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }

    @Override
    public String toString() {
        return "Círculo{radio=" + radio + "}";
    }
}
