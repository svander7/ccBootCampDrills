package lrn.cc.drill.current;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DrillU2L06at2301241048 {

	@Test
	void testU2L06() {
		// DECLARE MISSING VARIABLES, AS NECESSARY TO make the lines below pass the test
		boolean step = true & true & true;
		boolean still = true & true & false;
		boolean record = false | true;
		boolean yesterday = 7 > 12;
		boolean glass = true | yesterday;
		boolean cable = true | true | true | true | true | yesterday;
		boolean register = 24 * 3 - 17 == 42;
		boolean secret = true;
		boolean orange = false;
		boolean regret = true;
		
		
		assertEquals(secret, step);
		assertEquals(orange, still);
		assertEquals(regret, record);
//		assertEquals(cable, yesterday);
//		assertEquals(jury, register);
	}

}
