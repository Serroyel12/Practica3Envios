package app;

import java.util.Scanner;

public class MainEnvios {

    public static void main(String[] args) {

        GestorEnvios gestor = new GestorEnvios();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n--- INICIO DEL PROGRAMA DE PRUEBAS ---");
            System.out.println("Seleccione modo de ejecucion:");
            System.out.println("1. Ejecutar Casos Predefinidos (Desde casos_predefinidos.txt)");
            System.out.println("2. Introducir datos manualmente (Consola)");
            System.out.println("3. Salir del programa");
            System.out.print("Opcion: ");

            String linea = sc.nextLine();
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    gestor.ejecutarDesdeArchivo();
                    break;
                case 2:
                    gestor.entradaManual(sc);
                    break;
                case 3:
                    System.out.println("\nSaliendo del programa. ¡Exito en la ejecucion!");
                    break;
                default:
                    System.out.println("\nOpcion no reconocida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}
