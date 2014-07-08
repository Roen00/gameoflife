package com.zelek.rafal.game.two;

public final class CellsRecognizer {
	private CellsRecognizer() {

	}

	public static int countCellType(Class<? extends Cell> cellType, Cell cell) {
		return cellType.isInstance(cell) ? 1 : 0;
	}
}