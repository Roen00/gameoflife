package com.zelek.rafal.game.two;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;

public class CellUtils {
	public static Optional<Cell> findCellByCoordinates(
			ArrayListMultimap<Cell, Coordinate> cells, Coordinate cellCoordinate) {
		for (Cell cell : cells.keySet()) {
			if (cells.containsEntry(cell, cellCoordinate)) {
				return Optional.of(cell);
			}

		}
		return Optional.absent();

	}
}
