package mattnp;

import java.util.Scanner;

/**
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
        String message = "";
        int n;
        final int dot = 46;
        final int hiBit = 128;
        while ((n = in.nextInt()) != dot) {
            if (Integer.bitCount(n) % 2 == 0) {
                if (n >= hiBit) {
                    n -= hiBit;
                }
                message += (char) n;
            }
        }
        System.out.print(message + ".");
    }
}
