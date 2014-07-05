package com.zelek.rafal.game.two;

import static org.junit.Assert.*;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class EngineTest {

	@Test
	public void shouldDoStepStay4CellsAlive() {
		// given
		Board board = new Board(5, 5);
		board.set(0, 0, new LiveCell());
		board.set(1, 1, new LiveCell());
		board.set(0, 1, new LiveCell());
		board.set(1, 0, new LiveCell());

		// when
		board.doStep();

		// then
		Assertions.assertThat(board.cellAt(0, 0)).isInstanceOf(LiveCell.class);
		Assertions.assertThat(board.cellAt(1, 1)).isInstanceOf(LiveCell.class);
		Assertions.assertThat(board.cellAt(0, 1)).isInstanceOf(LiveCell.class);
		Assertions.assertThat(board.cellAt(1, 0)).isInstanceOf(LiveCell.class);
	}

}
