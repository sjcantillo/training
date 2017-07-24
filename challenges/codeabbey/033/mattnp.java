import java.util.*;

class Solution
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        String message = "";
        int n;
        while((n = in.nextInt()) != 46) {
            if (Integer.bitCount(n)%2 == 0) {
                if(n >= 128) {
                    n -= 128;
                }
                message += (char)n;
            }
        }
        System.out.print(message+".");
    }
}