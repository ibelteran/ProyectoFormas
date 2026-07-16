package modelo;

import java.util.Objects;

public abstract class Triangulo extends Figura {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(String nombre, double ladoA, double ladoB, double ladoC) {
        super(nombre);
        validarLados(ladoA, ladoB, ladoC);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public static Triangulo crearTriangulo(double ladoA, double ladoB, double ladoC) {
        validarLados(ladoA, ladoB, ladoC);

        if (Double.compare(ladoA, ladoB) == 0 && Double.compare(ladoB, ladoC) == 0) {
            return new Equilatero(ladoA);
        }

        if (Double.compare(ladoA, ladoB) == 0
                || Double.compare(ladoA, ladoC) == 0
                || Double.compare(ladoB, ladoC) == 0) {
            return new Isosceles(ladoA, ladoB, ladoC);
        }

        return new Escaleno(ladoA, ladoB, ladoC);
    }

    private static void validarLados(double ladoA, double ladoB, double ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new IllegalArgumentException("Los lados del triángulo deben ser mayores que cero.");
        }

        if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
            throw new IllegalArgumentException("Las medidas ingresadas no forman un triángulo válido.");
        }
    }

    protected void setLados(double ladoA, double ladoB, double ladoC) {
        validarLados(ladoA, ladoB, ladoC);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        setLados(ladoA, ladoB, ladoC);
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        setLados(ladoA, ladoB, ladoC);
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        setLados(ladoA, ladoB, ladoC);
    }

    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    @Override
    public double calcularArea() {
        double semiperimetro = calcularPerimetro() / 2;

        return Math.sqrt(
                semiperimetro
                        * (semiperimetro - ladoA)
                        * (semiperimetro - ladoB)
                        * (semiperimetro - ladoC)
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Triangulo)) {
            return false;
        }

        Triangulo triangulo = (Triangulo) obj;
        return Double.compare(triangulo.ladoA, ladoA) == 0
                && Double.compare(triangulo.ladoB, ladoB) == 0
                && Double.compare(triangulo.ladoC, ladoC) == 0
                && Objects.equals(getNombre(), triangulo.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), ladoA, ladoB, ladoC);
    }

    @Override
    public String toString() {
        return getNombre() + "{ladoA=" + ladoA
                + ", ladoB=" + ladoB
                + ", ladoC=" + ladoC + "}";
    }
}
