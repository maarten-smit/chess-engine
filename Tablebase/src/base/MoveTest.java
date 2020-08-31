package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import base.Move.MoveBuilder;

public class MoveTest {

	@Test
	public void test1() {
		Square source = Square.of(8, 8).file(4).rank(1).build();
		Square dest = Square.of(8, 8).file(4).rank(3).build();
		
		Move move = new MoveBuilder()
				.pieceType(PieceType.WHITE_P)
				.source(source)
				.dest(dest)
				.build();
		
		assertEquals("e2-e4", move.toString());
	}

	@Test
	public void test2() {
		Square source = Square.of(8, 8).file(2).rank(3).build();
		Square dest = Square.of(8, 8).file(5).rank(6).build();
		
		Move move = new MoveBuilder()
				.pieceType(PieceType.WHITE_B)
				.source(source)
				.dest(dest)
				.specialMove(Move.CAPTURES)
				.build();
		
		assertEquals("Bc4xf7", move.toString());
	}
}
