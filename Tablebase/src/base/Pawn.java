package base;

public class Pawn extends PieceType {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new PawnMoveStrategy(boardState, isWhite());
	}

	@Override
	public String doToString() {
		return "P";
	}
}
