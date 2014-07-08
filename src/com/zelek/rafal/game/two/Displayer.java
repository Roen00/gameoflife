package com.zelek.rafal.game.two;

import com.google.common.collect.ArrayListMultimap;

public abstract class Displayer {

	protected Mapper mapper;
	
	public abstract void display(final ArrayListMultimap<Cell,Coordinate> cells, int width, int height);

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

}
