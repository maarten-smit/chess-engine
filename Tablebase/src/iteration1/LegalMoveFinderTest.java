package iteration1;

import org.junit.Test;

public class LegalMoveFinderTest {

	@Test
	public void freeQueen() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.add(PieceType.WHITE_Q, Square.E5);
		
		LegalMoveFinder lmf = new LegalMoveFinder(Square.E5, pbs);
		System.out.println(lmf.getAll());
	}

	@Test
	public void initQueen() {
		PieceBoardState pbs = PieceBoardState.initial();
		pbs.apply(new Move(PieceType.WHITE_P, Square.E2, Square.E4));
		pbs.apply(new Move(PieceType.BLACK_P, Square.E7, Square.E5));
		pbs.apply(new Move(PieceType.WHITE_Q, Square.D1, Square.H5));
		System.out.println(new LegalMoveFinder(Square.H5, pbs).getAll());
	}
	
	@Test
	public void freeKnight() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.add(PieceType.WHITE_N, Square.E5);
		
		System.out.println(new LegalMoveFinder(Square.E5, pbs).getAll());
	}
	
	@Test
	public void initKnight() {
		PieceBoardState pbs = PieceBoardState.initial();
		pbs.apply(new Move(PieceType.WHITE_P, Square.E2, Square.E4));
		System.out.println(new LegalMoveFinder(Square.G1, pbs).getAll());
	}
}
