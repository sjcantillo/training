package com.fluid;
import java.util.Arrays;
import java.util.Scanner
/**
* {@inheritDoc}
*/  
public class Main {
	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(alphabetSoup(scanner.nextLine()));
	}
	public static String alphabetSoup(final String string) {
		char[] cadenaCaractares = string.toCharArray();
		Arrays.sort(cadenaCaractares);
		StringBuilder stringBuilder = new StringBuilder();
		for (char caracter : cadenaCaractares) {
			stringBuilder.append(caracter);
		}
		return stringBuilder.toString();
	}
}
