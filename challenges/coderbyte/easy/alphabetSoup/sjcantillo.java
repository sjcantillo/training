/**
 * @author silvio.cantillo
 * @version 1.0
 */
package core;
/**
 * Clase para resolver el reto de AlphabetSoup.
 *
 * @author silvio.cantillo
 * @version 1.0
 */
public final class Main {
    /** Private constructor. */
    private Main() {
    }

    /**
     * Metodo para retornar la cadena.
     *
     * @param string
     *            cadena de numero
     * @return cadena ordenada
     */
    public static String alphabetSoup(final String string) {

        char[] cadenaCaractares = string.toCharArray();
        java.util.Arrays.sort(cadenaCaractares);
        StringBuilder stringBuilder = new StringBuilder();
        for (char caracter : cadenaCaractares) {
            stringBuilder.append(caracter);
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Main method.
     *
     * @param args
     *            Argumentos de Usuario
     */
    public static void main(final String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(alphabetSoup(scanner.nextLine()));
    }
}
