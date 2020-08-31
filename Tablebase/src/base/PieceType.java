package base;

public class PieceType {
	public static final int
		WHITE_K = 0,
		WHITE_Q = 1,
		WHITE_R = 2,
		WHITE_B = 3,
		WHITE_N = 4,
		WHITE_P = 5,
		BLACK_K = 6,
		BLACK_Q = 7,
		BLACK_R = 8,
		BLACK_B = 9,
		BLACK_N = 10,
		BLACK_P = 11;
	
	public static String genericCode(int pieceType) {
		if(pieceType < 0 || pieceType >= 12) {
			throw new IllegalArgumentException("piece type unknown: " + pieceType);
		}
		switch(pieceType % 6) {
			case 0: return "K";
			case 1: return "Q";
			case 2: return "R";
			case 3: return "B";
			case 4: return "N";
			default: return "";
		}
	}
	
	public static String specificCode(int pieceType) {
		if(pieceType < -1 || pieceType >= 12) {
			throw new IllegalArgumentException("piece type unknown: " + pieceType);
		}
		switch(pieceType) {
			case 0: return "K";
			case 1: return "Q";
			case 2: return "R";
			case 3: return "B";
			case 4: return "N";
			case 5: return "P";
			case 6: return "k";
			case 7: return "q";
			case 8: return "r";
			case 9: return "b";
			case 10: return "n";
			case 11: return "p";
			default: return " ";
		}
	}
	
	public static int id(char pieceName) {
		switch(pieceName) {
			case 'K': return 0;
			case 'Q': return 1;
			case 'R': return 2;
			case 'B': return 3;
			case 'N': return 4;
			case 'P': return 5;
			case 'k': return 6;
			case 'q': return 7;
			case 'r': return 8;
			case 'b': return 9;
			case 'n': return 10;
			case 'p': return 11;
			default: return -1;	
		}
	}
}
