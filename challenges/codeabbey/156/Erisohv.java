
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Luhn Algorithm - Problem #156.
 *
 * @author Erika
 *
 */
public final class Erisohv {
    /**
     * TEN.
     */
    private static final int TEN = 10;

    /**
     * NINE.
     */
    private static final int NINE = 9;

    /**
     * TWO.
     */
    private static final int TWO = 2;

    /**
     * Empty constructor.
     */
    private Erisohv() {

    }

    /**
     * Return the luhn value by the position.
     *
     * @param value
     *            value
     * @param position
     *            position
     * @return luhn value
     */
    private static int getValueByPosition(final int value, final int position) {
        int copy = value;
        if (position % TWO == 0) {
            copy = copy * TWO;
            if (copy >= TEN) {
                copy = copy - NINE;
            }
        }
        return copy;
    }

    /**
     * Swap digits in the card number.
     *
     * @param cardNumber
     *            card number
     * @param pos
     *            position
     * @param pre
     *            if true -> pos - 1 else pos + 1
     * @return swapped card number
     */
    private static String swapDigits(final String cardNumber, final int pos,
            final boolean pre) {
        int posTo = pos;
        if (pre) {
            posTo = pos - 1;
        } else {
            posTo = pos + 1;
        }
        if (posTo >= 0 && posTo < cardNumber.length()) {
            char[] cardArray = cardNumber.toCharArray();
            char tmp = cardArray[pos];
            cardArray[pos] = cardArray[posTo];
            cardArray[posTo] = tmp;
            return new String(cardArray);
        }
        return cardNumber;
    }

    /**
     * Luhn sum.
     *
     * @param cardNumber
     *            card number
     * @param missingPosition
     *            position with ?
     * @return sum
     */
    public static int sumLuhn(final String cardNumber,
            final int missingPosition) {
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            if (i != missingPosition) {
                int value = getValueByPosition(Integer.valueOf(Character
                        .toString(cardNumber.charAt(i))), i);
                sum = sum + value;
            }
        }
        return sum;
    }

    /**
     * Fix the swap error.
     *
     * @param cardNumber
     *            card number
     * @param sum
     *            luhn sum
     * @param a
     *            What is missing to reach a multiple of TEN
     * @param b
     *            What is missing to reach a multiple of TEN
     * @return correct card number
     */
    private static String fixSwapError(final String cardNumber, final int sum,
            final int a, final int b) {
        String correctCardNumber = null;
        for (int i = 0; i < cardNumber.length(); i++) {
            if (i > 0) {
                correctCardNumber = swapDigits(cardNumber, i, true);
            } else if (i < cardNumber.length() - 1) {
                correctCardNumber = swapDigits(cardNumber, i, false);
            }
            if (isCorrectCardNumber(correctCardNumber)) {
                return correctCardNumber;
            }
        }
        return null;
    }

    /**
     * Check if the card number is correct.
     *
     * @param cardNumber
     *            card number
     * @return true if is correct
     */
    private static boolean isCorrectCardNumber(final String cardNumber) {
        return sumLuhn(cardNumber, -1) % TEN == 0;
    }

    /**
     * Get the missing digit for Luhn algorithm.
     *
     * @param sum
     *            sum
     * @param a
     *            What is missing to reach a multiple of TEN
     * @param b
     *            What is missing to reach a multiple of TEN
     * @param missingPosition
     *            Missing position
     * @return missing digit
     */
    private static int getMissingDigit(final int sum, final int a,
            final int b, final int missingPosition) {
        if (missingPosition % TWO == 0) {
            if ((sum + (a / TWO) % TEN == 0)) {
                return a / TWO;
            }
            if ((sum + (b / TWO) % TEN == 0)) {
                return b / TWO;
            }
        } else {
            if ((sum + a) % TEN == 0) {
                return a;
            }
            if ((sum + b) % TEN == 0) {
                return b;
            }
        }

        for (int i = 1; i <= NINE; i++) {
            int checkSum = sum;
            int fact = i;
            if (missingPosition % TWO == 0) {
                fact = (i * TWO);
                if (fact >= TEN) {
                    checkSum = checkSum + (fact - NINE);
                } else {
                    checkSum = checkSum + fact;
                }
            } else {
                checkSum += i;
            }

            if (checkSum % TEN == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Replace the digit at position.
     *
     * @param number
     *            card number
     * @param digit
     *            digit to replace
     * @param position
     *            position to replace
     * @return the card with the digit replaced
     */
    public static String setDigitAtPosition(final String number,
            final int digit, final int position) {
        StringBuilder option = new StringBuilder(number);
        option.setCharAt(position, (Integer.toString(digit)).charAt(0));
        return option.toString();
    }

    /**
     * Fix the missing (?) position.
     *
     * @param cardNumber
     *            card number
     * @param missingPosition
     *            missing position
     * @param sum
     *            Luhn sum
     * @param a
     *            What is missing to reach a multiple of TEN
     * @param b
     *            What is missing to reach a multiple of TEN
     * @return card number with fixed position
     */
    public static String fixMissingPosition(final String cardNumber,
            final int missingPosition, final int sum,
            final int a, final int b) {
        int digit = getMissingDigit(sum, a, b, missingPosition);
        return setDigitAtPosition(cardNumber, digit, missingPosition);
    }

    /**
     * Luhn.
     *
     * @param cardNumber
     *            card number
     * @return card number with fixed position
     */
    public static String correctLuhn(final String cardNumber) {
        int missingPosition = cardNumber.indexOf('?');
        int sum = sumLuhn(cardNumber, missingPosition);
        int factA = sum % TEN; // What is missing to reach a multiple of TEN
        int factB = TEN - factA;
        if (sum % TEN != 0) {
            if (missingPosition > -1) {
                return fixMissingPosition(cardNumber, missingPosition, sum,
                        factA, factB);
            } else {
                return fixSwapError(cardNumber, sum, factA, factB);
            }
        } else {
            if (missingPosition > -1) {
                return setDigitAtPosition(cardNumber, 0, missingPosition);
            }
            return fixSwapError(cardNumber, sum, factA, factB);
        }
    }

    /**
     * Main.
     *
     * @param args
     *            Arguments
     * @throws NumberFormatException
     *             NumberFormatException
     * @throws IOException
     *             IOException
     */
    public static void main(final String[] args) throws NumberFormatException,
            IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        int qty = Integer.parseInt(reader.readLine());

        for (int i = 0; i < qty; i++) {
            String cardNumber = reader.readLine();
            System.out.print(correctLuhn(cardNumber) + " ");
        }
    }
}

