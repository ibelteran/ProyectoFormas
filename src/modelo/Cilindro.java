package modelo;

import java.util.Objects;

public class Cilindro extends Cuerpo {
    private Circulo base;
    private Rectangulo lateral;

    public Cilindro(Circulo base, Rectangulo lateral) {
        super("Cilindro");
        setBase(base);
        setLateral(lateral);
    }

    public Circulo getBase() {
        return base;
    }

    public void setBase(Circulo base) {
        if (base == null) {
            throw new IllegalArgumentException("El cilindro debe tener una base circular.");
        }

        this.base = base;
    }

    public Rectangulo getLateral() {
        return lateral;
    }

    public void setLateral(Rectangulo lateral) {
        if (lateral == null) {
            throw new IllegalArgumentException("El cilindro debe tener un rectángulo lateral.");
        }

        this.lateral = lateral;
    }

    public double getAltura() {
        return lateral.getAltura();
    }

    @Override
    public double calcularArea() {
        return (2 * base.calcularArea()) + lateral.calcularArea();
    }

    @Override
    public double calcularPerimetro() {
        return 2 * base.calcularPerimetro();
    }

    @Override
    public double calcularVolumen() {
        return base.calcularArea() * getAltura();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cilindro)) {
            return false;
        }

        Cilindro cilindro = (Cilindro) obj;
        return Objects.equals(base, cilindro.base)
                && Objects.equals(lateral, cilindro.lateral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, lateral);
    }

    @Override
    public String toString() {
        return "Cilindro{base=" + base + ", lateral=" + lateral + "}";
    }
}
