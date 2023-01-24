package lrn.cc.drill.done;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Test1at2301191222 {

	@Test
	void testU2L03int() {
		// DECLARE VARIABLES HERE, AS NECESSARY TO make the lines below pass the test
		int knee = 3;
		int minInt = Integer.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;
		int anger = 3;
		int officer = 5;
		int cold=55;
		int expression = 1;
		assertTrue(Integer.class.isInstance(knee));
		assertEquals(minInt, Integer.MIN_VALUE);
		assertEquals(maxInt, Integer.MAX_VALUE);
		assertEquals(15, anger * officer);
		assertEquals(54, cold - expression);
	}

}
