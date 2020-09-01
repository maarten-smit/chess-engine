package base;

public class Knight extends PieceType {

	public Knight(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new KnightMoveStrategy(boardState);
	}
	
	@Override
	public String doToString() {
		return "N";
	}

}
