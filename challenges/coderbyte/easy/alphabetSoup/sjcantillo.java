/**
 * Clase con la solucion de Reto AlphabetSoup
 * 
 * @author silvio.cantillo
 *
 */
public class Main {
	/**
     * Private constructor.
     */
    private Main() {
    }
	/**
	 * Metodo para Odernar carateres de un String
	 * 
	 * @param string cadena de numero
	 * @return
	 */
	public static String AlphabetSoup(final String string) {
		
		char cadenaCaractares[] = string.toCharArray();
		java.util.Arrays.sort(cadenaCaractares);
		StringBuilder stringBuilder = new StringBuilder();
		for (char caracter : cadenaCaractares) {
			stringBuilder.append(caracter);
		}
		return stringBuilder.toString();
	}
	/**
     * Main method.
     * @param args Argumentos de Usuario
     */
	public static void main(final String[] args) {
		java.util.Scanner.Scanner scanner = new java.util.Scanner.Scanner(System.in);
		System.out.print(AlphabetSoup(scanner.nextLine()));
	}

}
