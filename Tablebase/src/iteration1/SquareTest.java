package iteration1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SquareTest {
	@Test
	public void _toString() {
		Square sq = Square.of().fileIndex(4).rankIndex(3).build();
		assertEquals("e4", sq.toString());
	}

	@Test
	public void compare() {
		Square sq1 = Square.of().fileIndex(0).rankIndex(0).build();
		Square sq2 = Square.of().fileIndex(7).rankIndex(7).build();
		assertTrue(sq1.compareTo(sq2) > 0);
	}
	
	@Test
	public void index() {
		Square sq1 = Square.of().fileIndex(0).rankIndex(0).build();
		Square sq2 = Square.of().fileIndex(7).rankIndex(7).build();
		assertEquals(56, sq1.getIndex());
		assertEquals(7, sq2.getIndex());
	}
	
	@Test
	public void sortCompatible() {
		Square[] sqs = new Square[143];
		for(int i = 0; i < 143; i++) {
			sqs[i] = Square.of(13, 11).fileIndex(i / 11).rankIndex(i % 11).build();
		}
		Arrays.sort(sqs);
		for(int i = 0; i < 143; i++) {
			assertEquals(i, sqs[i].getIndex());
		}
	}
	
	@Test
	public void iter() {
		Square sq = Square.A1;
		for(Square newSq : sq.allInDirection(new Direction(1, 1))) {
			System.out.println(newSq);
		}
	}
}
