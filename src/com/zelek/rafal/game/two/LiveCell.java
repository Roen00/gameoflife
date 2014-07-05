package com.zelek.rafal.game.two;

public class LiveCell implements Cell {

	@Override
	public Cell evolve(Neighbourhood neighbourhood) {
		int liveNeighbours = neighbourhood.numberOf(LiveCell.class);
		if (liveNeighbours == 2 || liveNeighbours == 3) {
			return new LiveCell();
		} else {
			return new DeadCell();
		}
	}

}
