package com.zelek.rafal.game.two;

public class BaseCellFactory implements CellFactory {

	private final Cell deadCell=new DeadCell(this);
	private final Cell liveCell=new LiveCell(this);
	
	@Override
	public Cell dead() {
		return deadCell;
	}
	
	@Override
	public Cell live() {
		return liveCell;
	}

}
