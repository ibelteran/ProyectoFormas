package modelo;

import java.util.Objects;

public abstract class Figura implements Forma {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void imprimirInformacion() {
        System.out.println(toString());
        System.out.printf("Área: %.2f%n", calcularArea());
        System.out.printf("Perímetro: %.2f%n", calcularPerimetro());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Figura)) {
            return false;
        }

        Figura figura = (Figura) obj;
        return Objects.equals(nombre, figura.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Figura{nombre='" + nombre + "'}";
    }
}