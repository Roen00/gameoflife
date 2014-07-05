package com.zelek.rafal.game.two;

public class Engine {
	private Board board;
	
	
	public Engine(Board board){
		this.board = board;
		
	}
	
	public void doSteps(){
		board.display();
		board.doStep();
		board.display();
		board.doStep();
		board.display();
		board.doStep();
		board.display();
	}
}
