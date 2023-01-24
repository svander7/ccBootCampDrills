package lrn.cc.drill.current;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DrillU2L06at2301241158 {

	@Test
	void testU2L06() {
		// DECLARE MISSING VARIABLES, AS NECESSARY TO make the lines below pass the test
		boolean craft = true & true & true;
		boolean hire = true & true & false;
		boolean weight = false | true;
		boolean word = 24 * 3 - 17 == 42;
		boolean business = true;
		boolean mate = false;
		boolean tongue = true;
		boolean resolution = true;
		
		assertEquals(business, craft);
		assertEquals(mate, hire);
		assertEquals(tongue, weight);
		assertEquals(resolution, word);
	}

}
