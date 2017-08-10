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
    private Map<String, Integer> ALPHABET_NUMBERS = null;
    private static final Integer NEGATIVE = -1;
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;
    private static final Integer TWO = 2;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;
    private static final Integer SEVEN = 7;
    private static final Integer EIGHT = 8;
    private static final Integer NINE = 9;
    private static final Integer TEN = 10;
    private static final Integer ELEVEN = 11;
    private static final Integer TWELVE = 12;
    private static final Integer THIRTEEN = 13;
    private static final Integer FOURTEEN = 14;
    private static final Integer FIFTEEN = 15;
    private static final Integer SIXTEEN = 16;
    private static final Integer SEVENTEEN = 17;
    private static final Integer EIGHTEEN = 18;
    private static final Integer NINETEEN = 19;
    private static final Integer TWENTY = 20;
    private static final Integer THIRTY = 30;
    private static final Integer FORTY = 40;
    private static final Integer FIFTY = 50;
    private static final Integer SIXTY = 60;
    private static final Integer SEVENTY = 70;
    private static final Integer EIGHTY = 80;
    private static final Integer NINETY = 90;
    private static final Integer HUNDRED = 100;
    private static final Integer THOUSAND = 1000;
    private static final Integer MILLION = 1000000;

    /** Private constructor. */
    private Main() {
    }
    static{
        ALPHABET_NUMBERS = new HashMap<String, Integer>();
    	ALPHABET_NUMBERS.put("negative", NEGATIVE);
    	ALPHABET_NUMBERS.put("zero", ZERO);
    	ALPHABET_NUMBERS.put("one", ONE);
    	ALPHABET_NUMBERS.put("two", TWO);
    	ALPHABET_NUMBERS.put("three", THREE);
    	ALPHABET_NUMBERS.put("four", FOUR);
    	ALPHABET_NUMBERS.put("five", FIVE);
    	ALPHABET_NUMBERS.put("six", SIX);
    	ALPHABET_NUMBERS.put("seven", SEVEN);
    	ALPHABET_NUMBERS.put("eight", EIGHT);
    	ALPHABET_NUMBERS.put("nine", NINE);
    	ALPHABET_NUMBERS.put("ten", TEN);
    	ALPHABET_NUMBERS.put("eleven", ELEVEN);
    	ALPHABET_NUMBERS.put("twelve", TWELVE);
    	ALPHABET_NUMBERS.put("thirteen", THIRTEEN);
    	ALPHABET_NUMBERS.put("fourteen", FOURTEEN);
    	ALPHABET_NUMBERS.put("fifteen", FIFTEEN);
    	ALPHABET_NUMBERS.put("sixteen", SIXTEEN);
    	ALPHABET_NUMBERS.put("seventeen", SEVENTEEN);
    	ALPHABET_NUMBERS.put("eighteen", EIGHTEEN);
    	ALPHABET_NUMBERS.put("nineteen", NINETEEN);
    	ALPHABET_NUMBERS.put("twenty", TWENTY);
    	ALPHABET_NUMBERS.put("thirty", THIRTY);
    	ALPHABET_NUMBERS.put("forty", FORTY);
    	ALPHABET_NUMBERS.put("fifty", FIFTY);
    	ALPHABET_NUMBERS.put("sixty", SIXTY);
    	ALPHABET_NUMBERS.put("seventy", SEVENTY);
    	ALPHABET_NUMBERS.put("eighty", EIGHTY);
    	ALPHABET_NUMBERS.put("ninety", NINETY);
    	ALPHABET_NUMBERS.put("hundred", HUNDRED);
    	ALPHABET_NUMBERS.put("thousand", THOUSAND);
    	ALPHABET_NUMBERS.put("million", MILLION);
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
    		if (ALPHABET_NUMBERS.containsKey(number)) {
    			Integer numberConvert = ALPHABET_NUMBERS.get(number);
    			if (Integer.toString(numberConvert).length() >= 3) {
    				numberAuxuliar = numberConvert;
    			} else if (numberAuxuliar > 0) {
    				numberAuxuliar *= numberConvert;
    				numberFinal += numberAuxuliar;
    				numberAuxuliar = 0;
    			} else if (numberConvert <0) {
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
			String currentLine;
			while (( currentLine = bufferedReader.readLine() ) != null) {
				listLine.add(currentLine.trim());
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
        ArrayList<String> listLine =readFile(pathFile);
        for (String line: listLine) {
        	Integer number = convertTextToNumber(line);
        	if(number != null) {
        		System.out.println(number);
        	} else {
        		System.out.println("Number invalid");
        	}
        }
    }
}
