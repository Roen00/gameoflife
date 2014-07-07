package com.zelek.rafal.game.two;

public class ConsoleDisplayer extends Displayer {
	

	public ConsoleDisplayer(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void display(final Cell[][] cells) {
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				System.out.print(mapper.map(cells[j][i].getClass()));
			}
			System.out.println("");
		}
	}
	
	

}
