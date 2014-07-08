package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CellRecognizerTest {
	CellFactory cellFactory;
	@Before
	public void setUp(){
		cellFactory = new BaseCellFactory();
		
	}

	@Test
	public void shouldRecognizeLiveCell() {
		// given
		Cell liveCell =cellFactory.live();
		// when
		int result = CellsRecognizer.countCellType(cellFactory.live().getClass(), liveCell);

		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldNotRecognizeDeadCell() {
		// given
		Cell deadCell =cellFactory.dead();
		// when
		int result = CellsRecognizer.countCellType(cellFactory.live().getClass(), deadCell);

		// then
		assertThat(result).isEqualTo(0);
	}
}
