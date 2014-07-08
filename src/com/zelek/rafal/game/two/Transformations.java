package com.zelek.rafal.game.two;

import java.util.List;

import com.google.common.base.Function;

public class Transformations {
	public static Function<List<Integer>, Coordinate> listToCoordinate = new Function<List<Integer>, Coordinate>() {
		@Override
		public Coordinate apply(List<Integer> input) {
			return new Coordinate(input.get(0), input.get(1));
		}
	};
}