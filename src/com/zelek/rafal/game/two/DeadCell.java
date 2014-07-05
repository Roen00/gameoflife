package com.zelek.rafal.game.two;

public class DeadCell implements Cell {

	@Override
	public Cell evolve(Neighbourhood neighbourhood) {
		if (neighbourhood.numberOf(LiveCell.class) == 3) {
			return new LiveCell();
		} else {
			return new DeadCell();
		}
	}

}
