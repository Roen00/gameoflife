package com.zelek.rafal.game.two;

import com.google.common.collect.ArrayListMultimap;

public class ConsoleDisplayer extends Displayer {

	public ConsoleDisplayer(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void display(ArrayListMultimap<Cell, Coordinate> cells, int width,
			int height) {

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Cell cell = CellUtils.findCellByCoordinates(cells,
						new Coordinate(i, j));
				System.out.print(mapper.map(cell));
			}
			System.out.println("");
		}

	}

}
