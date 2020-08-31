package iteration1;

import java.util.Arrays;
import java.util.Collection;

public enum PieceType {
	WHITE_K('K', 0, 'K', true),
	WHITE_Q('Q', 1, 'Q', true),
	WHITE_R('R', 2, 'R', true),
	WHITE_B('B', 3, 'B', true),
	WHITE_N('N', 4, 'N', true),
	WHITE_P('\u0000', 5, 'P', true),
	BLACK_K('K', 6, 'k', false),
	BLACK_Q('Q', 7, 'q', false),
	BLACK_R('R', 8, 'r', false),
	BLACK_B('B', 9, 'b', false),
	BLACK_N('N', 10, 'n', false),
	BLACK_P('\u0000', 11, 'p', false);
	
	public final char notation;
	public final int value;
	public final char toPrint;
	public final boolean white;
	
	private PieceType(char notation, int value, char toPrint, boolean white) {
		this.notation = notation;
		this.value = value;
		this.toPrint = toPrint;
		this.white = white;
	}
	
	public static final Collection<PieceType> ORTH_PIECES = Arrays.asList(new PieceType[] {WHITE_Q, WHITE_R, BLACK_Q, BLACK_R});
	public static final Collection<PieceType> DIAG_PIECES = Arrays.asList(new PieceType[] {WHITE_Q, WHITE_B, BLACK_Q, BLACK_B});
	public static final Collection<PieceType> KNIGHT_MOVERS = Arrays.asList(new PieceType[] {WHITE_N, BLACK_N});
	public static final Collection<PieceType> KING_MOVERS = Arrays.asList(new PieceType[] {WHITE_K, BLACK_K});
	public static final Collection<PieceType> PAWNS = Arrays.asList(new PieceType[] {WHITE_P, BLACK_P});
}
