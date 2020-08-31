package base;

import org.junit.Test;

import base.Move.MoveBuilder;

public class GameStateTest {

	@Test
	public void test() {
		GameState init = new FENReader().parse("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
		Move firstMove = new MoveBuilder().pieceType(PieceType.WHITE_P)
				.source(Square.of(8, 8).file(4).rank(1).build())
				.dest(Square.of(8, 8).file(4).rank(3).build())
				.build();
		
		Move secondMove = new MoveBuilder().pieceType(PieceType.BLACK_P)
				.source(Square.of(8, 8).file(4).rank(6).build())
				.dest(Square.of(8, 8).file(4).rank(4).build())
				.build();
		
		Move thirdMove = new MoveBuilder().pieceType(PieceType.WHITE_Q)
				.source(Square.of(8, 8).file(3).rank(0).build())
				.dest(Square.of(8, 8).file(7).rank(4).build())
				.build();
		
		Move fourthMove = new MoveBuilder().pieceType(PieceType.BLACK_N)
				.source(Square.of(8, 8).file(1).rank(7).build())
				.dest(Square.of(8, 8).file(2).rank(5).build())
				.build();
		
		Move fifthMove = new MoveBuilder().pieceType(PieceType.WHITE_B)
				.source(Square.of(8, 8).file(5).rank(0).build())
				.dest(Square.of(8, 8).file(2).rank(3).build())
				.build();
		
		Move sixthMove = new MoveBuilder().pieceType(PieceType.BLACK_N)
				.source(Square.of(8, 8).file(6).rank(7).build())
				.dest(Square.of(8, 8).file(5).rank(5).build())
				.build();
		
		Move seventhMove = new MoveBuilder().pieceType(PieceType.WHITE_Q)
				.source(Square.of(8, 8).file(7).rank(4).build())
				.dest(Square.of(8, 8).file(5).rank(6).build())
				.build();
		System.out.println(init);
		init.apply(firstMove);
		init.apply(secondMove);
		init.apply(thirdMove);
		init.apply(fourthMove);
		init.apply(fifthMove);
		init.apply(sixthMove);
		init.apply(seventhMove);
		System.out.println(init);
	}

}
