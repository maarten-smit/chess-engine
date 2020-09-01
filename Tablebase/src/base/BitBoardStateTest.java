package base;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitBoardStateTest {
	@Test
	public void dimensions() {
		BitBoardState bbs = new BitBoardState();
		assertEquals(8, bbs.getFileCount());
		assertEquals(8, bbs.getRankCount());
	}
}
