package modelo;

import java.util.Objects;

public class Tetraedro extends Cuerpo {
    private Equilatero cara;

    public Tetraedro(Equilatero cara) {
        super("Tetraedro");
        setCara(cara);
    }

    public Equilatero getCara() {
        return cara;
    }

    public void setCara(Equilatero cara) {
        if (cara == null) {
            throw new IllegalArgumentException("El tetraedro debe tener una cara triangular equilátera.");
        }

        this.cara = cara;
    }

    @Override
    public double calcularArea() {
        return 4 * cara.calcularArea();
    }

    @Override
    public double calcularPerimetro() {
        return 6 * cara.getLado();
    }

    @Override
    public double calcularVolumen() {
        double lado = cara.getLado();
        return Math.pow(lado, 3) / (6 * Math.sqrt(2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tetraedro)) {
            return false;
        }

        Tetraedro tetraedro = (Tetraedro) obj;
        return Objects.equals(cara, tetraedro.cara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cara);
    }

    @Override
    public String toString() {
        return "Tetraedro{cara=" + cara + "}";
    }
}