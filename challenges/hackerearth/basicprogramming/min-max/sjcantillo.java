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
        Long calculateNum = new Long(0);
        Long sumNum = new Long(0);
        String[] arrayNumbers = numbers.split(" ");
        if (arrayNumbers.length >= size) {
            for (Integer i = 0; i < size; i++) {
                sumNum = new Long(0);
                for (Integer j = 0; j < size; j++) {
                    if (j != i) {
                        sumNum += Long.parseLong(arrayNumbers[j]);
                    }
                }
                calculateNum = compareNumbers(calculateNum, sumNum, isMax);
            }
        }
        return calculateNum;
    }

    /**
     * Metodo para comparar los numeros.
     *
     * @param currentNum
     *            numeroActual
     * @param possibleNum
     *            posible numero que reemplazara
     * @param isMax
     *            booelan para saber si es max o min
     * @return retorna el numero
     */
    public static Long compareNumbers(final Long currentNum,
            final Long possibleNum, final boolean isMax) {
        Long newNumber;
        if (isMax) {
            if (possibleNum > currentNum) {
                         newNumber = possibleNum;
                    } else {
                         newNumber = currentNum;
                    }
        } else {
            if ((possibleNum < currentNum) || (currentNum == 0)) {
                         newNumber = possibleNum;
                    } else {
                         newNumber = currentNum;
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
        Long numeroMinimo = calculateMinMax(numbers, size, false);
        Long numeroMaximo = calculateMinMax(numbers, size, true);
        System.out.print(numeroMinimo + " " + numeroMaximo);
    }
}
