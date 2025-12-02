package app;

import modelo.CasoPrueba;
import modelo.CalculadoraTarifas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GestorEnvios {

    private static final String PREDEFINED_FILENAME = "casos_predefinidos.txt";

    private CalculadoraTarifas calculadora;

    public GestorEnvios() {
        this.calculadora = new CalculadoraTarifas();
    }

    public void procesarCaso(CasoPrueba caso) {
        double coste = calculadora.calcularTarifa(caso);

        System.out.printf("   > Entrada %s: ", caso.toString());

        if (coste > 0.0) {
            System.out.printf("Coste Final: **%.2f EUR**%n", coste);
        } else if (coste == -1.0) {
            System.out.println("ERROR - Parametros de entrada invalidos.");
        } else if (coste == -2.0) {
            System.out.println("ERROR - El paquete es demasiado pesado.");
        }
    }

    public void entradaManual(Scanner sc) {
        char continuar = 's';

        while (continuar == 's' || continuar == 'S') {
            System.out.println("\n--- INGRESO MANUAL ---");

            System.out.print("Ingrese Peso (kg): ");
            double peso = leerDouble(sc);

            System.out.print("Ingrese Distancia (km): ");
            int distancia = leerInt(sc);

            System.out.print("¿Es Urgente? (1=Si / 0=No): ");
            int urgenteInt = leerInt(sc);
            boolean urgente = (urgenteInt == 1);

            CasoPrueba caso = new CasoPrueba(peso, distancia, urgente);

            System.out.println("\n[MAIN] EJECUTANDO CASO DE PRUEBA MANUAL:");
            procesarCaso(caso);

            System.out.print("\n¿Desea introducir otro caso? (s/n): ");
            String linea = sc.nextLine();
            if (!linea.isEmpty()) {
                continuar = linea.charAt(0);
            }
        }
    }

    public void ejecutarDesdeArchivo() {
        int testCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(PREDEFINED_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] partes = line.split(",");
                if (partes.length != 3) {
                    System.out.println("[MAIN] Linea invalida: " + line);
                    continue;
                }

                double peso = Double.parseDouble(partes[0].trim());
                int distancia = Integer.parseInt(partes[1].trim());
                boolean urgente = Integer.parseInt(partes[2].trim()) == 1;

                CasoPrueba caso = new CasoPrueba(peso, distancia, urgente);

                testCount++;
                System.out.printf("%n[MAIN] EJECUTANDO CASO DE PRUEBA %d (Archivo):%n", testCount);
                procesarCaso(caso);
            }

            System.out.printf("%n--- %d PRUEBAS DESDE ARCHIVO COMPLETADAS ---%n", testCount);

        } catch (IOException | NumberFormatException e) {
            System.out.println("[MAIN] ERROR al leer el archivo de casos de prueba " + PREDEFINED_FILENAME);
            System.out.println("Detalle: " + e.getMessage());
        }
    }

    // Métodos auxiliares de lectura seguros
    private double leerDouble(Scanner sc) {
        while (true) {
            try {
                String linea = sc.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Introduzca un numero (double): ");
            }
        }
    }

    private int leerInt(Scanner sc) {
        while (true) {
            try {
                String linea = sc.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Introduzca un numero entero: ");
            }
        }
    }
}
