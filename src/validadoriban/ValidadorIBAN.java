/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validadoriban;

/**
 *
 * @author nicot
 */

import java.math.BigInteger;

public class ValidadorIBAN {

    public static boolean validar(String iban) {
        if (iban == null) return false;

        // Validacion longitud estandar (15-34)
        if (iban.length() < 15 || iban.length() > 34) return false;

        // Reordenar: 4 primeros al final
        String codigo = iban.toUpperCase();
        String reordenado = codigo.substring(4) + codigo.substring(0, 4);

        // Letras a numeros
        StringBuilder sb = new StringBuilder();
        for (char c : reordenado.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else if (Character.isLetter(c)) sb.append(c - 55);
            else return false;
        }

        // Modulo 97
        try {
            BigInteger n = new BigInteger(sb.toString());
            return n.mod(new BigInteger("97")).intValue() == 1;
        } catch (Exception e) { return false; }
    }
}
