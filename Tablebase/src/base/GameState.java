package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameState {
	
	private BoardState<?> boardState;
	private boolean whiteToMove;
	
	private boolean whiteOORights, whiteOOORights, blackOORights, blackOOORights;
	
	public GameState(BoardState<?> boardState, boolean whiteToMove) {
		this.boardState = boardState;
		this.whiteToMove = whiteToMove;
	}
	
	public boolean whiteToMove() {
		return whiteToMove;
	}
	
	public BoardState<?> getBoardState() {
		return boardState;
	}
	
	public void apply(Move m) {
		boardState.apply(m);
		whiteToMove = !whiteToMove;
	}
	
	public List<Move> getLegalMoves() {
		List<Move> potentialMoves = new ArrayList<>(0);
		for(Square source : boardState) {
			PieceType current = boardState.getPiece(source);
			if(current != null && current.isWhite() == whiteToMove) {
				Collection<Square> legalSquares = new LegalMoveFinder(source, boardState).getAll();
				for(Square dest : legalSquares) {
					potentialMoves.addAll(current.process(source, dest));
				}
			}
		}
		if(!boardState.inCheck(whiteToMove)) {
			new CastleHandler(this).addLegalCastles(potentialMoves);
		}
		List<Move> illegalMoves = new ArrayList<>(0);
		for(Move move : potentialMoves) {
			//remember potential capture
			PieceType captured = boardState.getPiece(move.getDest());
			boardState.apply(move);
			if(boardState.inCheck(whiteToMove)) {
				illegalMoves.add(move);
			}
			//undo
			boardState.apply(new Move(move.getPieceType(), move.getDest(), move.getSource()));
			if(captured != null) {
				boardState.add(captured, move.getDest());
			}
		}
		potentialMoves.removeAll(illegalMoves);
		return potentialMoves;
	}
	
	public boolean isLegal() {
		return !boardState.inCheck(whiteToMove);
	}
	
	public void setCastlingRights(int value) {
		whiteOORights = (value & 1) == 1;
		whiteOOORights = (value & 2) == 2;
		blackOORights = (value & 4) == 4;
		blackOOORights = (value & 8) == 8;
	}
	
	public boolean isWhiteOORights() {
		return whiteOORights;
	}

	public boolean isWhiteOOORights() {
		return whiteOOORights;
	}

	public boolean isBlackOORights() {
		return blackOORights;
	}

	public boolean isBlackOOORights() {
		return blackOOORights;
	}

	public static GameState initial() {
		GameState gs = new GameState(PieceBoardState.initial(), true);
		gs.setCastlingRights(0b1111);
		return gs;
	}
}
