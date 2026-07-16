package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coleccion {
    private List<Figura> figuras;
    private List<Cuerpo> cuerpos;

    public Coleccion() {
        this.figuras = new ArrayList<>();
        this.cuerpos = new ArrayList<>();
    }

    public List<Figura> getFiguras() {
        return figuras;
    }

    public void setFiguras(List<Figura> figuras) {
        this.figuras = figuras;
    }

    public List<Cuerpo> getCuerpos() {
        return cuerpos;
    }

    public void setCuerpos(List<Cuerpo> cuerpos) {
        this.cuerpos = cuerpos;
    }

    public void agregarFigura(Figura figura) {
        if (figura != null) {
            figuras.add(figura);
        }
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        if (cuerpo != null) {
            cuerpos.add(cuerpo);
        }
    }

    public void listarFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras registradas.");
            return;
        }

        for (int i = 0; i < figuras.size(); i++) {
            System.out.println("\nFigura " + (i + 1));
            figuras.get(i).imprimirInformacion();
        }
    }

    public void listarCuerpos() {
        if (cuerpos.isEmpty()) {
            System.out.println("No hay cuerpos registrados.");
            return;
        }

        for (int i = 0; i < cuerpos.size(); i++) {
            System.out.println("\nCuerpo " + (i + 1));
            cuerpos.get(i).imprimirInformacion();
        }
    }

    public double calcularAreaTotal() {
        double total = 0;

        for (Figura figura : figuras) {
            total += figura.calcularArea();
        }

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularArea();
        }

        return total;
    }

    public double calcularPerimetroTotal() {
        double total = 0;

        for (Figura figura : figuras) {
            total += figura.calcularPerimetro();
        }

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularPerimetro();
        }

        return total;
    }

    public double calcularVolumenTotal() {
        double total = 0;

        for (Cuerpo cuerpo : cuerpos) {
            total += cuerpo.calcularVolumen();
        }

        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Coleccion)) {
            return false;
        }

        Coleccion coleccion = (Coleccion) obj;
        return Objects.equals(figuras, coleccion.figuras)
                && Objects.equals(cuerpos, coleccion.cuerpos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(figuras, cuerpos);
    }

    @Override
    public String toString() {
        return "Coleccion{figuras=" + figuras + ", cuerpos=" + cuerpos + "}";
    }
}
