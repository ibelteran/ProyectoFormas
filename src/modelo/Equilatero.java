package modelo;

public class Equilatero extends Triangulo {

    public Equilatero(double lado) {
        super("Triángulo equilátero", lado, lado, lado);
    }

    public double getLado() {
        return getLadoA();
    }

    public void setLado(double lado) {
        setLados(lado, lado, lado);
    }

    @Override
    public String toString() {
        return "Triángulo equilátero{lado=" + getLado() + "}";
    }
}
