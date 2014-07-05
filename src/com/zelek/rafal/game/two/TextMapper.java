package com.zelek.rafal.game.two;


public class TextMapper extends Mapper {
	
	public TextMapper() {
		cellsMap.put(LiveCell.class, "*");
		cellsMap.put(DeadCell.class, "_");
	}
}
