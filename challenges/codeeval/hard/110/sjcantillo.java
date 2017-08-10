package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para resolver el reto text to number
 *
 * @author silvio.cantillo
 * @version 1.0
 */
public final class Main {
	private static final Map<String,Integer> ALPHABET_NUMBERS = new HashMap<String, Integer>();
    /** Private constructor. */
    private Main() {
    }
    static{
    	ALPHABET_NUMBERS.put("negative", -1);
    	ALPHABET_NUMBERS.put("zero", 0);
    	ALPHABET_NUMBERS.put("one", 1);
    	ALPHABET_NUMBERS.put("two", 2);
    	ALPHABET_NUMBERS.put("three", 3);
    	ALPHABET_NUMBERS.put("four", 4);
    	ALPHABET_NUMBERS.put("five", 5);
    	ALPHABET_NUMBERS.put("six", 6);
    	ALPHABET_NUMBERS.put("seven", 7);
    	ALPHABET_NUMBERS.put("eight", 8);
    	ALPHABET_NUMBERS.put("nine", 9);
    	ALPHABET_NUMBERS.put("ten", 10);
    	ALPHABET_NUMBERS.put("eleven", 11);
    	ALPHABET_NUMBERS.put("twelve", 12);
    	ALPHABET_NUMBERS.put("thirteen", 13);
    	ALPHABET_NUMBERS.put("fourteen", 14);
    	ALPHABET_NUMBERS.put("fifteen", 15);
    	ALPHABET_NUMBERS.put("sixteen", 16);
    	ALPHABET_NUMBERS.put("seventeen", 17);
    	ALPHABET_NUMBERS.put("eighteen", 18);
    	ALPHABET_NUMBERS.put("nineteen", 19);
    	ALPHABET_NUMBERS.put("twenty", 20);
    	ALPHABET_NUMBERS.put("thirty", 30);
    	ALPHABET_NUMBERS.put("forty", 40);
    	ALPHABET_NUMBERS.put("fifty", 50);
    	ALPHABET_NUMBERS.put("sixty", 60);
    	ALPHABET_NUMBERS.put("seventy", 70);
    	ALPHABET_NUMBERS.put("eighty", 80);
    	ALPHABET_NUMBERS.put("ninety", 90);
    	ALPHABET_NUMBERS.put("hundred", 100);
    	ALPHABET_NUMBERS.put("thousand", 1000);
    	ALPHABET_NUMBERS.put("million", 1000000);
    }
    /**
     * Metodo para transformar el texto en numero
     *
     * @param text
     *            string con el numero en texto
     * @return retorna el texto convertido a un numero
     */
    public static Integer convertTextToNumber(final String text) {
    	String[] numbers = text.split(" ");
    	Integer numberAuxuliar = 0;
    	Integer numberFinal = 0;
    	for(int i =numbers.length - 1 ;i >= 0;i--){
    		String number = numbers[i].trim();
    		if(ALPHABET_NUMBERS.containsKey(number)) {
    			Integer numberConvert = ALPHABET_NUMBERS.get(number);
    			if(Integer.toString(numberConvert).length() >=3) {
    				numberAuxuliar = numberConvert;
    			} else if(numberAuxuliar > 0) {
    				numberAuxuliar *= numberConvert;
    				numberFinal += numberAuxuliar;
    				numberAuxuliar = 0;
    			} else if(numberConvert <0) {
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
     * Metodo leer archivo
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
			while((currentLine = bufferedReader.readLine() ) != null) {
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
        for(String line:listLine) {
        	Integer number = convertTextToNumber(line);
        	if(number !=null) {
        		System.out.println(number);
        	} else {
        		System.out.println("Number invalid");
        	}
        }
    }
}
