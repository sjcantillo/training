package mattnp;

import java.util.Scanner;

/**
 * Solution for Code Guesser (036) from CodeAbbey.
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
        int n = in.nextInt();
        final int max = 10000;
        final int d = 4;
        String nS;
        String gS;
        int[][] guesses = new int[n][2];
        for (int i = 0; i < n; i++) {
            guesses[i][0] = in.nextInt();
            guesses[i][1] = in.nextInt();
        }
        for (int i = 0; i < max; i++) {
            nS = String.format("%04d", i);
            boolean discarded = false;
            int j = 0;
            while (j < n) {
                int eq = 0;
                for (int k = 0; k < d; k++) {
                    gS = String.format("%04d", guesses[j][0]);
                    if (nS.charAt(k) == gS.charAt(k)) {
                        eq++;
                    }
                }
                if (eq != guesses[j][1]) {
                    discarded = true;
                    break;
                }
                j++;
            }
            if (!discarded) {
                System.out.println(nS);
            }
        }
    }
}
