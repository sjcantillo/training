package solution;

import java.util.Scanner;

public class Solution {

    private Solution() {
    }

    public static void main(final String[] args) {
        final int p = 46;
        final int h = 128;
        Scanner in = new Scanner(System.in);
        String message = "";
        int n;
        while ((n = in.nextInt()) != p) {
            if (Integer.bitCount(n) % 2 == 0) {
              if (n >= h) {
                n -= h;
              }
            message += (char) n;
            }
        }
        System.out.print(message + ".");
    }
}
