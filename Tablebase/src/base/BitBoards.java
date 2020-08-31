package base;

public class BitBoards implements Board {

	private final int fileCount;
	private final int rankCount;

	private BitBoard[] bitBoards = new BitBoard[12];

	private BitBoards(int fileCount, int rankCount) {
		this.fileCount = fileCount;
		this.rankCount = rankCount;

		for (int i = 0; i < bitBoards.length; i++) {
			bitBoards[i] = new BitBoard(getFileCount() * getRankCount());
		}
	}

	public BitBoards() {
		this(8, 8);
	}

	@Override
	public int getFileCount() {
		return fileCount;
	}

	@Override
	public int getRankCount() {
		return rankCount;
	}

	@Override
	public void apply(Move move) {
		Square source = move.getSource();
		Square dest = move.getDest();
		if (source.fits(this) && dest.fits(this)) {
			int sourceIndex = source.getIndex();
			int destIndex = dest.getIndex();
			emptySquare(destIndex);
			movePiece(sourceIndex, destIndex);
		}
	}

	@Override
	public int getPiece(Square coordinate) {
		int result = -1;
		for (int i = 0; result < 0 && i < 12; i++) {
			if (bitBoards[i].isOccupied(coordinate)) {
				result = i;
			}
		}
		return result;
	}

	private void emptySquare(int targetIndex) {
		for (BitBoard board : bitBoards) {
			board.emptySquare(targetIndex);
		}
	}

	private void movePiece(int sourceIndex, int destIndex) {
		for (BitBoard board : bitBoards) {
			board.moveIfPossible(sourceIndex, destIndex);
		}
	}

	public void addPiece(int pieceType, Square coordinate) {
		bitBoards[pieceType].populate(coordinate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("----------\n");
		for (int i = getRankCount() - 1; i >= 0; i--) {
			sb.append("|");
			for (int j = 0; j < getFileCount(); j++) {
				Square coordinate = Square.of(this).file(j).rank(i).build();
				int pieceType = getPiece(coordinate);
				sb.append(PieceType.specificCode(pieceType));
			}
			sb.append("|\n");
		}
		sb.append("----------\n");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(FENReader.parseFEN("8/6p1/2p1q3/4P1p1/4Q1k1/8/6K1/8 b - - 1 1").toString());
	}
}
