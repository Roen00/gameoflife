package com.zelek.rafal.game.two;

public final class PositionValidator {
	private PositionValidator() {

	}

	public static boolean validate(int value, int range) {
		return (value >= 0) && (value < range);
	}
}