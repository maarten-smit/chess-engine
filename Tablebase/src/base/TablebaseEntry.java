package base;

public final class TablebaseEntry {
	//keys
	private final BoardState<?> boardState;
	private final boolean whiteToMove;
	
	//results
	private Result result;
	private int dtz;
	private int dtm;
	
	public TablebaseEntry(BoardState<?> boardState, boolean whiteToMove) {
		this.boardState = boardState;
		this.whiteToMove = whiteToMove;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getDtz() {
		return dtz;
	}

	public void setDtz(int dtz) {
		this.dtz = dtz;
	}

	public int getDtm() {
		return dtm;
	}

	public void setDtm(int dtm) {
		this.dtm = dtm;
	}

	public BoardState<?> getBoardState() {
		return boardState;
	}

	public boolean isWhiteToMove() {
		return whiteToMove;
	}
}
