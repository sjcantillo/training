package mattnp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for Selection Sort (120) from CodeAbbey.
 *
 * @author Mateo Noreña
 */
final class Mattnp {

    /**
     * Private empty constructor.
     */
    private Mattnp() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = in.nextInt();
        }
        selectionSort(vals);
    }

    /**
     * @param vals array to sort
     */
    private static void selectionSort(final int[] vals) {
        int maxInd = 0;
        int arrSize = vals.length;
        if (arrSize > 1) {
            for (int i = 1; i < arrSize; i++) {
                if (vals[i] > vals[maxInd]) {
                    maxInd = i;
                }
            }
            int aux = vals[vals.length - 1];
            vals[vals.length - 1] = vals[maxInd];
            vals[maxInd] = aux;

            int[] newArray = Arrays.copyOfRange(vals, 0, arrSize - 1);
            System.out.println(maxInd + " ");
            selectionSort(newArray);
        }
    }
}
