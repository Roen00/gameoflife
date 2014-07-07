package com.zelek.rafal.game.two;

import static com.google.common.base.Preconditions.checkArgument;

public class PositionValidator {

	private int[] ranges;
	
	public PositionValidator(int... ranges) {
		this.ranges = ranges;
	}
	
	public boolean validate(int... coordinates){
		checkArgument(coordinates.length==ranges.length);
		boolean result=true;
		for (int i = 0; i < coordinates.length; i++) {
			result=result && validateCondition(coordinates[i], ranges[i]); 
		}
		return result;
	}
	public boolean validateCondition(int value, int range) {
		return (value >= 0) && (value < range);
	}

}