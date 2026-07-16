package modelo;

import java.util.Objects;

public class Cubo extends Cuerpo {
    private Cuadrado cara;

    public Cubo(Cuadrado cara) {
        super("Cubo");
        setCara(cara);
    }

    public Cuadrado getCara() {
        return cara;
    }

    public void setCara(Cuadrado cara) {
        if (cara == null) {
            throw new IllegalArgumentException("El cubo debe tener una cara cuadrada.");
        }

        this.cara = cara;
    }

    @Override
    public double calcularArea() {
        return 6 * cara.calcularArea();
    }

    @Override
    public double calcularPerimetro() {
        return 12 * cara.getLado();
    }

    @Override
    public double calcularVolumen() {
        return Math.pow(cara.getLado(), 3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cubo)) {
            return false;
        }

        Cubo cubo = (Cubo) obj;
        return Objects.equals(cara, cubo.cara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cara);
    }

    @Override
    public String toString() {
        return "Cubo{cara=" + cara + "}";
    }
}
