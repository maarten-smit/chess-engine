package iteration2;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ShortRangeMoveStrategy extends MoveStrategy {

	public ShortRangeMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	public Collection<Square> getLegalMoves(Square source) {
		Collection<Square> legalMoves = new ArrayList<>(0);
		for(Square potentialSquare : source.inBounds(getDeltas())) {
			PieceType potentialPiece = boardState.getPiece(potentialSquare);
			if(potentialPiece == null || potentialPiece.white ^ boardState.getPiece(potentialSquare).white) {
				legalMoves.add(potentialSquare);
			}
		}
		return legalMoves;
	}
	
	protected abstract int[][] getDeltas();
}
