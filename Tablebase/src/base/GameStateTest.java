package base;

import java.util.List;
import java.util.Random;

import org.junit.Test;

public class GameStateTest {

	@Test
	public void init() {
		Random r = new Random();
		GameState gs = new GameState(PieceBoardState.initial(), true);
		List<Move> legalMoves;
		for(int i = 0; i < 500; i++) {
			
			legalMoves = gs.getLegalMoves();
			System.out.println(gs.getBoardState());
			gs.apply(legalMoves.get(r.nextInt(legalMoves.size())));
		}
	}

	@Test
	public void krkn() {
		BoardState<?> bs = new PieceBoardState(8, 8);
		bs.add(PieceType.WHITE_K, Square.C7);
		bs.add(PieceType.WHITE_R, Square.G2);
		bs.add(PieceType.BLACK_K, Square.A6);
		bs.add(PieceType.BLACK_N, Square.B7);
		GameState gs = new GameState(bs, true);
		System.out.println(gs.getLegalMoves());
	}
	
	@Test
	public void promo() {
		BoardState<?> bs = new PieceBoardState(8, 8);
		bs.add(PieceType.WHITE_P, Square.E7);
		bs.add(PieceType.WHITE_K, Square.H1);
		bs.add(PieceType.BLACK_K, Square.H8);
		GameState gs = new GameState(bs, true);
		System.out.println(gs.getLegalMoves());
	}
	
	@Test
	public void kings() {
		BoardState<?> bs = new PieceBoardState(8, 8);
		bs.add(PieceType.WHITE_K, Square.E2);
		bs.add(PieceType.BLACK_K, Square.E3);
		bs.add(PieceType.WHITE_N, Square.C2);
		bs.add(PieceType.BLACK_N, Square.B4);
		System.out.println(new GameState(bs, true).getLegalMoves());
	}
}
