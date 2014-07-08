package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NeighbourhoodTest {
	
	private CellFactory cellFactory = new BaseCellFactory();

	@Test
	public void neighbourhoodShoudReturn3LiveCells() {
		// given
		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.add(cellFactory.live());
		neighbourhood.add(cellFactory.live());
		neighbourhood.add(cellFactory.live());
		// when
		int numberOfLiveCells = neighbourhood.numberOf(LiveCell.class);

		// then
		assertThat(numberOfLiveCells).isEqualTo(3);
	}

	@Test
	public void neighbourhoodShoudReturn3DeadCells() {
		// given
		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.add(cellFactory.dead());
		neighbourhood.add(cellFactory.dead());
		neighbourhood.add(cellFactory.dead());
		// when
		int numberOfDeadCells = neighbourhood.numberOf(DeadCell.class);

		// then
		assertThat(numberOfDeadCells).isEqualTo(3);
	}

}
