package base;

import java.util.Iterator;

public abstract class AbstractBoardState<T extends AbstractBoardState<T>> implements BoardState<T> {
	public final void empty() {
		for(Square sq : this) {
			empty(sq);
		}
	}
	
	public final void startingPosition() {
		empty();
		add(PieceType.WHITE_R, Square.A1);
		add(PieceType.WHITE_N, Square.B1);
		add(PieceType.WHITE_B, Square.C1);
		add(PieceType.WHITE_Q, Square.D1);
		add(PieceType.WHITE_K, Square.E1);
		add(PieceType.WHITE_B, Square.F1);
		add(PieceType.WHITE_N, Square.G1);
		add(PieceType.WHITE_R, Square.H1);
		add(PieceType.WHITE_P, Square.A2);
		add(PieceType.WHITE_P, Square.B2);
		add(PieceType.WHITE_P, Square.C2);
		add(PieceType.WHITE_P, Square.D2);
		add(PieceType.WHITE_P, Square.E2);
		add(PieceType.WHITE_P, Square.F2);
		add(PieceType.WHITE_P, Square.G2);
		add(PieceType.WHITE_P, Square.H2);
		add(PieceType.BLACK_R, Square.A8);
		add(PieceType.BLACK_N, Square.B8);
		add(PieceType.BLACK_B, Square.C8);
		add(PieceType.BLACK_Q, Square.D8);
		add(PieceType.BLACK_K, Square.E8);
		add(PieceType.BLACK_B, Square.F8);
		add(PieceType.BLACK_N, Square.G8);
		add(PieceType.BLACK_R, Square.H8);
		add(PieceType.BLACK_P, Square.A7);
		add(PieceType.BLACK_P, Square.B7);
		add(PieceType.BLACK_P, Square.C7);
		add(PieceType.BLACK_P, Square.D7);
		add(PieceType.BLACK_P, Square.E7);
		add(PieceType.BLACK_P, Square.F7);
		add(PieceType.BLACK_P, Square.G7);
		add(PieceType.BLACK_P, Square.H7);
	}
	
	public Iterator<Square> iterator() {
		return new Iterator<Square>() {

			private Square current;
			
			@Override
			public boolean hasNext() {
				return current == null || current.getRankIndex() > 0
						|| current.getFileIndex() < getFileCount() - 1;
			}

			@Override
			public Square next() {
				Square.SquareBuilder sb = Square.of(AbstractBoardState.this);
				if(current == null) {
					sb.fileIndex(0);
					sb.rankIndex(getRankCount() - 1);
				} else if(current.getFileIndex() == getFileCount() - 1) {
					sb.fileIndex(0);
					sb.rankIndex(current.getRankIndex() - 1);
				} else {
					sb.fileIndex(current.getFileIndex() + 1);
					sb.rankIndex(current.getRankIndex());
				}
				return current = sb.build();
			}

		};
	}
}
