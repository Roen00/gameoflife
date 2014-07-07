package com.zelek.rafal.game.two;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board(5, 5, new ConsoleDisplayer(new TextMapper()));
	}

	@Test
	public void shouldReturn3LiveNeighbours() {
		// given
		board.set(0, 0, new LiveCell());
		board.set(1, 1, new LiveCell());
		board.set(0, 1, new LiveCell());
		board.set(1, 0, new LiveCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(0, 0);
		int numberOfLivingNeighbours = neighbourhood.numberOf(LiveCell.class);

		// then
		Assertions.assertThat(numberOfLivingNeighbours).isEqualTo(3);
	}

	@Test
	public void shouldReturn8LiveNeighbours() {
		// given
		board.set(0, 0, new LiveCell());
		board.set(0, 1, new LiveCell());
		board.set(0, 2, new LiveCell());
		board.set(1, 0, new LiveCell());
		board.set(1, 2, new LiveCell());
		board.set(2, 0, new LiveCell());
		board.set(2, 1, new LiveCell());
		board.set(2, 2, new LiveCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(1, 1);
		int numberOfLivingNeighbours = neighbourhood.numberOf(LiveCell.class);

		// then
		Assertions.assertThat(numberOfLivingNeighbours).isEqualTo(8);
	}

	@Test
	public void thereShouldBePossibilityToInitiateBoard() {
		// when
		board.set(1, 1, new LiveCell());
		board.set(2, 2, new LiveCell());

		// then
		Assertions.assertThat(board.cellAt(1, 1)).isInstanceOf(LiveCell.class);
	}

	@Test
	public void shouldReturn8DeadNeighbours() {
		// given
		board.set(1, 1, new DeadCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(1, 1);
		int numberOfDeadNeighbours = neighbourhood.numberOf(DeadCell.class);

		// then
		Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(8);
	}

	@Test
	public void shouldReturn3DeadNeighbours() {
		// given
		board.set(0, 0, new LiveCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(0, 0);
		int numberOfDeadNeighbours = neighbourhood.numberOf(DeadCell.class);

		// then
		Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(3);
	}

	@Test
	public void shouldReturn3DeadNeighboursRightBottom() {
		// given
		board.set(4, 4, new LiveCell());
		board.set(4, 3, new LiveCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(4, 4);
		int numberOfDeadNeighbours = neighbourhood.numberOf(DeadCell.class);

		// then
		Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(2);
	}

	@Test
	public void shouldReturn2DeadNeighbours() {
		// given
		board.set(0, 0, new LiveCell());
		board.set(1, 1, new LiveCell());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(0, 0);
		int numberOfDeadNeighbours = neighbourhood.numberOf(DeadCell.class);

		// then
		Assertions.assertThat(numberOfDeadNeighbours).isEqualTo(2);
	}
	
	@Test
	public void shouldDoStepStay4CellsAlive() {
		// given
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
	
	@Test
	public void shouldDoStepMakeCellDead() {
		// given
		board.set(0, 0, new LiveCell());

		// when
		board.doStep();

		// then
		Assertions.assertThat(board.cellAt(0, 0)).isInstanceOf(DeadCell.class);
	}
	
	@Test
	public void shouldTesIntegracyjny() {
		// given
		board.set(1, 0, new LiveCell());
		board.set(2, 0, new LiveCell());
		board.set(0, 1, new LiveCell());
		board.set(1, 3, new LiveCell());
		board.set(2, 3, new LiveCell());
		board.set(3, 2, new LiveCell());

		// when
		board.display();
		board.doStep();
		System.out.println();
		board.display();
		board.doStep();
		System.out.println();
		board.display();

		// then
	}

}
