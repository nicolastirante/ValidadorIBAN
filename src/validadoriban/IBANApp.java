/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadoriban;

import java.util.Scanner;

/**
 * Clase principal de la aplicacion.
 * @author nicot
 */

public class IBANApp {

    /**
     * Metodo main de entrada.
     * @param args Argumentos de consola.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;

        System.out.println("=== SISTEMA VALIDADOR IBAN ===");

        while (seguir) {
            System.out.print("Ingrese IBAN: ");
            String entrada = scanner.nextLine();

            if (ValidadorIBAN.validar(entrada)) {
                System.out.println(">> VALIDO");
            } else {
                System.out.println(">> INVALIDO");
            }

            System.out.print("¿Otro? (S/N): ");
            if (!scanner.nextLine().toUpperCase().startsWith("S")) {
                seguir = false;
            }
        }
    }
}
