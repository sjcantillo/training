package com.fluid;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long size = Long.parseLong(scanner.nextLine());
		String numbers = scanner.nextLine();
		System.out.print(calculateMinMax(numbers, size, false) + " "
				+ calculateMinMax(numbers, size, true));
	}
	
	public static Long calculateMinMax(String numbers, Long size, boolean isMax) {
		Long calculateNumber = new Long(0);
		Long sumNumbers = new Long(0);
		String[] arrayNumbers = numbers.split(" ");
		if (arrayNumbers.length >= size) {
			for (Integer i = 0; i < size; i++) {
				sumNumbers = new Long(0);
				for (Integer j = 0; j < size; j++) {
					if (j != i)
						sumNumbers += Long.parseLong(arrayNumbers[j]);
				}
				calculateNumber = compareNumbers(calculateNumber, sumNumbers,
						isMax);
			}
		}
		return calculateNumber;
	}
	public static Long compareNumbers(Long currentNumber, Long possibleNumber,
			boolean isMax) {
		Long newNumber;
		if (isMax) {
			newNumber = possibleNumber > currentNumber ? possibleNumber
					: currentNumber;
		} else {
			newNumber = (possibleNumber < currentNumber)
					|| (currentNumber == 0) ? possibleNumber : currentNumber;
		}
		return newNumber;
	}
}
