package base;

import java.util.Collection;

public class LegalMoveFinder {
	
	private PieceType currentPiece;
	private Square currentSquare;
	private BoardState<?> currentState;
	
	public LegalMoveFinder(Square currentSquare, BoardState<?> currentState) {
		this.currentSquare = currentSquare;
		this.currentState = currentState;
		currentPiece = currentState.getPiece(currentSquare);
	}
	
	public Collection<Square> getAll() {
		Collection<Square> all = null;
		if(currentPiece != null) {
			all = currentPiece.getMoveStrategy(currentState).getLegalMoves(currentSquare);
		}
		return all;
	}
}
