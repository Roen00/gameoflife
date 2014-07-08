package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CellTest {
	private CellFactory cellFactory = new BaseCellFactory();

	@Test
	@Parameters({ "0", "4", "5" })
	public void liveCellWithFewerThan2OrMoreThan4NeighboursShouldDie(
			int numberOfNeighbours) {
		// given
		Cell cell = cellFactory.live();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(cellFactory.live());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(cellFactory.dead().getClass());
	}

	@Test
	@Parameters({ "2", "3" })
	public void liveCellWithTwoOrThreeShouldLive(int numberOfNeighbours) {
		// given
		Cell cell = cellFactory.live();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(cellFactory.live());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(cellFactory.live().getClass());
	}

	@Test
	@Parameters({ "3" })
	public void deadCellWith3LiveNeighboursShouldAlive(int numberOfNeighbours) {
		// given
		Cell cell = cellFactory.dead();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(cellFactory.live());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(cellFactory.live().getClass());
	}

	@Test
	@Parameters({ "0", "1", "2", "4" })
	public void deadCellNot3LiveNeighboursShouldStayDead(int numberOfNeighbours) {
		// given
		Cell cell = cellFactory.dead();
		
		Neighbourhood neighbourhood = new Neighbourhood();
		for (int i = 0; i < numberOfNeighbours; i++) {
			neighbourhood.add(cellFactory.live());
		}

		// when

		Cell evolvedCell = cell.evolve(neighbourhood);

		// then
		assertThat(evolvedCell).isInstanceOf(cellFactory.dead().getClass());
	}

}
