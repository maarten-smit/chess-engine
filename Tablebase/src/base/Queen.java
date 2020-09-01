package base;

public class Queen extends PieceType {

	public Queen(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new QueenMoveStrategy(boardState);
	}
	
	@Override
	public String doToString() {
		return "Q";
	}

}
