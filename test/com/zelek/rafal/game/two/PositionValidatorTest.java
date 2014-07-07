package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PositionValidatorTest {
	@Before
	public void setUp(){

		//positionValidator = new PositionValidator(1,10);
	}
	
	
	@Test
	@Parameters({ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" })
	public void shouldBeTrue(int value) {
		// given

		PositionValidator positionValidator = new PositionValidator(10, 10);
		// when
		boolean validation = positionValidator.validate(value, value);

		// then
		assertThat(validation).isEqualTo(true);
	}

	@Test
	@Parameters({ "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9" })
	public void shouldBeFalseByFewerThan0(int value) {
		// given
		PositionValidator positionValidator = new PositionValidator(10,10);

		// when
		boolean validationX = positionValidator.validate(value, 0);
		boolean validationY = positionValidator.validate(0, value);
		boolean validationXY = positionValidator.validate(value, value);

		// then
		assertThat(validationX).isEqualTo(false);
		assertThat(validationY).isEqualTo(false);
		assertThat(validationXY).isEqualTo(false);
	}

	@Test
	@Parameters({ "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" })
	public void shouldBeFalseByMoreOrEqualThanRange(int value) {
		// given
		PositionValidator positionValidator = new PositionValidator(10,10);

		// when
		boolean validationX = positionValidator.validate(value, 0);
		boolean validationY = positionValidator.validate(0, value);
		boolean validationXY = positionValidator.validate(value, value);

		// then
		assertThat(validationX).isEqualTo(false);
		assertThat(validationY).isEqualTo(false);
		assertThat(validationXY).isEqualTo(false);
	}

}
