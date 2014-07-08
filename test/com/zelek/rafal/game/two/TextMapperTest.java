package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class TextMapperTest {
	
	CellFactory cellFactory = new BaseCellFactory();

	@Test
	public void shouldTakeLivingCellAndReturnValidChar() {
		//given
		Cell cell = cellFactory.live();
		Mapper mapper = new TextMapper();
		
		//when
		String expectedString = mapper.map(cell.getClass());
		//then
		assertThat(expectedString).isEqualTo("*");
	}
	
	@Test
	public void shouldTakeDeadCellAndReturnValidChar() {
		//given
		Cell cell = cellFactory.dead();
		Mapper mapper = new TextMapper();
		
		//when
		String expectedString = mapper.map(cell.getClass());
		//then
		assertThat(expectedString).isEqualTo("_");
	}

}
