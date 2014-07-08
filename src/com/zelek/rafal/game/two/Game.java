package com.zelek.rafal.game.two;

public class Game {
	public static void main(String[] args) {
		CellFactory factory=new  BaseCellFactory();
		Mapper mapper=new TextMapper();
		Displayer displayer=new ConsoleDisplayer(mapper);
		Board board=new Board(20, 20, displayer, factory);
		
		board.doStep();
	}
}
