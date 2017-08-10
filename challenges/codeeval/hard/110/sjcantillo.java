package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para resolver el reto text to number.
 *
 * @author silvio.cantillo
 * @version 1.0
 */
public final class Main {
    /** Alphabet Numbers. */
    private Map<String, Integer> alphabetNumbers = null;
    /** Number. */
    private static final Integer NEGATIVE = -1;
    /** Number. */
    private static final Integer ZERO = 0;
    /** Number. */
    private static final Integer ONE = 1;
    /** Number. */
    private static final Integer TWO = 2;
    /** Number. */
    private static final Integer THREE = 3;
    /** Number. */
    private static final Integer FOUR = 4;
    /** Number. */
    private static final Integer FIVE = 5;
    /** Number. */
    private static final Integer SIX = 6;
    /** Number. */
    private static final Integer SEVEN = 7;
    /** Number. */
    private static final Integer EIGHT = 8;
    /** Number. */
    private static final Integer NINE = 9;
    /** Number. */
    private static final Integer TEN = 10;
    /** Number. */
    private static final Integer ELEVEN = 11;
    /** Number. */
    private static final Integer TWELVE = 12;
    /** Number. */
    private static final Integer THIRTEEN = 13;
    /** Number. */
    private static final Integer FOURTEEN = 14;
    /** Number. */
    private static final Integer FIFTEEN = 15;
    /** Number. */
    private static final Integer SIXTEEN = 16;
    /** Number. */
    private static final Integer SEVENTEEN = 17;
    /** Number. */
    private static final Integer EIGHTEEN = 18;
    /** Number. */
    private static final Integer NINETEEN = 19;
    /** Number. */
    private static final Integer TWENTY = 20;
    /** Number. */
    private static final Integer THIRTY = 30;
    /** Number. */
    private static final Integer FORTY = 40;
    /** Number. */
    private static final Integer FIFTY = 50;
    /** Number. */
    private static final Integer SIXTY = 60;
    /** Number. */
    private static final Integer SEVENTY = 70;
    /** Number. */
    private static final Integer EIGHTY = 80;
    /** Number. */
    private static final Integer NINETY = 90;
    /** Number. */
    private static final Integer HUNDRED = 100;
    /** Number. */
    private static final Integer THOUSAND = 1000;
    /** Number. */
    private static final Integer MILLION = 1000000;

    /** Private constructor. */
    private Main() {
    }
    static {
        alphabetNumbers = new HashMap<String, Integer>();
        alphabetNumbers.put("negative", NEGATIVE);
        alphabetNumbers.put("zero", ZERO);
        alphabetNumbers.put("one", ONE);
        alphabetNumbers.put("two", TWO);
        alphabetNumbers.put("three", THREE);
        alphabetNumbers.put("four", FOUR);
        alphabetNumbers.put("five", FIVE);
        alphabetNumbers.put("six", SIX);
        alphabetNumbers.put("seven", SEVEN);
        alphabetNumbers.put("eight", EIGHT);
        alphabetNumbers.put("nine", NINE);
        alphabetNumbers.put("ten", TEN);
        alphabetNumbers.put("eleven", ELEVEN);
        alphabetNumbers.put("twelve", TWELVE);
        alphabetNumbers.put("thirteen", THIRTEEN);
        alphabetNumbers.put("fourteen", FOURTEEN);
        alphabetNumbers.put("fifteen", FIFTEEN);
        alphabetNumbers.put("sixteen", SIXTEEN);
        alphabetNumbers.put("seventeen", SEVENTEEN);
        alphabetNumbers.put("eighteen", EIGHTEEN);
        alphabetNumbers.put("nineteen", NINETEEN);
        alphabetNumbers.put("twenty", TWENTY);
        alphabetNumbers.put("thirty", THIRTY);
        alphabetNumbers.put("forty", FORTY);
        alphabetNumbers.put("fifty", FIFTY);
        alphabetNumbers.put("sixty", SIXTY);
        alphabetNumbers.put("seventy", SEVENTY);
        alphabetNumbers.put("eighty", EIGHTY);
        alphabetNumbers.put("ninety", NINETY);
        alphabetNumbers.put("hundred", HUNDRED);
        alphabetNumbers.put("thousand", THOUSAND);
        alphabetNumbers.put("million", MILLION);
        }
    /**
     * Metodo para transformar el texto en numero.
     *
     * @param text
     *            string con el numero en texto
     * @return retorna el texto convertido a un numero
     */
    public static Integer convertTextToNumber(final String text) {
        String[] numbers = text.split(" ");
        Integer numberAuxuliar = 0;
        Integer numberFinal = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            String number = numbers[i].trim();
            if (alphabetNumbers.containsKey(number)) {
                Integer numberConvert = alphabetNumbers.get(number);
                if (Integer.toString(numberConvert).length() >= THREE) {
                    numberAuxuliar = numberConvert;
                } else if (numberAuxuliar > 0) {
                    numberAuxuliar *= numberConvert;
                    numberFinal += numberAuxuliar;
                    numberAuxuliar = 0;
                } else if (numberConvert < 0) {
                    numberFinal *= numberConvert;
                } else {
                    numberFinal += numberConvert;
                }
            } else {
                return null;
            }
        }
        return numberFinal;
    }

    /**
     * Metodo leer archivo.
     *
     * @param pathFile
     *            ruta del Archivo
     * @return retorna el listado de String de cada linea
     */
    public static ArrayList<String> readFile(final String pathFile) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        ArrayList<String> listLine = new ArrayList<String>();
        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String cLine;
            while ((cLine = bufferedReader.readLine()) != null) {
                listLine.add(cLine.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }

    /**
     * Main method.
     *
     * @param args
     *            Argumentos de Usuario
     */
    public static void main(final String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String pathFile = scanner.nextLine();
        ArrayList<String> listLine = readFile(pathFile);
        for (String line: listLine) {
            Integer number = convertTextToNumber(line);
            if (number != null) {
                System.out.println(number);
            } else {
                System.out.println("Number invalid");
            }
        }
    }
}
