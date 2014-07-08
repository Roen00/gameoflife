package com.zelek.rafal.game.two;

import static com.google.common.collect.ContiguousSet.create;
import static com.google.common.collect.DiscreteDomain.integers;
import static com.google.common.collect.Range.closed;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Board {

	private ArrayListMultimap<Cell, Coordinate> cells = ArrayListMultimap.create();
	private ArrayListMultimap<Cell, Coordinate> tempCells = ArrayListMultimap.create();

	private Displayer displayer;

	private PositionValidator positionValidator;
	private int width;
	private int height;
	private CellFactory cellFactory;

	public void setDisplayer(Displayer displayer) {
		this.displayer = displayer;
	}

	public Board(int width, int height, Displayer displayer, CellFactory cellFactory) {
		this.width = width;
		this.height = height;
		this.displayer = displayer;
		this.cellFactory = cellFactory;
		positionValidator = new PositionValidator(width, height);
	}

	public void set(Coordinate coordinate, Cell cell) {
		cells.put(cellFactory.live(), coordinate);
	}

	public Cell cellAt(Coordinate coordinate) {

		for (Cell cellsEntry : cells.keySet()) {
			if (cells.containsEntry(cellsEntry, coordinate)) {
				return cellsEntry;
			}
		}
		return cellFactory.dead();
	}

	public void doStep() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Coordinate cellCoordinate = new Coordinate(i, j);
				Optional<Cell> optionalCell = CellUtils.findCellByCoordinates(cells, cellCoordinate);
				Neighbourhood cellNeighbourhood = neighbourhoodOf(cellCoordinate);
				Cell evolvedCell = optionalCell.or(cellFactory.dead()).evolve(cellNeighbourhood);
				tempCells.put(evolvedCell, cellCoordinate);
			}
		}

		copyTempCellsToCells();
		tempCells.clear();

	}

	private void evolveCell(Cell cell, Coordinate cellCoordinate) {
		Neighbourhood cellNeighbourhood = neighbourhoodOf(cellCoordinate);

		Cell evolvedCell = cell.evolve(cellNeighbourhood);
		tempCells.put(evolvedCell, cellCoordinate);
	}

	private void copyTempCellsToCells() {
		cells = ArrayListMultimap.create(tempCells);
	}

	public void display() {
		displayer.display(cells, width, height);
	}

	public Neighbourhood neighbourhoodOf(Coordinate coordinate) {
		Neighbourhood neighbourhoodOfCell = new Neighbourhood();
		for (Coordinate neighbourCoordinate : neighboursCoordinates(coordinate.getX(), coordinate.getY())) {
			addNeighbourIfValid(neighbourhoodOfCell, neighbourCoordinate);
		}
		return neighbourhoodOfCell;
	}

	private void addNeighbourIfValid(Neighbourhood neighbourhoodOfCell, Coordinate coordinate) {
		if (positionValidator.validate(coordinate.getX(), coordinate.getY())) {
			neighbourhoodOfCell.add(cellAt(coordinate));
		}
	}

	private Collection<Coordinate> neighboursCoordinates(int x, int y) {
		com.google.common.collect.Range<Integer> rangeX = closed(x - 1, x + 1);
		com.google.common.collect.Range<Integer> rangeY = closed(y - 1, y + 1);

		Set<List<Integer>> cartesianProduct = Sets
				.newHashSet(Sets.cartesianProduct(create(rangeX, integers()), create(rangeY, integers())));
		cartesianProduct.remove(Lists.newArrayList(x, y));

		return Collections2.transform(cartesianProduct, Transformations.listToCoordinate);

	}
}
