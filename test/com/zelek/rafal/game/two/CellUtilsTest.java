package com.zelek.rafal.game.two;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;

public class CellUtilsTest {

	@Test
	public void shouldUtilsFindAndNotFindCell() {
		// given
		ArrayListMultimap<Cell, Coordinate> cells = ArrayListMultimap.create();
		CellFactory cellFactory = new BaseCellFactory();

		Coordinate cellCoordinate = new Coordinate(2, 2);
		cells.put(cellFactory.live(), cellCoordinate);
		
		// when
		Cell findedCell = CellUtils.findCellByCoordinates(cells, cellCoordinate);
		Cell findedCellNull = CellUtils.findCellByCoordinates(cells, new Coordinate(1,2));

		// then
		Assertions.assertThat(findedCell).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(findedCellNull).isNull();
	}

}
