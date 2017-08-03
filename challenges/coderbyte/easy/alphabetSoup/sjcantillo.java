import java.util.Arrays;
import java.util.Scanner;
/**
 * Clase con la solucion de Reto AlphabetSoup
 * 
 * @author silvio.cantillo
 *
 */
public class Main {
	/**
	 * Metodo para Odernar carateres de un String
	 * 
	 * @param string
	 * @return
	 */
	public static String AlphabetSoup(String string) {
		
		char cadenaCaractares[] = string.toCharArray();
		Arrays.sort(cadenaCaractares);
		StringBuilder stringBuilder = new StringBuilder();
		for (char caracter : cadenaCaractares) {
			stringBuilder.append(caracter);
		}
		return stringBuilder.toString();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(AlphabetSoup(scanner.nextLine()));
	}

}
