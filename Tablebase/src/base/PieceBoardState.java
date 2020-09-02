package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PieceBoardState extends AbstractBoardState<PieceBoardState> implements Cloneable {

	private final int fileCount;
	private final int rankCount;
	
	private final List<PieceLocation> pieces;
	
	private Square epTarget;
	
	public PieceBoardState(int fileCount, int rankCount) {
		if(rankCount <= 2 && fileCount <= 2) {
			throw new IllegalArgumentException("board too small");
		}
		if(rankCount < 6) {
			System.out.println("Warning: rankCount might break e.p. rules");
		}
		this.fileCount = fileCount;
		this.rankCount = rankCount;
		pieces = new ArrayList<>();
	}
	
	@Override
	public PieceType getPiece(Square sq) {
		PieceType result = null;
		for(PieceLocation pl : pieces) {
			if(pl.getLocation().equals(sq)) {
				result = pl.getPiece();
				break;
			}
		}
		return result;
	}

	@Override
	public void apply(Move m) {
		empty(m.getDest());
		empty(m.getSource());
		add(m.getPieceType(), m.getDest());
		handleEP(m);
		if(m.getSpecialMove() != null) {
			m.getSpecialMove().handle(this, m);
		}
	}
	
	//TODO dirty, refactor pls
	private void handleEP(Move m) {
		if(m.getPieceType().isPawn() && m.getDest().equals(epTarget)) {
			new EnPassant().handle(this, m);
		}
	}

	@Override
	public int getRankCount() {
		return rankCount;
	}

	@Override
	public int getFileCount() {
		return fileCount;
	}

	@Override
	public Collection<Square> getSquares(PieceType type) {
		Collection<Square> squares = new ArrayList<>(0);
		for(PieceLocation pl : pieces) {
			if(pl.getPiece() == type) {
				squares.add(pl.getLocation());
			}
		}
		return squares;
	}

	@Override
	public void add(PieceType type, Square target) {
		pieces.add(new PieceLocation(type, target));
	}

	@Override
	public void empty(Square target) {
		PieceLocation toDelete = null;
		for(PieceLocation pl : pieces) {
			if(pl.getLocation().equals(target)) {
				toDelete = pl;
			}
		}
		if(toDelete != null) {
			pieces.remove(toDelete);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("--------------------------\n");
		for(int rankIndex = getRankCount() - 1; rankIndex >= 0; rankIndex--) {
			sb.append("|");
			for(int fileIndex = 0; fileIndex < getFileCount(); fileIndex++) {
				Square current = Square.of(this).fileIndex(fileIndex).rankIndex(rankIndex).build();
				PieceType pt = getPiece(current);
				if(pt == null) {
					sb.append("   ");
				} else {
					sb.append(" " + pt.toString() + " ");
				}
			}
			sb.append("|\n");
		}
		sb.append("--------------------------");
		return sb.toString();
	}
	
	public static PieceBoardState initial() {
		PieceBoardState pbs = new PieceBoardState(8, 8);
		pbs.startingPosition();
		return pbs;
	}

	@Override
	public boolean inCheck(boolean white) {
		boolean inCheck = false;
		PieceType king = white ? PieceType.WHITE_K : PieceType.BLACK_K;
		Square target = getSquares(king).iterator().next();
		for(PieceLocation pl : pieces) {
			Collection<Square> moves = new LegalMoveFinder(pl.getLocation(), this).getAll();
			if(moves.contains(target)) {
				inCheck = true;
				break;
			}
		}
		return inCheck;
	}

	@Override
	public boolean inCheckMate(boolean white) {
		return inCheck(white) && new GameState(this, white).getLegalMoves().isEmpty();
	}

	@Override
	public boolean inStaleMate(boolean white) {
		return !inCheck(white) && new GameState(this, white).getLegalMoves().isEmpty();
	}

	@Override
	public Square getEPTarget() {
		return epTarget;
	}

	@Override
	public void setEPTarget(Square target) {
		epTarget = target;
	}
	
	
}
