package base;

public class GameState {

	private Board boardState;
	private int toMove;
	private int castlingRights;
	private Square legalEP;
	private int plySinceLastZero;
	private int moveNumber;

	private GameState() {
	}
	
	public void apply(Move move) {
		boardState.apply(move);
		plySinceLastZero = move.isZeroing() ? 0 : plySinceLastZero + 1;
		moveNumber += toMove;
		toMove = 1 - toMove;
	}
	
	public Board getBoardState() {
		return boardState;
	}

	public int getToMove() {
		return toMove;
	}

	public int getCastlingRights() {
		return castlingRights;
	}

	public Square getLegalEP() {
		return legalEP;
	}

	public int getPlySinceLastZero() {
		return plySinceLastZero;
	}

	public int getMoveNumber() {
		return moveNumber;
	}

	private void setBoardState(Board boardState) {
		this.boardState = boardState;
	}

	private void setToMove(int toMove) {
		this.toMove = toMove;
	}

	private void setCastlingRights(int castlingRights) {
		this.castlingRights = castlingRights;
	}

	private void setLegalEP(Square legalEP) {
		this.legalEP = legalEP;
	}

	private void setPlySinceLastZero(int plySinceLastZero) {
		this.plySinceLastZero = plySinceLastZero;
	}

	private void setMoveNumber(int moveNumber) {
		this.moveNumber = moveNumber;
	}

	public static class GameStateBuilder {
		private Board boardState;
		private int toMove;
		private int castlingRights;
		private Square legalEP;
		private int plySinceLastZero;
		private int moveNumber;

		public void boardState(Board boardState) {
			this.boardState = boardState;
		}

		public void toMove(int toMove) {
			if(toMove != 0 && toMove != 1) {
				throw new IllegalArgumentException("illegal tomove");
			}
			this.toMove = toMove;
		}

		public void castlingRights(int castlingRights) {
			this.castlingRights = castlingRights;
		}

		public void legalEP(Square legalEP) {
			this.legalEP = legalEP;
		}

		public void plySinceLastZero(int plySinceLastZero) {
			this.plySinceLastZero = plySinceLastZero;
		}

		public void moveNumber(int moveNumber) {
			this.moveNumber = moveNumber;
		}
		
		public GameState build() {
			GameState result = new GameState();
			setParams(result);
			return result;
		}
		
		private void setParams(GameState model) {
			model.setBoardState(boardState);
			model.setToMove(toMove);
			model.setCastlingRights(castlingRights);
			model.setLegalEP(legalEP);
			model.setPlySinceLastZero(plySinceLastZero);
			model.setMoveNumber(moveNumber);
		}

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(boardState.toString());
		sb.append(toMove == 0 ? "white " : "black ").append("to move");
		return sb.toString();
	}

}
