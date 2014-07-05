package com.zelek.rafal.game.two;

public final class CellsRecognizer {
	private CellsRecognizer() {

	}

	public static int countCellType(Class<? extends Cell> cellType, Cell cell) {
		if (cellType.isInstance(cell)) {
			return 1;
		} else {
			return 0;
		}
	}
}