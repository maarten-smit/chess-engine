package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import base.Move.MoveBuilder;

public class PieceBoardStateTest {

	@Test
	public void addPiece() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		Square source = Square.E1;
		Square dest = Square.F2;
		pbs.add(PieceType.WHITE_K, source);
		assertEquals(PieceType.WHITE_K, pbs.getPiece(source));

		MoveBuilder mb = new MoveBuilder();
		Move m = mb.pieceType(PieceType.WHITE_K).source(source).dest(dest).build();

		pbs.apply(m);
		assertEquals(PieceType.WHITE_K, pbs.getPiece(dest));
	}

	@Test
	public void startPos() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.startingPosition();
		System.out.println(pbs);
	}

	@Test
	public void scholarsMate() {
		PieceBoardState pbs = PieceBoardState.initial();

		pbs.apply(new Move(PieceType.WHITE_P, Square.E2, Square.E4));
		pbs.apply(new Move(PieceType.BLACK_P, Square.E7, Square.E5));
		pbs.apply(new Move(PieceType.WHITE_Q, Square.D1, Square.H5));
		pbs.apply(new Move(PieceType.BLACK_N, Square.B8, Square.C6));
		pbs.apply(new Move(PieceType.WHITE_B, Square.F1, Square.C4));
		pbs.apply(new Move(PieceType.BLACK_N, Square.G8, Square.F6));
		pbs.apply(new Move(PieceType.WHITE_Q, Square.H5, Square.F7));

		System.out.println(pbs);
	}

	@Test
	public void iterTest() {
		PieceBoardState pbs = new PieceBoardState(4, 4);
		for (Square sq : pbs) {
			System.out.println(sq);
		}
	}

	@Test
	public void checkTest() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.add(PieceType.WHITE_K, Square.E1);
		pbs.add(PieceType.BLACK_K, Square.E2);
		assertTrue(pbs.inCheck(true));
		assertTrue(pbs.inCheck(false));
	}

	@Test
	public void mateTest() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.add(PieceType.WHITE_K, Square.E1);
		pbs.add(PieceType.BLACK_K, Square.E3);
		pbs.add(PieceType.BLACK_R, Square.A1);
		assertTrue(pbs.inCheckMate(true));
	}

	@Test
	public void stalemateTest() {
		BoardState<?> pbs = new PieceBoardState(8, 8);
		pbs.add(PieceType.WHITE_K, Square.A1);
		pbs.add(PieceType.BLACK_K, Square.A3);
		pbs.add(PieceType.BLACK_R, Square.B6);
		assertTrue(pbs.inStaleMate(true));
	}

	@Test
	public void krkStalemates() {
		int counter = 0;
		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 64; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < 64; k++) {
					if (i == k || j == k)
						continue;
					BoardState<?> bs = new PieceBoardState(8, 8);
					bs.add(PieceType.WHITE_K, Square.of(bs).fileIndex(i / 8).rankIndex(i % 8).build());
					bs.add(PieceType.WHITE_N, Square.of(bs).fileIndex(j / 8).rankIndex(j % 8).build());
					bs.add(PieceType.BLACK_K, Square.of(bs).fileIndex(k / 8).rankIndex(k % 8).build());
					if (bs.isLegal(false)) {
						//counter++;
						if (bs.inStaleMate(false)) {
							System.out.println(bs);
							counter++;
						}
					}
					if(bs.isLegal(true)) {
						//counter++;
					}
				}
			}
		}
		System.out.println(counter);
	}
}
