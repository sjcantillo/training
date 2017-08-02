import java.util.Arrays;
import java.util.Scanner
/**
* clase Main
*/  
public class Main {
	/**
	 * 
	 */
	public Main() {
		super();		
	}
	/**
	* Metodo para ordernar caracteres
	* @param args
	*/
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(alphabetSoup(scanner.nextLine()));
	}
	/**
	* Metodo para ordernar caracteres
	* @param string
	* @return
	*/
	public static String alphabetSoup(final String string) {
		char[] cadenaCaractares = string.toCharArray();
		Arrays.sort(cadenaCaractares);
		StringBuilder stringBuilder = new StringBuilder();
		for (char caracter : cadenaCaractares) {
			stringBuilder.append(caracter);
		}
		return stringBuilder.toString();
	}
}
