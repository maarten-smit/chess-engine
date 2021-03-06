package base;

public class Move {
	public static final int
		NONE = 0,
		CAPTURES = 1,
		CASTLES = 2,
		EN_PASSANT = 3,
		PROMOTION = 4,
		PROMOTION_CAPTURE = 5;
	
	private PieceType pieceType;
	
	private Square source;
	private Square dest;
	
	private SpecialMoveType specialMove;

	private Move() {};
	
	public Move(PieceType pieceType, Square source, Square dest) {
		this(pieceType, source, dest, null);
	}
	
	public Move(PieceType pieceType, Square source, Square dest, SpecialMoveType specialMove) {
		this.pieceType = pieceType;
		this.source = source;
		this.dest = dest;
		this.specialMove = specialMove;
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

	public SpecialMoveType getSpecialMove() {
		return specialMove;
	}

	private void setSpecialMove(SpecialMoveType specialMove) {
		this.specialMove = specialMove;
	}
	
	public boolean isDoublePawnPush() {
		boolean isDoublePawnPush = false;
		if(pieceType.isPawn()) {
			int distance = dest.getRankIndex() - source.getRankIndex();
			isDoublePawnPush = pieceType.isWhite() && distance == 2 ||
					!pieceType.isWhite() && distance == -2;
		}
		return isDoublePawnPush;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = super.equals(obj);
		if(!equals && obj instanceof Move) {
			Move that = (Move) obj;
			equals = this.getSource().equals(that.getSource()) &&
					this.getDest().equals(that.getDest());
		}
		return equals;
	}
	
	@Override
	public String toString() {
		//FIXME
		StringBuilder sb = new StringBuilder();
		sb.append(pieceType.toString());
		sb.append(source.toString());
		sb.append("-"); 
		sb.append(dest.toString());
		if(specialMove != null) {
			sb.append(specialMove);
		}
		return sb.toString();
	}
	
	public static class MoveBuilder {
		private PieceType pieceType;
		
		private Square source;
		private Square dest;
		
		private SpecialMoveType specialMove;
		
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
		
		public MoveBuilder specialMove(SpecialMoveType specialMove) {
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
		return false;
	}
}
