package base;

import base.GameState.GameStateBuilder;

/**
 * FEN = boardstate, toMove, castlingrights, legalEP, plysincelastzero, movenumber
 * @author Maarten
 *
 */

public class FENReader implements Reader<String> {
	
	public GameState parse(String fen) {
		String[] args = fen.split(" ");
		GameStateBuilder gsb = new GameStateBuilder();
		
		gsb.boardState(parsePosition(args[0]));
		gsb.toMove(parseToMove(args[1]));
		gsb.castlingRights(parseCastlingRights(args[2]));
		gsb.legalEP(parseEP(args[3]));
		gsb.plySinceLastZero(parsePlySinceZero(args[4]));
		gsb.moveNumber(parseMoveNumber(args[5]));
		
		return gsb.build();
	}
	

	private static BitBoards parsePosition(String str) {
		BitBoards result = new BitBoards();
		int currentIndex = 0;
		
		StringBuilder sb = new StringBuilder(str);
		while(sb.length() > 0) {
			char current = sb.charAt(0);
			sb.deleteCharAt(0);
			
			int pieceType = getPieceType(current);
			if(pieceType >= 0) {
				Square toPlace = Square.of(result)
						.file(currentIndex % result.getFileCount())
						.rank(result.getRankCount() - 1 - currentIndex / result.getFileCount())
						.build();
				result.addPiece(pieceType, toPlace);
				currentIndex++;
			} else if(current != '/') {
				int toSkip = current - '0';
				currentIndex += toSkip;
			}
		}
		return result;
	}
	
	private static int parseToMove(String str) {
		return str.charAt(0) == 'w' ? 0 : 1;
	}
	
	private static int parseCastlingRights(String str) {
		return 0; //TODO
	}
	
	private static Square parseEP(String str) {
		Square result = null;
		if(!str.equals("-")) {
			result = Square.of(8, 8) //TODO
					.file(str.charAt(0) - 'a')
					.rank(str.charAt(1) - '1')
					.build();
		}
		return result;
	}
	
	private static int parsePlySinceZero(String str) {
		return Integer.parseInt(str);
	}
	
	private static int parseMoveNumber(String str) {
		return Integer.parseInt(str);
	}
	
	private static int getPieceType(char code) {
		switch(code) {
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
