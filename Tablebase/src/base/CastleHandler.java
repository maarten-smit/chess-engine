package base;

import java.util.Collection;

public class CastleHandler {
	private GameState gameState;
	
	public CastleHandler(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void addLegalCastles(Collection<Move> legalMoves) {
		if(gameState.whiteToMove()) {
			if(gameState.isWhiteOORights()) {
				if(legalMoves.contains(new Move(null, Square.E1, Square.F1)) &&
						legalMoves.contains(new Move(null, Square.H1, Square.F1))) {
					legalMoves.add(new Move(PieceType.WHITE_K, Square.E1, Square.G1, new Castles()));
				}
			}
			if(gameState.isWhiteOOORights()) {
				if(legalMoves.contains(new Move(null, Square.E1, Square.D1)) &&
						legalMoves.contains(new Move(null, Square.A1, Square.D1))) {
					legalMoves.add(new Move(PieceType.WHITE_K, Square.E1, Square.C1, new Castles()));
				}
			}
		} else {
			if(gameState.isBlackOORights()) {
				if(legalMoves.contains(new Move(null, Square.E8, Square.F8)) &&
						legalMoves.contains(new Move(null, Square.H8, Square.F8))) {
					legalMoves.add(new Move(PieceType.BLACK_K, Square.E8, Square.G8, new Castles()));
				}
			}
			if(gameState.isBlackOOORights()) {
				if(legalMoves.contains(new Move(null, Square.E8, Square.D8)) &&
						legalMoves.contains(new Move(null, Square.A8, Square.D8))) {
					legalMoves.add(new Move(PieceType.WHITE_K, Square.E8, Square.C8, new Castles()));
				}
			}
		}
	}
}
