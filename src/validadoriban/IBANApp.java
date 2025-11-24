/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadoriban;

/**
 *
 * @author nicot
 */

import java.util.Scanner;

public class IBANApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;

        System.out.println("=== SISTEMA VALIDADOR IBAN ===");

        while (seguir) {
            System.out.print("Ingrese IBAN: ");
            String entrada = scanner.nextLine();

            // Llamamos a tu clase ValidadorIBAN
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
