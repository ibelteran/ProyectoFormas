package modelo;

import java.util.Objects;

public abstract class Cuerpo implements Forma {
    private String nombre;

    public Cuerpo(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularVolumen();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println(toString());
        System.out.printf("Área superficial: %.2f%n", calcularArea());
        System.out.printf("Perímetro: %.2f%n", calcularPerimetro());
        System.out.printf("Volumen: %.2f%n", calcularVolumen());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cuerpo)) {
            return false;
        }

        Cuerpo cuerpo = (Cuerpo) obj;
        return Objects.equals(nombre, cuerpo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Cuerpo{nombre='" + nombre + "'}";
    }
}
