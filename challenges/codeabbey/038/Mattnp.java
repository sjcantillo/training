/**
 *
 * @author Mateo Noreña
 */
package mattnp;

import java.util.Scanner;

/**
 * @author Mateo Noreña
 */
public class Mattnp {

    /**
     * @param
     */
    private Mattnp() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            final int f = 4;
            double d = Math.pow(b, 2) - (f * a * c);
            double x1;
            double x2;
            String x1S;
            String x2S;
            double b1 = -b / (2 * a);
            double d1 = Math.sqrt(Math.abs(d)) / (2 * a);
            if (d >= 0) {
                x1 = b1 + d1;
                x2 = b1 - d1;
                if (x2 > x1) {
                    double t = x1;
                    x1 = x2;
                    x2 = t;
                }
                x1S = Integer.toString((int) x1);
                x2S = Integer.toString((int) x2);
            } else {
                String b1S = Integer.toString((int) b1);
                x1S = b1S + "+" + Integer.toString((int) d1) + "i";
                x2S = b1S + "-" + Integer.toString((int) d1) + "i";
            }
            System.out.print(x1S + " " + x2S);
            if (i != n - 1) {
                System.out.print("; ");
            }
        }
    }
}
