package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NeighbourhoodTest {

	@Test
	public void neighbourhoodShoudReturn3LiveCells() {
		// given
		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.add(new LiveCell());
		neighbourhood.add(new LiveCell());
		neighbourhood.add(new LiveCell());
		// when
		int numberOfLiveCells = neighbourhood.numberOf(LiveCell.class);

		// then
		assertThat(numberOfLiveCells).isEqualTo(3);
	}

	@Test
	public void neighbourhoodShoudReturn3DeadCells() {
		// given
		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.add(new DeadCell());
		neighbourhood.add(new DeadCell());
		neighbourhood.add(new DeadCell());
		// when
		int numberOfDeadCells = neighbourhood.numberOf(DeadCell.class);

		// then
		assertThat(numberOfDeadCells).isEqualTo(3);
	}

}
