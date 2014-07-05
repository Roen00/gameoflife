package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class CellRecognizerTest {

	@Test
	public void shouldRecognizeLiveCell() {
		// given
		Cell liveCell = new LiveCell();
		// when
		int result = CellsRecognizer.countCellType(LiveCell.class, liveCell);

		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldNotRecognizeDeadCell() {
		// given
		Cell liveCell = new DeadCell();
		// when
		int result = CellsRecognizer.countCellType(LiveCell.class, liveCell);

		// then
		assertThat(result).isEqualTo(0);
	}
}
