package base;

import base.GameState.GameStateBuilder;

public class TablebaseReader implements Reader<TablebaseID> {
	public GameState parse(TablebaseID id) {
		
		BitBoards board = new BitBoards();
		StringBuilder pieceDist = new StringBuilder(id.getPieceDist());
		long placements = id.getPlacements();
		
		while(pieceDist.length() > 0) {
			int pieceType = PieceType.id(pieceDist.charAt(0));
			pieceDist.deleteCharAt(0);
			board.addPiece(pieceType, Square.of(board).index((int) placements % (1 << 6)).build());
			placements >>= 6;
		}
		
		GameStateBuilder gsb = new GameStateBuilder();
		gsb.boardState(board);
		gsb.castlingRights(0);
		gsb.legalEP(null);
		gsb.moveNumber(0);
		gsb.toMove((int) placements);
		gsb.plySinceLastZero(0);
		
		return gsb.build();
	}
	
	public static void main(String[] args) {
		long placements = 0; //white to move
		placements *= (1 << 6); placements += 48;
		placements *= (1 << 6); placements += 0;
		placements *= (1 << 6); placements += 63;
		placements *= (1 << 6); placements += 16;
		TablebaseID id = new TablebaseID("KRkn", placements);
		System.out.println(new TablebaseReader().parse(id));
		System.out.println(id);
	}
}
