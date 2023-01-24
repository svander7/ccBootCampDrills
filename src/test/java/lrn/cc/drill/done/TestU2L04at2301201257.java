package lrn.cc.drill.done;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestU2L04at2301201257 {

	@Test
	void testU2L03int() {
		// DECLARE VARIABLES HERE, AS NECESSARY TO make the lines below pass the test
		long maxLong = 2147483647L;
		long minLong = Long.MIN_VALUE;
		long school = 12345678901l;
		long surgery =56l;
		int tour = 2;
		
		assertEquals(Integer.MIN_VALUE, Integer.MAX_VALUE + 1);
		assertTrue(Long.class.isInstance(1L));
		assertTrue(Long.class.isInstance(25L));
		assertEquals(minLong, Long.MIN_VALUE);
		assertEquals(maxLong, Integer.MAX_VALUE);
		assertEquals(12_345_678_901L, school);
		assertEquals(54L, surgery - tour);
	}

}
