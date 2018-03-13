package com.company.dungeon.utilities;

import java.util.Scanner;

public final class ScannerUtil {

	private static final Scanner scanner = new Scanner(System.in);

	private ScannerUtil() {
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static String printMessageAndGetInput(String string) {
		System.out.print("\033[H\033[2J");
		System.out.print(string);

		return ScannerUtil.getScanner().next();
	}
}
