package mattnp;

import java.util.Scanner;

/**
 * Solution for Card Shuffling (045) from CodeAbbey.
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
        final int nCards = 52;
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T",
            "J", "Q", "K"};
        String[] suits = {"C", "D", "H", "S"};
        String[] deck = new String[ranks.length * suits.length];
        String aux;
        int d = 0;
        int r;
        int i;
        for (i = 0; i < suits.length; i++) {
            for (String rank : ranks) {
                deck[d] = suits[i] + rank;
                d++;
            }
        }
        for (i = 0; i < deck.length; i++) {
            r = in.nextInt() % nCards;
            aux = deck[i];
            deck[i] = deck[r];
            deck[r] = aux;
        }
        for (i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
        }
    }
}
