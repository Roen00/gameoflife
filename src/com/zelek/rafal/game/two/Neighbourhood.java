package com.zelek.rafal.game.two;

import java.util.LinkedList;
import java.util.List;

public class Neighbourhood {

	private List<Cell> cells = new LinkedList<>();

	public void add(Cell cell) {
		cells.add(cell);
	}

	public int numberOf(Class<? extends Cell> cellType) {
		int sum = 0;
		for (Cell cell : cells) {
			sum = sum + CellsRecognizer.countCellType(cellType, cell);
		}
		return sum;
	}
}
