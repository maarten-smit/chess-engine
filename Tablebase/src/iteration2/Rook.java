package iteration2;

public class Rook extends PieceType {

	public Rook(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new OrthogonalMoveStrategy(boardState);
	}
	
	@Override
	public String doToString() {
		return "R";
	}

}
