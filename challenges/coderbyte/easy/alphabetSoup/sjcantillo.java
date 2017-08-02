package com.fluid;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(AlphabetSoup(scanner.nextLine()));
	}
	
	public static String AlphabetSoup(String string) {

		char cadenaCaractares[] = string.toCharArray();
		Arrays.sort(cadenaCaractares);
		StringBuilder stringBuilder = new StringBuilder();
		for (char caracter : cadenaCaractares) {
			stringBuilder.append(caracter);
		}
		return stringBuilder.toString();

	}


}