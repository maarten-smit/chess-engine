package iteration1;

import java.util.ArrayList;
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
		Collection<Square> allMoves = new ArrayList<>(0);
		if(PieceType.ORTH_PIECES.contains(currentPiece)) {
			allMoves.addAll(getOrthogonal());
		}
		if(PieceType.DIAG_PIECES.contains(currentPiece)) {
			allMoves.addAll(getDiagonal());
		}
		if(PieceType.KING_MOVERS.contains(currentPiece)) {
			allMoves.addAll(getFrom(currentSquare.kingMoves()));
		}
		if(PieceType.KNIGHT_MOVERS.contains(currentPiece)) {
			allMoves.addAll(getFrom(currentSquare.knightMoves()));
		}
		if(PieceType.PAWNS.contains(currentPiece)) {
			//TODO implement P
		}
		return allMoves;
	}
	
	private Collection<Square> getOrthogonal() {
		Collection<Square> orthMoves = new ArrayList<>(0);
		orthMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.UP)));
		orthMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.DOWN)));
		orthMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.LEFT)));
		orthMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.RIGHT)));
		return orthMoves;
	}
	
	private Collection<Square> getDiagonal() {
		Collection<Square> diagMoves = new ArrayList<>(0);
		diagMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.UP_LEFT)));
		diagMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.UP_RIGHT)));
		diagMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.DOWN_LEFT)));
		diagMoves.addAll(getInDirection(currentSquare.allInDirection(Direction.DOWN_RIGHT)));
		return diagMoves;
		
	}
	
	//TODO refactor following 2 methods with strategy
	private Collection<Square> getInDirection(Iterable<Square> allSquares) {
		Collection<Square> result = new ArrayList<>(0);
		for(Square potentialSquare : allSquares) {
			PieceType potentialPiece = currentState.getPiece(potentialSquare);
			if(potentialPiece == null) {
				result.add(potentialSquare);
			} else {
				if(potentialPiece.white ^ currentPiece.white) {
					result.add(potentialSquare);
				}
				break;
			}
		}
		return result;
	}
	
	private Collection<Square> getFrom(Iterable<Square> allSquares) {
		Collection<Square> result = new ArrayList<>(0);
		for(Square potentialSquare : allSquares) {
			PieceType potentialPiece = currentState.getPiece(potentialSquare);
			if(potentialPiece == null || potentialPiece.white ^ currentPiece.white) {
				result.add(potentialSquare);
			}
		}
		return result;
	}
}
