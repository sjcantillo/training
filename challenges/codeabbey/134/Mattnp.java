package mattnp;

import java.util.Scanner;

/**
 * Solution for Selection Sort (120) from CodeAbbey.
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
     * @throws MalformedURLException
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final int wScreen = in.nextInt();
        final int hScreen = in.nextInt();
        final int lenWord = in.nextInt();
        final int steps = 100;
        int posX = 0;
        int posY = 0;
        int dirW = 1;
        int dirH = 1;
        for (int i = 0; i <= steps; i++) {
            System.out.println(posX + " " + posY + " ");
            posX += dirW;
            posY += dirH;
            if (posX + lenWord - 1 >= wScreen || posX < 0) {
                dirW *= -1;
                posX += 2 * dirW;
            }
            if (posY >= hScreen || posY < 0) {
                dirH *= -1;
                posY += 2 * dirH;
            }
        }
    }
}
