package com.company.dungeon.utilities;

public final class Preconditions {

	private Preconditions() {
		throw new IllegalStateException("utility class");
	}
	
	public static void checkState(boolean expression, Object errorMessage) {
		if (!expression) {
			throw new IllegalStateException(String.valueOf(errorMessage));
		}
	}
}
