package com.zelek.rafal.game.two;

import static org.fest.assertions.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PositionValidatorTest {

	@Test
	@Parameters({ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" })
	public void shouldBeTrue(int value) {
		// given
		int range = 10;

		// when
		boolean validation = PositionValidator.validate(value, range);

		// then
		assertThat(validation).isEqualTo(true);
	}

	@Test
	@Parameters({ "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9" })
	public void shouldBeFalseByFewerThan0(int value) {
		// given
		int range = 10;

		// when
		boolean validation = PositionValidator.validate(value, range);

		// then
		assertThat(validation).isEqualTo(false);
	}

	@Test
	@Parameters({ "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" })
	public void shouldBeFalseByMoreOrEqualThanRange(int value) {
		// given
		int range = 10;

		// when
		boolean validation = PositionValidator.validate(value, range);

		// then
		assertThat(validation).isEqualTo(false);
	}

}
