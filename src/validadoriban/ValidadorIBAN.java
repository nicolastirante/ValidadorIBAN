/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validadoriban;

import java.math.BigInteger;

/**
 * Clase que contiene la logica matematica.
 * Implementa ISO 13616.
 * @author nicot
 */

public class ValidadorIBAN {

    /**
     * Valida un codigo IBAN.
     * @param iban El codigo a verificar.
     * @return true si es valido.
     */
    public static boolean validar(String iban) {
        if (iban == null) return false;

        String ibanLimpio = iban.replace(" ", "").trim().toUpperCase();

        if (ibanLimpio.length() < 15 || ibanLimpio.length() > 34) return false;

        String reordenado = ibanLimpio.substring(4) + ibanLimpio.substring(0, 4);

        StringBuilder sb = new StringBuilder();
        for (char c : reordenado.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else if (Character.isLetter(c)) sb.append(c - 55);
            else return false;
        }

        try {
            BigInteger n = new BigInteger(sb.toString());
            return n.mod(new BigInteger("97")).intValue() == 1;
        } catch (Exception e) { return false; }
    }
}
