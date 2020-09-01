package base;

import java.util.Collection;

public abstract class MoveStrategy {
	
	protected BoardState<?> boardState;
	
	public MoveStrategy(BoardState<?> boardState) {
		this.boardState = boardState;
	}
	
	public abstract Collection<Square> getLegalMoves(Square source);
}
