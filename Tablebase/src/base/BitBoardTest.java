package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitBoardTest {
	
	@Test
	public void test() {
		int sourceIndex = 0;
		int destIndex = 63;
		
		BitBoard actual = new BitBoard(64);
		actual.populate(sourceIndex);

		BitBoard expected = new BitBoard(64);
		expected.populate(destIndex);
		
		actual.moveIfPossible(sourceIndex, destIndex);
		assertEquals(expected.getState(), actual.getState());
	}
	
}
