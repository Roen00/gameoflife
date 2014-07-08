package com.zelek.rafal.game.two;

public class LiveCell implements Cell {

	private final CellFactory cellFactory;
	
	public LiveCell(BaseCellFactory baseCellFactory) {
		this.cellFactory=baseCellFactory;
	}

	@Override
	public Cell evolve(Neighbourhood neighbourhood) {
		int liveNeighbours = neighbourhood.numberOf(cellFactory.live().getClass());
		return (liveNeighbours == 2 || liveNeighbours == 3) ? cellFactory.live() : cellFactory.dead();
	}

}
