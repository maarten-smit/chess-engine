package base;

public class Move {
	public static final int
		NONE = 0,
		CAPTURES = 1,
		CASTLES = 2,
		EN_PASSANT = 3;
	
	private PieceType pieceType;
	
	private Square source;
	private Square dest;
	
	private int specialMove;

	private Move() {};
	
	public Move(PieceType pieceType, Square source, Square dest) {
		this.pieceType = pieceType;
		this.source = source;
		this.dest = dest;
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}

	private void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public Square getSource() {
		return source;
	}

	private void setSource(Square source) {
		this.source = source;
	}

	public Square getDest() {
		return dest;
	}

	private void setDest(Square dest) {
		this.dest = dest;
	}

	public int getSpecialMove() {
		return specialMove;
	}

	private void setSpecialMove(int specialMove) {
		this.specialMove = specialMove;
	}
	
	@Override
	public String toString() {
		//FIXME
		StringBuilder sb = new StringBuilder();
		if(specialMove == CASTLES) {
			
		} else {
			sb.append(pieceType.toString());
			sb.append(source.toString());
			sb.append(specialMove == 0 ? "-" : "x"); 
			sb.append(dest.toString());
		}
		return sb.toString();
	}
	
	public static class MoveBuilder {
		private PieceType pieceType;
		
		private Square source;
		private Square dest;
		
		private int specialMove;
		
		public MoveBuilder pieceType(PieceType pieceType) {
			this.pieceType = pieceType;
			return this;
		}
		
		public MoveBuilder source(Square source) {
			this.source = source;
			return this;
		}
		
		public MoveBuilder dest(Square dest) {
			this.dest = dest;
			return this;
		}
		
		public MoveBuilder specialMove(int specialMove) {
			this.specialMove = specialMove;
			return this;
		}
		
		public Move build() {
			Move result = new Move();
			
			result.setPieceType(pieceType);
			result.setSource(source);
			result.setDest(dest);
			result.setSpecialMove(specialMove);
			
			return result;
		}
	}

	public boolean isZeroing() {
		return isPawnMove() || isCapture();
	}
	
	private boolean isPawnMove() {
		return pieceType == PieceType.WHITE_P || pieceType == PieceType.BLACK_P;
	}
	
	private boolean isCapture() {
		return specialMove % 2 == 1;
	}
}
