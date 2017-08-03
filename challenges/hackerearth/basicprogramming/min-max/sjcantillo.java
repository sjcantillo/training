package core;

/**
 * Clase para resolver el reto de Max y Min.
 *
 * @author silvio.cantillo
 * @version 1.0
 */
public final class Main {
    /** Private constructor. */
    private Main() {
    }    
    /**
     * Metodo para calcular Max o Min.
     *
     * @param numbers
     *            string de numero con espacios
     * @param size
     *            limite de los numeros
     * @param isMax
     *            booelan para saber si es max o min
     * @return retorna el valor min o max
     */
    public static Long calculateMinMax(final String numbers, final Long size,
            final boolean isMax) {
        Long calculateNumber = new Long(0);
        Long sumNumbers = new Long(0);
        String[] arrayNumbers = numbers.split(" ");
        if (arrayNumbers.length >= size) {
            for (Integer i = 0; i < size; i++) {
                sumNumbers = new Long(0);
                for (Integer j = 0; j < size; j++) {
                    if (j != i) {
                        sumNumbers += Long.parseLong(arrayNumbers[j]);
                    }
                }
                calculateNumber = compareNumbers(calculateNumber, sumNumbers, isMax);
            }
        }
        return calculateNumber;
    }

    /**
     * Metodo para comparar los numeros.
     *
     * @param currentNumber
     *            numeroActual
     * @param possibleNumber
     *            posible numero que reemplazara
     * @param isMax
     *            booelan para saber si es max o min
     * @return retorna el numero
     */
    public static Long compareNumbers(final Long currentNumber,
            final Long possibleNumber, final boolean isMax) {
        Long newNumber;
        if (isMax) {
			if(possibleNumber > currentNumber){
				newNumber = possibleNumber;
			}else{
				newNumber = currentNumber;
			}            
        } else {
			if((possibleNumber < currentNumber) || (currentNumber == 0)){
				newNumber = possibleNumber;
			}else{
				newNumber = currentNumber;
			}
        }
        return newNumber;
    }

    /**
     * Main method.
     *
     * @param args
     *            Argumentos de Usuario
     */
    public static void main(final String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Long size = Long.parseLong(scanner.nextLine());
        String numbers = scanner.nextLine();
		String resultado=calculateMinMax(numbers, size, false)+" "+calculateMinMax(numbers, size, true);
        System.out.print(resultado);
    }
}
