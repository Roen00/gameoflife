package com.zelek.rafal.game.two;

public abstract class Displayer {

	protected Mapper mapper;
	
	public abstract void display(final Cell[][] cells);

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

}
