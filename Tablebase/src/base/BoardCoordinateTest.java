package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardCoordinateTest {

	@Test
	public void testCorners() {
		Square.of(8, 8).file(0).rank(0).build();
		Square.of(8, 8).file(7).rank(0).build();
		Square.of(8, 8).file(0).rank(7).build();
		Square.of(8, 8).file(7).rank(7).build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegFileOOB() {
		Square.of(8, 8).file(-1).rank(0).build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegRankOOB() {
		Square.of(8, 8).file(0).rank(-1).build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPosFileOOB() {
		Square.of(8, 8).file(8).rank(0).build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPosRankOOB() {
		Square.of(8, 8).file(0).rank(8).build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyFileCount() {
		Square.of(0, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyRankCount() {
		Square.of(8, 0);
	}
	
	@Test
	public void testIndices() {
		Square first = Square.of(8, 8).file(0).rank(7).build(); //a8
		assertEquals(0, first.getIndex());
		Square last = Square.of(8, 8).file(7).rank(0).build(); //h1
		assertEquals(63, last.getIndex());
	}
}
