package com.zelek.rafal.game.two;

import static com.google.common.collect.ContiguousSet.create;
import static com.google.common.collect.DiscreteDomain.integers;
import static com.google.common.collect.Range.closed;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Board {

	private Cell[][] cells;
	private Cell[][] tempCells;
	private Displayer displayer;
	
	private PositionValidator positionValidator;

	public void setDisplayer(Displayer displayer) {
		this.displayer = displayer;
	}

	public Board(int width, int height, Displayer displayer) {
		this.displayer = displayer;
		cells = new Cell[width][height];
		tempCells = new Cell[width][height];
		fillArrayWithDeadCells(cells);
		fillArrayWithDeadCells(tempCells);
		positionValidator=new PositionValidator(width,height);
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

	public void doStep() {
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				Cell evolvedCell = cells[j][i].evolve(neighbourhoodOf(j, i));
				tempCells[j][i] = evolvedCell;
			}
		}
		copyTempCellsToCells();
		fillArrayWithDeadCells(tempCells);

	}

	private void copyTempCellsToCells() {
		for (int i = 0; i < cells.length; i++) {
			cells[i] = Arrays.copyOf(tempCells[i], tempCells[i].length);
		}
	}

	public void display() {
		displayer.display(cells);
	}

	public Neighbourhood neighbourhoodOf(int x, int y) {
		Neighbourhood neighbourhoodOfCell = new Neighbourhood();
		for (Coordinate coordinate : neighboursCoordinates(x,y)) {
			addNeighbourIfValid(neighbourhoodOfCell, coordinate);
		}
		return neighbourhoodOfCell;
	}

	private void addNeighbourIfValid(Neighbourhood neighbourhoodOfCell,
			Coordinate coordinate) {
		if(positionValidator.validate(coordinate.getX(),coordinate.getY())){
			neighbourhoodOfCell.add(cells[coordinate.getX()][coordinate.getY()]);
		}
	}


	
	
	private Collection<Coordinate> neighboursCoordinates(int x, int y) {
		com.google.common.collect.Range<Integer> rangeX = closed(x-1,x+1);
		com.google.common.collect.Range<Integer> rangeY = closed(y-1,y+1);

		Set<List<Integer>> cartesianProduct = Sets.newHashSet(Sets.cartesianProduct(create(rangeX, integers()),create(rangeY, integers())));
		cartesianProduct.remove(Lists.newArrayList(x, y));
		
		return Collections2.transform(cartesianProduct, Transformations.listToCoordinate);
		
	}
}

class Transformations{
	public static Function<List<Integer>, Coordinate> listToCoordinate = new Function<List<Integer>, Coordinate>() {
		@Override
		public Coordinate apply(List<Integer> input) {
			return new Coordinate(input.get(0), input.get(1));
		}
	};
}

class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
}
