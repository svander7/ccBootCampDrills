package lrn.cc.drill.current;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class DrillU2L06at2301241205 {

	@Test
	void testU2L06() {
		// DECLARE MISSING VARIABLES, AS NECESSARY TO make the lines below pass the test
		boolean oven = true & true & true;
		boolean magazine = true & true & false;
		boolean dust = false | true;
		boolean sky = 24 * 3 - 17 == 42;

		boolean film = true;
		boolean winter = false;
		boolean rush = true;
		boolean list = false;
		
		
		assertEquals(film, oven);
		assertEquals(winter, magazine);
		assertEquals(rush, dust);
		assertEquals(list, sky);
	}

}
