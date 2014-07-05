package com.zelek.rafal.game.two;

import java.util.Arrays;

import org.junit.Test;

public class TextDisplayerTest {

	@Test
	public void shouldDisplayerDisplayCorrectOutput() {
		// given
		Cell[][] cells = new Cell[10][20];
		for (Cell[] row : cells) {
			Arrays.fill(row, new DeadCell());
		}

		cells[1][0] = new LiveCell();
		// when
		Displayer displayer = new ConsoleDisplayer();
		displayer.display(cells);
		// then

	}

}
