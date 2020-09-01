package base;

public class King extends PieceType {
	public King(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new KingMoveStrategy(boardState);
	}
	
	@Override
	public boolean canResultFromPromotion() {
		return false;
	}
	
	@Override
	public String doToString() {
		return "K";
	}
}
