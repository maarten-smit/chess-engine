package iteration2;

public abstract class PieceType {
	public static final PieceType WHITE_K = new King(true);
	public static final PieceType WHITE_Q = new Queen(true);
	public static final PieceType WHITE_R = new Rook(true);
	public static final PieceType WHITE_B = new Bishop(true);
	public static final PieceType WHITE_N = new Knight(true);
	public static final PieceType WHITE_P = new Pawn(true);
	public static final PieceType BLACK_K = new King(false);
	public static final PieceType BLACK_Q = new Queen(false);
	public static final PieceType BLACK_R = new Rook(false);
	public static final PieceType BLACK_B = new Bishop(false);
	public static final PieceType BLACK_N = new Knight(false);
	public static final PieceType BLACK_P = new Pawn(false);
	
	public final boolean white;
	
	public PieceType(boolean white) {
		this.white = white;
	}
	
	@Override
	public final String toString() {
		return white ? doToString() : doToString().toLowerCase();
	}
	
	public abstract MoveStrategy getMoveStrategy(BoardState<?> boardState);
	
	public abstract String doToString();
}
