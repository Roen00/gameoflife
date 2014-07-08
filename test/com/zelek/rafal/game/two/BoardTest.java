package com.zelek.rafal.game.two;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;
	private CellFactory cellFactory;
	@Before
	public void setUp() {
		cellFactory = new BaseCellFactory();
		board = new Board(5, 5, new ConsoleDisplayer(new TextMapper()), cellFactory);
	}

	@Test
	public void shouldReturn3LiveNeighbours() {
		// given
		board.set(new Coordinate(0,0), cellFactory.live());
		board.set(new Coordinate(1,1), cellFactory.live());
		board.set(new Coordinate(0,1), cellFactory.live());
		board.set(new Coordinate(1,0), cellFactory.live());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(0, 0);
		int numberOfLivingNeighbours = neighbourhood.numberOf(cellFactory.live().getClass());

		// then
		Assertions.assertThat(numberOfLivingNeighbours).isEqualTo(3);
	}

	@Test
	public void shouldReturn8LiveNeighbours() {
		// given
		board.set(new Coordinate(0,0), cellFactory.live());
		board.set(new Coordinate(0,1), cellFactory.live());
		board.set(new Coordinate(0,2), cellFactory.live());
		board.set(new Coordinate(1,0), cellFactory.live());
		board.set(new Coordinate(1,2), cellFactory.live());
		board.set(new Coordinate(2,0), cellFactory.live());
		board.set(new Coordinate(2,1), cellFactory.live());
		board.set(new Coordinate(2,2), cellFactory.live());

		// when
		Neighbourhood neighbourhood = board.neighbourhoodOf(1, 1);
		
		System.out.println(neighbourhood);
		int numberOfLivingNeighbours = neighbourhood.numberOf(cellFactory.live().getClass());

		// then
		Assertions.assertThat(numberOfLivingNeighbours).isEqualTo(8);
	}

	@Test
	public void thereShouldBePossibilityToInitiateBoard() {
		// when
		board.set(new Coordinate(1,1), cellFactory.live());
		board.set(new Coordinate(2,2), cellFactory.live());

		// then
		Assertions.assertThat(board.cellAt(new Coordinate(1,1))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(2,2))).isInstanceOf(cellFactory.live().getClass());
	}


	@Test
	public void shouldDoStepStay4CellsAlive() {
		// given
		board.set(new Coordinate(0,0), cellFactory.live());
		board.set(new Coordinate(1,1), cellFactory.live());
		board.set(new Coordinate(0,1), cellFactory.live());
		board.set(new Coordinate(1,0), cellFactory.live());

		// when
		board.doStep();
		board.doStep();
		board.doStep();

		// then
		Assertions.assertThat(board.cellAt(new Coordinate(0, 0))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(1, 1))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(0, 1))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(1, 0))).isInstanceOf(cellFactory.live().getClass());
	}
	
	@Test
	public void shouldDoStepMakeCellDead() {
		// given
		board.set(new Coordinate(0,0), cellFactory.live());

		// when
		board.doStep();

		// then
		Assertions.assertThat(board.cellAt(new Coordinate(0,0))).isInstanceOf(cellFactory.dead().getClass());
	}
	
	@Test
	public void shouldTesIntegracyjny() {
		// given
		board.set(new Coordinate(1,0), cellFactory.live());
		board.set(new Coordinate(2,0), cellFactory.live());
		board.set(new Coordinate(0,1), cellFactory.live());
		board.set(new Coordinate(1,3), cellFactory.live());
		board.set(new Coordinate(2,3), cellFactory.live());
		board.set(new Coordinate(3,2), cellFactory.live());

		// when
		board.display();
		board.doStep();
		System.out.println();
		board.display();
		board.doStep();
		System.out.println();
		board.display();

		// then

		Assertions.assertThat(board.cellAt(new Coordinate(1,0))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(2,0))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(0,1))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(1,3))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(2,3))).isInstanceOf(cellFactory.live().getClass());
		Assertions.assertThat(board.cellAt(new Coordinate(3,2))).isInstanceOf(cellFactory.live().getClass());
	}

}
