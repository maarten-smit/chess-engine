package base;

import java.util.Collection;
import java.util.Iterator;

public class BitBoardState implements BoardState<BitBoardState> {

	
	
	@Override
	public PieceType getPiece(Square sq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apply(Move m) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getRankCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFileCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Square> getSquares(PieceType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(PieceType type, Square target) {
		// TODO Auto-generated method stub
	}

	@Override
	public void empty(Square target) {
		// TODO Auto-generated method stub
	}

	@Override
	public Iterator<Square> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inCheck(boolean white) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inCheckMate(boolean white) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inStaleMate(boolean white) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Square getEPTarget() {
		// TODO Auto-generated method stub
		return null;
	}

}
