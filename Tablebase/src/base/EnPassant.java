package base;

public class EnPassant extends SpecialMoveType {

	@Override
	public void handle(BoardState<?> boardState, Move currentMove) {
		boardState.empty(currentMove.getDest().epCapture());
	}

	@Override
	public String toString() {
		return "e.p.";
	}
}
