package mattnp;

import java.util.Scanner;

/**
 * Solution for King and Queen (053) from CodeAbbey.
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
        String k;
        String q;
        boolean eqFiles;
        boolean eqRanks;
        boolean diags;
        int distFiles;
        int distRanks;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            k = in.next();
            q = in.next();
            eqFiles = k.charAt(0) == q.charAt(0);
            eqRanks = k.charAt(1) == q.charAt(1);
            distFiles = Math.abs(k.charAt(0) - q.charAt(0));
            distRanks = Math.abs(k.charAt(1) - q.charAt(1));
            diags = distFiles == distRanks;
            if (eqFiles || eqRanks || diags) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
