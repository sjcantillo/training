package mattnp;

import java.util.Scanner;

/**
 * Solution for Share Price Volatility (039) from CodeAbbey.
 *
 * @author Mateo Noreña
 */
public final class Mattnp {

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
        final int nV = 14;
        double mean;
        double sumDistances;
        double meanDistances;
        double standardDeviation;
        final double criteria = 4 * 0.01;
        double[] distances = new double[nV];
        int sum;
        int[] values = new int[nV];
        int n = in.nextInt();
        int j;
        int k;
        for (int i = 0; i < n; i++) {
            String name = in.next();
            sum = 0;
            for (j = 0; j < nV; j++) {
                values[j] = in.nextInt();
                sum += values[j];
            }
            mean = sum / (double) nV;
            sumDistances = 0;
            for (k = 0; k < nV; k++) {
                distances[k] = Math.pow(mean - values[k], 2);
                sumDistances += distances[k];
            }
            meanDistances = sumDistances / nV;
            standardDeviation = Math.sqrt(meanDistances);
            if (criteria * mean <= standardDeviation) {
                System.out.print(name + " ");
            }
        }
    }
}
