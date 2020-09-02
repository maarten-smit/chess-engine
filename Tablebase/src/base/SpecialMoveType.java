package base;

public abstract class SpecialMoveType {

	public abstract void handle(BoardState<?> boardState, Move currentMove);
	
}
