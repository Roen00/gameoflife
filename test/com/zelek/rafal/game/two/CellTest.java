package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CellTest {

	@Test
	@Parameters({ "0", "4", "5" })
	public void liveCellWithFewerThan2OrMoreThan4NeighboursShouldDie(
			int numberOfNeighbours) {
		// given
		Cell cell = new LiveCell();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(new LiveCell());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(DeadCell.class);
	}

	@Test
	@Parameters({ "2", "3" })
	public void liveCellWithTwoOrThreeShouldLive(int numberOfNeighbours) {
		// given
		Cell cell = new LiveCell();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(new LiveCell());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(LiveCell.class);
	}

	@Test
	@Parameters({ "3" })
	public void deadCellWith3LiveNeighboursShouldAlive(int numberOfNeighbours) {
		// given
		Cell cell = new DeadCell();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(new LiveCell());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(LiveCell.class);
	}

	@Test
	@Parameters({ "0", "1", "2", "4" })
	public void deadCellNot3LiveNeighboursShouldStayDead(int numberOfNeighbours) {
		// given
		Cell cell = new DeadCell();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(new LiveCell());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(DeadCell.class);
	}

}
