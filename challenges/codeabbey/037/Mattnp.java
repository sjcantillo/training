package mattnp;

import java.util.Scanner;

/**
 * Solution for Mortgage Calculator (037) from CodeAbbey.
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
        final int r = 1200;
        double a = in.nextDouble();
        double i = in.nextDouble() / r;
        double n = in.nextDouble();
        double d = (Math.pow((1 + i), n) - 1) / (i * Math.pow((1 + i), n));
        int p = (int) Math.ceil(a / d);
        System.out.println(p);
    }
}
