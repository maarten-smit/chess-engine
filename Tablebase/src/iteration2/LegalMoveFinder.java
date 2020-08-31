package iteration2;

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
		return currentPiece.getMoveStrategy(currentState).getLegalMoves(currentSquare);
	}
}
