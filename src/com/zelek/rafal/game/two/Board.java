package com.zelek.rafal.game.two;

import java.util.Arrays;

public class Board {

	private Cell[][] cells;
	private Cell[][] tempCells;
	private int width;
	private int height;
	private Displayer displayer;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.displayer = new ConsoleDisplayer();
		cells = new Cell[width][height];
		tempCells = new Cell[width][height];
		fillArrayWithDeadCells(cells);
		fillArrayWithDeadCells(tempCells);
	}

	private void fillArrayWithDeadCells(Cell[][] cellsArray) {
		for (Cell[] row : cellsArray) {
			Arrays.fill(row, new DeadCell());
		}
	}

	public void set(int x, int y, Cell cell) {
		cells[x][y] = cell;
	}

	public Cell cellAt(int x, int y) {

		return cells[x][y];
	}
	
	public void doStep(){
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				Cell evolvedCell = cells[j][i].evolve(neighbourhoodOf(j,i));
				tempCells[j][i] = evolvedCell;
			}
		}
		for (int i = 0; i < cells.length; i++) {
				cells[i] = Arrays.copyOf(tempCells[i], tempCells[i].length);
		}
		fillArrayWithDeadCells(tempCells);
		
	}
	
	public void display(){
		displayer.display(cells);
	}

	
	public Neighbourhood neighbourhoodOf(int x, int y) {
		int range = 1;
		Neighbourhood neighbourhoodOfCell = new Neighbourhood();
		for (int i = -range; i <= range; i++) {
			for (int j = -range; j <= range; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (PositionValidator.validate(x + i, width)
						&& PositionValidator.validate(y + j, height)) {
					neighbourhoodOfCell.add(cells[x + i][y + j]);
				}
			}
		}
		return neighbourhoodOfCell;
	}

}
