
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * PIR - Pyramids - Spoj.
 * @author Erika
 *
 */
final class Erisohv {

    /**
     * Pyramid edges.
     */
    private static final int MAX_EDGES = 6;

    /**
     * 0.
     */
    private static final int ZERO = 0;

    /**
     * 1.
     */
    private static final int ONE = 1;

    /**
     * 2.
     */
    private static final int TWO = 2;

    /**
     * 3.
     */
    private static final int THREE = 3;

    /**
     * 4.
     */
    private static final int FOUR = 4;

    /**
     * 5.
     */
    private static final int FIVE = 5;

    /**
     * 12.
     */
    private static final double TWELVE = 12.0;

    /**
     * Empty constructor.
     */
    private Erisohv() {

    }

    /**
     * Compute the pyramid volume. <br>
     * [0] = AB, [1] = AC, [2] = AD, [3] = BC, [4] = BD, [5] = CD
     * font: https://people.eecs.berkeley.edu/~wkahan/VtetLang.pdf
     * @param edges edges
     * @return volume
     */
    private static BigDecimal getPyramidVolume(final int[] edges) {
        BigDecimal u2 = new BigDecimal(edges[FIVE] * edges[FIVE]); // u = CD
        BigDecimal v2 = new BigDecimal(edges[TWO] * edges[TWO]); // v = AD
        BigDecimal w2 = new BigDecimal(edges[FOUR] * edges[FOUR]); // w = BD
        BigDecimal uu2 =
                new BigDecimal(edges[ZERO] * edges[ZERO]); //U = uu = AB
        BigDecimal vv2 =
                new BigDecimal(edges[THREE] * edges[THREE]); //V = vv = BC
        BigDecimal ww2 = new BigDecimal(edges[ONE] * edges[ONE]); //W = ww = AC

        BigDecimal u2v2w2 = new BigDecimal(FOUR) // 4 * u^2 * v^2 * w^2
                .multiply(u2).multiply(v2).multiply(w2);

        BigDecimal v2aw2mU2 = v2.add(w2).subtract(uu2); // v^2 + w^2 - U^2 (1)
        BigDecimal u2av2mww2 = u2.add(v2).subtract(ww2); // u^2 + v^2 - W^2 (2)
        BigDecimal w2au2mvv2 = w2.add(u2).subtract(vv2); // w^2 + u^2 - V^2 (3)

        BigDecimal factu2 = u2.multiply(v2aw2mU2
                .multiply(v2aw2mU2)); // u^2 * (1)^2
        BigDecimal factv2 = v2.multiply(w2au2mvv2
                .multiply(w2au2mvv2)); // v^2 * (3)^2
        BigDecimal factw2 = w2.multiply(u2av2mww2
                .multiply(u2av2mww2)); // w^2 * (2)^2

        BigDecimal sum = u2v2w2.subtract(factu2)
                .subtract(factv2).subtract(factw2)
                .add(v2aw2mU2.multiply(w2au2mvv2).multiply(u2av2mww2));

        BigDecimal volume = new BigDecimal(
                Math.sqrt(sum.doubleValue()) / TWELVE);

        return volume.setScale(FOUR, RoundingMode.HALF_UP);
    }

    /**
     * Main.
     * @param args args
     * @throws IOException io exception
     */
    public static void main(final String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int casesNo = Integer.valueOf(reader.readLine());
        int[] edges = new int[MAX_EDGES];

        for (int i = 0; i < casesNo; i++) {
            String line = reader.readLine();
            String[] sEdges = line.split(" ");

            for (int j = 0; j < MAX_EDGES; j++) { // AB, AC, AD, BC, BD, CD
                edges[j] = Integer.valueOf(sEdges[j]);
            }

            System.out.println(getPyramidVolume(edges));
        }
    }
}
