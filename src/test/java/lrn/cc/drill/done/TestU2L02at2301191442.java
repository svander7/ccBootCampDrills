package lrn.cc.drill.done;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestU2L02at2301191442 {

	@Test
	void testU2L03int() {
		// DECLARE VARIABLES HERE, AS NECESSARY TO make the lines below pass the test
		int bitter = 82;
		int maxInt = Integer.MAX_VALUE;
		int minInt = Integer.MIN_VALUE;
		int material = 3;
		int will = 5;
		int hope = 56;
		int pay = 2;
		
		assertTrue(Integer.class.isInstance(bitter));
		assertEquals(minInt, Integer.MIN_VALUE);
		assertEquals(maxInt, Integer.MAX_VALUE);
		assertEquals(15, material * will);
		assertEquals(54, hope - pay);
	}

}
