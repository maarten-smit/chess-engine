package iteration2;

public class Pawn extends PieceType {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doToString() {
		return "P";
	}
}
