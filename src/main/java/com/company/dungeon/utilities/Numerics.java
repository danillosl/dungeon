package com.company.dungeon.utilities;

public final class Numerics {

	private Numerics() {
		throw new IllegalStateException("utility class");
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}
