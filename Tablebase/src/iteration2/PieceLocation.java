package iteration2;

public class PieceLocation {
	private final PieceType piece;
	private final Square location;
	
	public PieceLocation(PieceType piece, Square location) {
		this.piece = piece;
		this.location = location;
	}

	public PieceType getPiece() {
		return piece;
	}

	public Square getLocation() {
		return location;
	}
	
	public PieceLocation move(Square target) {
		return new PieceLocation(piece, target);
	}
}
