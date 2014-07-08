package com.zelek.rafal.game.two;

public class DeadCell implements Cell {

	private final CellFactory cellFactory;

	public DeadCell(CellFactory cellFactory) {
		this.cellFactory = cellFactory;
	}

	@Override
	public Cell evolve(Neighbourhood neighbourhood) {
		return (neighbourhood.numberOf(cellFactory.live().getClass()) == 3) ? cellFactory.live() : cellFactory.dead();
	}

}
