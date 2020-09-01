package base;

public class Bishop extends PieceType {

	public Bishop(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new DiagonalMoveStrategy(boardState);
	}
	
	@Override
	public String doToString() {
		return "B";
	}

}
