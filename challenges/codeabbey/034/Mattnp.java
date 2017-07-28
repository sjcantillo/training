package mattnp;

import java.util.Scanner;

/**
 * Solution for Binary Search (034) for CodeAbbey.
 *
 * @author Mateo Noreña
 */
public final class Mattnp {

    /**
     * @param empty
     */
    private Mattnp() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final int nVals = 4;
        final double lambda = -1e-7;
        final double oh = 100;
        int n = in.nextInt();
        double fs;
        double fi;
        for (int i = 0; i < n; i++) {
            double[] vals = new double[nVals];
            for (int j = 0; j < nVals; j++) {
                vals[j] = in.nextDouble();
            }
            fs = oh;
            fi = 0;
            double x;
            double fx;
            do {
                x = (fs + fi) / 2;
                fx = f(x, vals);
                if (fx <= lambda) {
                    fi = (fs + fi) / 2;
                } else {
                    fs = (fs + fi) / 2;
                }
            } while (fx >= lambda || fx <= -lambda);
            System.out.println(x + " ");
        }
    }

    /**
     * @param x value to evaluate
     * @param vals coefficients to evaluate
     * @return evaluation of function
     */
    public static double f(final double x, final double[] vals) {
        final int t = 3;
        final int f = 50;
        return vals[0] * x + vals[1] * Math.sqrt(Math.pow(x, t)) - vals[2]
                * Math.exp(-x / f) - vals[t];
    }
}
