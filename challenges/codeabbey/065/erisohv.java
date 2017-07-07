import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erika
 *
 */
public final class erisohv {

    /**
     * Infinity value.
     */
    private static final int INFINITY = 10000000;

    /**
     * Empty constructor.
     */
    private erisohv() {
    }

    /**
     * @param matrix
     *            Matrix
     * @return Minimum routes costs
     */
    private static int[][] warshall(final int[][] matrix) {
        int size = matrix.length;

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int weight = matrix[i][k] + matrix[k][j];
                    if (matrix[i][j] > weight) {
                        matrix[i][j] = weight;
                    }
                }
            }
        }

        return matrix;
    }

    /**
     * @param size
     *            Matrix size
     * @return matrix fill with INFINITY value
     */
    private static int[][] initMatrix(final int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = INFINITY;
            }
        }
        return matrix;
    }

    /**
     * @param args
     *            Arguments
     * @throws NumberFormatException
     *             number format exception
     * @throws IOException
     *             IO exception
     */
    public static void main(final String[] args) throws NumberFormatException,
            IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        int qty = Integer.parseInt(reader.readLine());

        String[] routes = new String[qty];
        List<String> states = new ArrayList<String>();

        // reading the routes and the candy states
        for (int i = 0; i < qty; i++) {
            routes[i] = reader.readLine();
            if (states.indexOf(routes[i].split(" - ")[0]) == -1) {
                states.add(routes[i].split(" - ")[0]);
            }
        }

        int[][] matrix = initMatrix(states.size());

        // saving the routes
        for (int i = 0; i < qty; i++) {
            int from = states.indexOf(routes[i].split(" - ")[0]);
            int to = states.indexOf(routes[i].split(" - ")[1]);
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        // reading the routes to check
        int checkQty = Integer.parseInt(reader.readLine());

        // Minimum routes
        int[][] warshallMatrix = warshall(matrix);

        for (int i = 0; i < checkQty; i++) {
            String line = reader.readLine();
            int stateFrom = states.indexOf(line.split(" - ")[0]);
            int stateTo = states.indexOf(line.split(" - ")[1]);

            System.out.print(warshallMatrix[stateFrom][stateTo] + " ");
        }

    }

}
