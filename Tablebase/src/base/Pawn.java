package base;

import java.util.ArrayList;
import java.util.Collection;

public class Pawn extends PieceType {

	public Pawn(boolean white) {
		super(white);
	}

	@Override
	public MoveStrategy getMoveStrategy(BoardState<?> boardState) {
		return new PawnMoveStrategy(boardState, isWhite());
	}

	@Override
	public Collection<Move> process(Square source, Square dest) {
		Collection<Move> moves = new ArrayList<>(1);
		if(dest.isPromotionSquare(isWhite())) {
			Collection<Promotion> promotions = Promotion.promotions(isWhite());
			for(Promotion p : promotions) {
				moves.add(new Move(this, source, dest, p));
			}
		} else {
			moves.add(new Move(this, source, dest));
		}
		return moves;
	}
	
	@Override
	public boolean canResultFromPromotion() {
		return false;
	}
	
	@Override
	public String doToString() {
		return "P";
	}
}
