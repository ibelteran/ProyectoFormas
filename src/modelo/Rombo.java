package modelo;

import java.util.Objects;

public class Rombo extends Figura {
    private double diagonalMayor;
    private double diagonalMenor;
    private double lado;

    public Rombo(double diagonalMayor, double diagonalMenor, double lado) {
        super("Rombo");
        setDiagonalMayor(diagonalMayor);
        setDiagonalMenor(diagonalMenor);
        setLado(lado);
    }

    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public void setDiagonalMayor(double diagonalMayor) {
        if (diagonalMayor <= 0) {
            throw new IllegalArgumentException("La diagonal mayor debe ser mayor que cero.");
        }

        this.diagonalMayor = diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public void setDiagonalMenor(double diagonalMenor) {
        if (diagonalMenor <= 0) {
            throw new IllegalArgumentException("La diagonal menor debe ser mayor que cero.");
        }

        this.diagonalMenor = diagonalMenor;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que cero.");
        }

        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Rombo)) {
            return false;
        }

        Rombo rombo = (Rombo) obj;
        return Double.compare(rombo.diagonalMayor, diagonalMayor) == 0
                && Double.compare(rombo.diagonalMenor, diagonalMenor) == 0
                && Double.compare(rombo.lado, lado) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonalMayor, diagonalMenor, lado);
    }

    @Override
    public String toString() {
        return "Rombo{diagonalMayor=" + diagonalMayor
                + ", diagonalMenor=" + diagonalMenor
                + ", lado=" + lado + "}";
    }
}