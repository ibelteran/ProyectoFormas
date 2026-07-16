package controlador;

import dao.FormaDAO;
import dao.FormaDAOImpl;
import modelo.Coleccion;
import modelo.Cuerpo;
import modelo.Figura;

public class FormaController {
    private Coleccion coleccion;
    private FormaDAO formaDAO;

    public FormaController() {
        this.coleccion = new Coleccion();
        this.formaDAO = new FormaDAOImpl();
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    public FormaDAO getFormaDAO() {
        return formaDAO;
    }

    public void setFormaDAO(FormaDAO formaDAO) {
        this.formaDAO = formaDAO;
    }

    public void agregarFigura(Figura figura) {
        coleccion.agregarFigura(figura);
        formaDAO.guardarFigura(figura);
        System.out.println("Figura agregada correctamente.");
    }

    public void agregarCuerpo(Cuerpo cuerpo) {
        coleccion.agregarCuerpo(cuerpo);
        formaDAO.guardarCuerpo(cuerpo);
        System.out.println("Cuerpo agregado correctamente.");
    }

    public void listarFiguras() {
        coleccion.listarFiguras();
    }

    public void listarCuerpos() {
        coleccion.listarCuerpos();
    }

    public double calcularAreaTotal() {
        return coleccion.calcularAreaTotal();
    }

    public double calcularPerimetroTotal() {
        return coleccion.calcularPerimetroTotal();
    }

    public double calcularVolumenTotal() {
        return coleccion.calcularVolumenTotal();
    }
}