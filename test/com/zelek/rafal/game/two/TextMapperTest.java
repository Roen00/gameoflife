package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class TextMapperTest {
	
	

	@Test
	public void shouldTakeLivingCellAndReturnValidChar() {
		//given
		Cell cell = new LiveCell();
		Mapper mapper = new TextMapper();
		
		//when
		String expectedString = mapper.map(cell.getClass());
		//then
		assertThat(expectedString).isEqualTo("*");
	}
	
	@Test
	public void shouldTakeDeadCellAndReturnValidChar() {
		//given
		Cell cell = new DeadCell();
		Mapper mapper = new TextMapper();
		
		//when
		String expectedString = mapper.map(cell.getClass());
		//then
		assertThat(expectedString).isEqualTo("_");
	}

}
