package lrn.cc.drill.done;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DrillU2L05at2301240927 {

	@Test
	void testU2L05() {
		// DECLARE VARIABLES HERE, AS NECESSARY TO make the lines below pass the test
		int cycle = 0;
		double booble = 0.3333333333333333;
		double argument = 4;
		double mail = 29;
		double speed = 0.13793103448275862;
		System.out.println(speed);
		double radio = 2.73453;
		double market = 3d;
		float file = 3F;
		boolean temperature = true;
		
		
		assertEquals(7 / 21, cycle);
		assertEquals(7D / 21D, booble);
		assertEquals(argument / mail, speed); // declare argument as double of 3, 4 or 5.
//		// Declare mail as double of 28, 29, or 30 etc but less than 37
//		// Declare speed as a double value;
		assertTrue(Double.class.isInstance(radio)); // declare without using the d or D suffix
		assertTrue(!Float.class.isInstance(market)); // declare using the d or D suffix
		assertTrue(Float.class.isInstance(file));
		assertFalse(temperature); // declare temperature as true if a float or a double should be used for money values,
//							// else false
	}

}
