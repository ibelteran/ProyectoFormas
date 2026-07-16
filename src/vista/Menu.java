package vista;

import controlador.FormaController;
import modelo.Cilindro;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Cubo;
import modelo.Cuerpo;
import modelo.Equilatero;
import modelo.Esfera;
import modelo.Figura;
import modelo.Rectangulo;
import modelo.Rombo;
import modelo.Tetraedro;
import modelo.Triangulo;

import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private FormaController controller;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.controller = new FormaController();
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n========== PROYECTO FORMAS ==========");
            System.out.println("1. Agregar figura nueva");
            System.out.println("2. Agregar cuerpo nuevo");
            System.out.println("3. Listar figuras");
            System.out.println("4. Listar cuerpos");
            System.out.println("5. Calcular area total");
            System.out.println("6. Calcular perimetro total");
            System.out.println("7. Calcular volumen total");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    agregarFigura();
                    break;
                case 2:
                    agregarCuerpo();
                    break;
                case 3:
                    controller.listarFiguras();
                    break;
                case 4:
                    controller.listarCuerpos();
                    break;
                case 5:
                    System.out.printf("Area total: %.2f%n", controller.calcularAreaTotal());
                    break;
                case 6:
                    System.out.printf("Perimetro total: %.2f%n", controller.calcularPerimetroTotal());
                    break;
                case 7:
                    System.out.printf("Volumen total: %.2f%n", controller.calcularVolumenTotal());
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    private void agregarFigura() {
        System.out.println("\n--- Figuras ---");
        System.out.println("1. Circulo");
        System.out.println("2. Rectangulo");
        System.out.println("3. Cuadrado");
        System.out.println("4. Rombo");
        System.out.println("5. Triangulo");
        System.out.print("Seleccione una figura: ");

        int opcion = leerEntero();

        try {
            Figura figura = null;

            switch (opcion) {
                case 1:
                    double radio = leerDouble("Radio: ");
                    figura = new Circulo(radio);
                    break;

                case 2:
                    double base = leerDouble("Base: ");
                    double altura = leerDouble("Altura: ");
                    figura = new Rectangulo(base, altura);
                    break;

                case 3:
                    double lado = leerDouble("Lado: ");
                    figura = new Cuadrado(lado);
                    break;

                case 4:
                    double diagonalMayor = leerDouble("Diagonal mayor: ");
                    double diagonalMenor = leerDouble("Diagonal menor: ");
                    double ladoRombo = leerDouble("Lado: ");
                    figura = new Rombo(diagonalMayor, diagonalMenor, ladoRombo);
                    break;

                case 5:
                    double ladoA = leerDouble("Lado A: ");
                    double ladoB = leerDouble("Lado B: ");
                    double ladoC = leerDouble("Lado C: ");
                    figura = Triangulo.crearTriangulo(ladoA, ladoB, ladoC);
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    return;
            }

            controller.agregarFigura(figura);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void agregarCuerpo() {
        System.out.println("\n--- Cuerpos ---");
        System.out.println("1. Cubo");
        System.out.println("2. Cilindro");
        System.out.println("3. Tetraedro");
        System.out.println("4. Esfera");
        System.out.print("Seleccione un cuerpo: ");

        int opcion = leerEntero();

        try {
            Cuerpo cuerpo = null;

            switch (opcion) {
                case 1:
                    double ladoCubo = leerDouble("Lado del cubo: ");
                    cuerpo = new Cubo(new Cuadrado(ladoCubo));
                    break;

                case 2:
                    double radio = leerDouble("Radio del cilindro: ");
                    double altura = leerDouble("Altura del cilindro: ");

                    Circulo base = new Circulo(radio);
                    Rectangulo lateral = new Rectangulo(base.calcularPerimetro(), altura);

                    cuerpo = new Cilindro(base, lateral);
                    break;

                case 3:
                    double lado = leerDouble("Lado del tetraedro: ");
                    cuerpo = new Tetraedro(new Equilatero(lado));
                    break;

                case 4:
                    double radioEsfera = leerDouble("Radio de la esfera: ");
                    cuerpo = new Esfera(radioEsfera);
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    return;
            }

            controller.agregarCuerpo(cuerpo);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int leerEntero() {
        while (true) {
            try {
                String texto = sc.nextLine().trim();
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String texto = sc.nextLine().trim().replace(',', '.');
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}