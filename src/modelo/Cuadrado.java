package modelo;

import java.util.Objects;

public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
        setNombre("Cuadrado");
    }

    public double getLado() {
        return getBase();
    }

    public void setLado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser mayor que cero.");
        }

        super.setBase(lado);
        super.setAltura(lado);
    }

    @Override
    public void setBase(double base) {
        setLado(base);
    }

    @Override
    public void setAltura(double altura) {
        setLado(altura);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cuadrado)) {
            return false;
        }

        Cuadrado cuadrado = (Cuadrado) obj;
        return Double.compare(cuadrado.getLado(), getLado()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLado());
    }

    @Override
    public String toString() {
        return "Cuadrado{lado=" + getLado() + "}";
    }
}
