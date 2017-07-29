package mattnp;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Solution for Life is Simple (056) from CodeAbbey.
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
        final int m = 17;
        final int n = 19;
        final int mIn = 5;
        final int nIn = 7;
        final int vBorn = 3;
        final int minDie = 2;
        final int maxDie = 3;
        final int e = 5;
        final int turns = 5;
        char[][] grid = new char[m][n];
        ArrayList<int[]> born = new ArrayList();
        ArrayList<int[]> die = new ArrayList();
        String line;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '-';
            }
        }
        for (int i = 0; i < mIn; i++) {
            line = in.next();
            for (int j = 0; j < nIn; j++) {
                grid[i + e][j + e] = line.charAt(j);
            }
        }
        for (int t = 0; t < turns; t++) {
            born.clear();
            die.clear();
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    char c = grid[i][j];
                    int neighs = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            char neigh = grid[k][l];
                            if (neigh == 'X' && !(i == k && j == l)) {
                                neighs++;
                            }
                        }
                    }
                    int[] coords = {i, j};
                    boolean condToDie = neighs < minDie || neighs > maxDie;
                    boolean condToBorn = neighs == vBorn;
                    if (c == 'X' && condToDie) {
                        die.add(coords);
                    }
                    if (c == '-' && condToBorn) {
                        born.add(coords);
                    }
                }
            }
            for(int[] eD : die) {
                grid[eD[0]][eD[1]] = '-';
            }
            for(int[] eB : born) {
                grid[eB[0]][eB[1]] = 'X';
            }
            int organisms = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'X') {
                        organisms++;
                    }
                }
            }
            System.out.print(organisms + " ");
        }
    }
}
