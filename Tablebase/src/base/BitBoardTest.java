package base;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class BitBoardTest {
	
	@Test
	public void testInit() {
		BitBoard bb = new BitBoard();
		Collection<Square> occ = bb.getOccurrences();
		assertEquals(0, occ.size());
	}
}
