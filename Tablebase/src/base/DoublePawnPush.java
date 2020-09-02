package base;

public class DoublePawnPush extends SpecialMoveType {

	@Override
	public void handle(BoardState<?> boardState, Move currentMove) {
		Direction moveDir = currentMove.getPieceType().isWhite() ? Direction.UP : Direction.DOWN;
		boardState.setEPTarget(currentMove.getSource().nextInDirection(moveDir));
	}

}
