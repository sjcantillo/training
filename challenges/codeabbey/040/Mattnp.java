package mattnp;

import java.util.Scanner;

/**
 * Solution for Paths in the Grid (040) from CodeAbbey.
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
        int m = in.nextInt();
        int n = in.nextInt();
        String v;
        String[][] grid = new String[m][n];
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.next();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v = grid[i][j];
                if (i == 0 && j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = 0;
                }
                if (!v.equals("X")) {
                    if (i > 0) {
                        paths[i][j] += paths[i - 1][j];
                    }
                    if (j > 0) {
                        paths[i][j] += paths[i][j - 1];
                    }
                }
            }
        }
        System.out.println(paths[m - 1][n - 1]);
    }
}