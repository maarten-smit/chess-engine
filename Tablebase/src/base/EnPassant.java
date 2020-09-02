package base;

public class EnPassant extends SpecialMoveType {

	@Override
	public void handle(BoardState<?> boardState, Square dest) {
		boardState.empty(dest.epCapture());
	}

}
