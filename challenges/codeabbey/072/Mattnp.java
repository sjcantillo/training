package mattnp;

import java.util.Scanner;

/**
 * Solution for Funny Words Generator (072) from CodeAbbey.
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
        final int n = in.nextInt();
        final String consonants = "bcdfghjklmnprstvwxz";
        final int lenCons = consonants.length();
        final String vowels = "aeiou";
        final int lenVows = vowels.length();
        final int a = 445;
        final int c = 700001;
        final int m = 2097152;
        int random = in.nextInt();
        String word;
        int lenWord;
        for (int i = 0; i < n; i++) {
            word = "";
            lenWord = in.nextInt();
            for (int j = 0; j < lenWord; j++) {
                random = (a * random + c) % m;
                if (j % 2 == 0) {
                    word += consonants.charAt(random % lenCons);
                } else {
                    word += vowels.charAt(random % lenVows);
                }
            }
            System.out.println(word + " ");
        }
    }
}
