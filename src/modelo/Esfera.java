package modelo;

import java.util.Objects;

public class Esfera extends Cuerpo {
    private double radio;

    public Esfera(double radio) {
        super("Esfera");
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
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Esfera)) {
            return false;
        }

        Esfera esfera = (Esfera) obj;
        return Double.compare(esfera.radio, radio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }

    @Override
    public String toString() {
        return "Esfera{radio=" + radio + "}";
    }
}
