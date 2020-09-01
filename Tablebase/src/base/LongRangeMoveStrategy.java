package base;

import java.util.ArrayList;
import java.util.Collection;

public abstract class LongRangeMoveStrategy extends MoveStrategy {
	
	public LongRangeMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}
	
	@Override
	public Collection<Square> getLegalMoves(Square source) {
		Collection<Square> legalMoves = new ArrayList<>(0);
		for(Direction direction : getDirections()) {
			legalMoves.addAll(getLegalMovesInDirection(source, direction));
		}
		return legalMoves;
	}
	
	private Collection<Square> getLegalMovesInDirection(Square source, Direction direction) {
		Collection<Square> legalMoves = new ArrayList<>(0);
		for(Square potentialSquare : source.getAllSquaresInDirection(direction)) {
			PieceType potentialCapture = boardState.getPiece(potentialSquare);
			if(potentialCapture == null) {
				legalMoves.add(potentialSquare);
			} else {
				if(potentialCapture.isWhite() != boardState.getPiece(source).isWhite()) {
					legalMoves.add(potentialSquare);
				}
				break;
			}
		}
		return legalMoves;
	}
	
	public abstract Collection<Direction> getDirections();
}
