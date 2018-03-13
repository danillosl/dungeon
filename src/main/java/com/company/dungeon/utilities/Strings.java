package com.company.dungeon.utilities;

public final class Strings {

	private Strings() {
		throw new IllegalStateException("utility class");
	}

	public static boolean isNullOrEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}
}
