package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner para leer entradas del usuario
        Scanner scanner = new Scanner(System.in);
        // Instancia del convertidor de moneda
        CurrencyConverter converter = new CurrencyConverter();
        int opcion = 0;

        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        do {
            // Mostrar el menú principal al usuario
            Menu.displayMenu();
            try {
                // Leer la opción ingresada por el usuario
                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 6) {
                    System.out.println("Ingrese el monto que desea convertir:");
                    // Leer el monto que desea convertir el usuario
                    double monto = scanner.nextDouble();
                    // Realizar la conversión de moneda
                    double resultado = converter.convertir(opcion, monto);
                    // Mostrar el resultado de la conversión
                    System.out.println("El valor " + monto + " corresponde al valor final de ==>>> " + resultado);
                } else if (opcion == 7) {
                    System.out.println("Saliendo de la aplicación. ¡Adiós!");
                } else {
                    System.out.println("Por favor ingrese una opción valida, solo se aceptan valores entre 1 y 7, según la opción que ud desee ejecutar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese una opción valida, solo se aceptan valores entre 1 y 7, según la opción que ud desee ejecutar.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        } while (opcion != 7);

        scanner.close();
    }
}
