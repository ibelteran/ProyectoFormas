package modelo;

import java.util.Objects;

public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("La base debe ser mayor que cero.");
        }

        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero.");
        }

        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Rectangulo)) {
            return false;
        }

        Rectangulo rectangulo = (Rectangulo) obj;
        return Double.compare(rectangulo.base, base) == 0
                && Double.compare(rectangulo.altura, altura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, altura);
    }

    @Override
    public String toString() {
        return "Rectángulo{base=" + base + ", altura=" + altura + "}";
    }
}