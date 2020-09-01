package base;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMoveStrategy extends MoveStrategy {

	private boolean white;
	
	public PawnMoveStrategy(BoardState<?> boardState, boolean white) {
		super(boardState);
		this.white = white;
	}

	//TODO refactor to readable code
	@Override
	public Collection<Square> getLegalMoves(Square source) {
		Collection<Square> legalMoves = new ArrayList<>(0);
		Direction general = white ? Direction.UP : Direction.DOWN;
		Square toPush = source.nextInDirection(general);
		if(boardState.getPiece(toPush) == null) {
			legalMoves.add(toPush);
			if(source.isPawnHome(white)) {
				Square toDouble = toPush.nextInDirection(general);
				if(boardState.getPiece(toDouble) == null) {
					legalMoves.add(toDouble);
				}
			}
		}
		if(source.getFileIndex() > 0) {
			Square toLeftCapture = source.nextInDirection(white ? Direction.UP_LEFT : Direction.DOWN_LEFT);
			PieceType potentialLeftCapture = boardState.getPiece(toLeftCapture);
			if(potentialLeftCapture != null && (potentialLeftCapture.isWhite() ^ white)) {
				legalMoves.add(toLeftCapture);
			}
		}
		if(source.getFileIndex() < source.getFileCount() - 1) {
			Square toRightCapture = source.nextInDirection(white ? Direction.UP_RIGHT : Direction.DOWN_RIGHT);
			PieceType potentialRightCapture = boardState.getPiece(toRightCapture);
			if(potentialRightCapture != null && (potentialRightCapture.isWhite() ^ white)) {
				legalMoves.add(toRightCapture);
			}
		}
		return legalMoves;
	}


}
