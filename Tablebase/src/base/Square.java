package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class Square implements Comparable<Square> {

	// NOTE: only use class constants for 8x8 board!
	public static final Square A1 = of(8, 8).fileIndex(0).rankIndex(0).build();
	public static final Square A2 = of(8, 8).fileIndex(0).rankIndex(1).build();
	public static final Square A3 = of(8, 8).fileIndex(0).rankIndex(2).build();
	public static final Square A4 = of(8, 8).fileIndex(0).rankIndex(3).build();
	public static final Square A5 = of(8, 8).fileIndex(0).rankIndex(4).build();
	public static final Square A6 = of(8, 8).fileIndex(0).rankIndex(5).build();
	public static final Square A7 = of(8, 8).fileIndex(0).rankIndex(6).build();
	public static final Square A8 = of(8, 8).fileIndex(0).rankIndex(7).build();
	public static final Square B1 = of(8, 8).fileIndex(1).rankIndex(0).build();
	public static final Square B2 = of(8, 8).fileIndex(1).rankIndex(1).build();
	public static final Square B3 = of(8, 8).fileIndex(1).rankIndex(2).build();
	public static final Square B4 = of(8, 8).fileIndex(1).rankIndex(3).build();
	public static final Square B5 = of(8, 8).fileIndex(1).rankIndex(4).build();
	public static final Square B6 = of(8, 8).fileIndex(1).rankIndex(5).build();
	public static final Square B7 = of(8, 8).fileIndex(1).rankIndex(6).build();
	public static final Square B8 = of(8, 8).fileIndex(1).rankIndex(7).build();
	public static final Square C1 = of(8, 8).fileIndex(2).rankIndex(0).build();
	public static final Square C2 = of(8, 8).fileIndex(2).rankIndex(1).build();
	public static final Square C3 = of(8, 8).fileIndex(2).rankIndex(2).build();
	public static final Square C4 = of(8, 8).fileIndex(2).rankIndex(3).build();
	public static final Square C5 = of(8, 8).fileIndex(2).rankIndex(4).build();
	public static final Square C6 = of(8, 8).fileIndex(2).rankIndex(5).build();
	public static final Square C7 = of(8, 8).fileIndex(2).rankIndex(6).build();
	public static final Square C8 = of(8, 8).fileIndex(2).rankIndex(7).build();
	public static final Square D1 = of(8, 8).fileIndex(3).rankIndex(0).build();
	public static final Square D2 = of(8, 8).fileIndex(3).rankIndex(1).build();
	public static final Square D3 = of(8, 8).fileIndex(3).rankIndex(2).build();
	public static final Square D4 = of(8, 8).fileIndex(3).rankIndex(3).build();
	public static final Square D5 = of(8, 8).fileIndex(3).rankIndex(4).build();
	public static final Square D6 = of(8, 8).fileIndex(3).rankIndex(5).build();
	public static final Square D7 = of(8, 8).fileIndex(3).rankIndex(6).build();
	public static final Square D8 = of(8, 8).fileIndex(3).rankIndex(7).build();
	public static final Square E1 = of(8, 8).fileIndex(4).rankIndex(0).build();
	public static final Square E2 = of(8, 8).fileIndex(4).rankIndex(1).build();
	public static final Square E3 = of(8, 8).fileIndex(4).rankIndex(2).build();
	public static final Square E4 = of(8, 8).fileIndex(4).rankIndex(3).build();
	public static final Square E5 = of(8, 8).fileIndex(4).rankIndex(4).build();
	public static final Square E6 = of(8, 8).fileIndex(4).rankIndex(5).build();
	public static final Square E7 = of(8, 8).fileIndex(4).rankIndex(6).build();
	public static final Square E8 = of(8, 8).fileIndex(4).rankIndex(7).build();
	public static final Square F1 = of(8, 8).fileIndex(5).rankIndex(0).build();
	public static final Square F2 = of(8, 8).fileIndex(5).rankIndex(1).build();
	public static final Square F3 = of(8, 8).fileIndex(5).rankIndex(2).build();
	public static final Square F4 = of(8, 8).fileIndex(5).rankIndex(3).build();
	public static final Square F5 = of(8, 8).fileIndex(5).rankIndex(4).build();
	public static final Square F6 = of(8, 8).fileIndex(5).rankIndex(5).build();
	public static final Square F7 = of(8, 8).fileIndex(5).rankIndex(6).build();
	public static final Square F8 = of(8, 8).fileIndex(5).rankIndex(7).build();
	public static final Square G1 = of(8, 8).fileIndex(6).rankIndex(0).build();
	public static final Square G2 = of(8, 8).fileIndex(6).rankIndex(1).build();
	public static final Square G3 = of(8, 8).fileIndex(6).rankIndex(2).build();
	public static final Square G4 = of(8, 8).fileIndex(6).rankIndex(3).build();
	public static final Square G5 = of(8, 8).fileIndex(6).rankIndex(4).build();
	public static final Square G6 = of(8, 8).fileIndex(6).rankIndex(5).build();
	public static final Square G7 = of(8, 8).fileIndex(6).rankIndex(6).build();
	public static final Square G8 = of(8, 8).fileIndex(6).rankIndex(7).build();
	public static final Square H1 = of(8, 8).fileIndex(7).rankIndex(0).build();
	public static final Square H2 = of(8, 8).fileIndex(7).rankIndex(1).build();
	public static final Square H3 = of(8, 8).fileIndex(7).rankIndex(2).build();
	public static final Square H4 = of(8, 8).fileIndex(7).rankIndex(3).build();
	public static final Square H5 = of(8, 8).fileIndex(7).rankIndex(4).build();
	public static final Square H6 = of(8, 8).fileIndex(7).rankIndex(5).build();
	public static final Square H7 = of(8, 8).fileIndex(7).rankIndex(6).build();
	public static final Square H8 = of(8, 8).fileIndex(7).rankIndex(7).build();

	private int fileCount;
	private int rankCount;
	private int fileIndex;
	private int rankIndex;

	private int index;

	private Square() {
	}

	public int getFileCount() {
		return fileCount;
	}

	public int getRankCount() {
		return rankCount;
	}

	public int getFileIndex() {
		return fileIndex;
	}

	public int getRankIndex() {
		return rankIndex;
	}

	public int getIndex() {
		return index;
	}

	private void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	private void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}

	private void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}

	private void setRankIndex(int rankIndex) {
		this.rankIndex = rankIndex;
	}

	private void calculateIndex() {
		this.index = (getRankCount() - 1 - getRankIndex()) * getFileCount() + getFileIndex();
	}

	public boolean isPawnHome(boolean white) {
		return white && getRankIndex() == 1 ||
				!white && getRankIndex() == getRankCount() - 2;
	}
	
	public boolean isPromotionSquare(boolean white) {
		return white && getRankIndex() == getRankCount() - 1 ||
				!white && getRankIndex() == 0;
	}
	
	public boolean isKingHome(boolean white) {
		//TODO test castles with custom board sizes
		return white && equals(Square.E1) ||
				!white && equals(Square.E8);
	}
	
	public Square epCapture() {
		Square epCapture = null;
		if(getRankIndex() == 2) {
			epCapture = nextInDirection(Direction.UP);
		} else if(getRankIndex() == getRankCount() - 3) {
			epCapture = nextInDirection(Direction.DOWN);
		} else {
			throw new IllegalStateException("not an ep target");
		}
		return epCapture;
	}
	
	@Override
	public String toString() {
		return getFileCount() <= 26 ? toAlgebraic() : toCoordinate();
	}

	public String toAlgebraic() {
		if (getFileCount() > 26) {
			throw new IllegalStateException("algebraic notation not supported for fileCount " + getFileCount());
		}
		StringBuilder sb = new StringBuilder();
		sb.append((char) (getFileIndex() + 'a'));
		sb.append(Integer.toString(getRankIndex() + 1));
		return sb.toString();
	}

	public String toCoordinate() {
		return "(" + getFileIndex() + ", " + getRankIndex() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = super.equals(obj);
		if (!equals && obj instanceof Square) {
			Square that = (Square) obj;
			equals = this.getFileIndex() == that.getFileIndex() && this.getRankIndex() == that.getRankIndex();
		}
		return equals;
	}

	@Override
	public int compareTo(Square that) {
		int compareTo = that.getRankIndex() - this.getRankIndex();
		if (compareTo == 0) {
			compareTo = this.getFileIndex() - that.getFileIndex();
		}
		return compareTo;
	}

	public boolean hasNextInDirection(Direction d) {
		int potentialFileIndex = getFileIndex() + d.getFileDisplacement();
		int potentialRankIndex = getRankIndex() + d.getRankDisplacement();
		return potentialFileIndex >= 0 && potentialFileIndex < getFileCount()
				&& potentialRankIndex >= 0 && potentialRankIndex < getRankCount();
	}
	
	public Square nextInDirection(Direction d) {
		return of(getFileCount(), getRankCount())
				.fileIndex(getFileIndex() + d.getFileDisplacement())
				.rankIndex(getRankIndex() + d.getRankDisplacement())
				.build();
	}
	
	public Iterable<Square> getAllSquaresInDirection(Direction d) {
		return new SquareSequence(d);
	}
	
	public Collection<Square> inBounds(int[][] deltas) {
		Collection<Square> dests = new ArrayList<>(0);
		for(int[] delta : deltas) {
			int newFileIndex = fileIndex + delta[0];
			int newRankIndex = rankIndex + delta[1];
			if(newFileIndex < 0 || newFileIndex >= getFileCount()) {
				continue;
			}
			if(newRankIndex < 0 || newRankIndex >= getRankCount()) {
				continue;
			}
			dests.add(of(getFileCount(), getRankCount()).fileIndex(newFileIndex).rankIndex(newRankIndex).build());
		}
		return dests;
	}
	
	public static SquareBuilder of(int fileCount, int rankCount) {
		return new SquareBuilder(fileCount, rankCount);
	}

	public static SquareBuilder of() {
		return of(8, 8);
	}

	public static SquareBuilder of(BoardState<?> bs) {
		return of(bs.getFileCount(), bs.getRankCount());
	}

	public static class SquareBuilder {

		private int fileCount;
		private int rankCount;
		private int fileIndex;
		private int rankIndex;

		private SquareBuilder(int fileCount, int rankCount) {
			if (fileCount <= 0) {
				throw new IllegalArgumentException("illegal fileCount: " + fileCount);
			}
			if (rankCount <= 0) {
				throw new IllegalArgumentException("illegal rankCount: " + rankCount);
			}
			this.fileCount = fileCount;
			this.rankCount = rankCount;
		}

		public SquareBuilder fileIndex(int fileIndex) {
			if (fileIndex < 0 || fileIndex >= fileCount) {
				throw new IllegalArgumentException("fileIndex out of bounds: " + fileIndex);
			}
			this.fileIndex = fileIndex;
			return this;
		}

		public SquareBuilder rankIndex(int rankIndex) {
			if (rankIndex < 0 || rankIndex >= rankCount) {
				throw new IllegalArgumentException("rankIndex out of bounds: " + rankIndex);
			}
			this.rankIndex = rankIndex;
			return this;
		}

		public Square build() {
			Square build = new Square();
			build.setFileCount(fileCount);
			build.setRankCount(rankCount);
			build.setFileIndex(fileIndex);
			build.setRankIndex(rankIndex);
			build.calculateIndex();
			return build;
		}
	}
	
	private class SquareSequence implements Iterable<Square> {
		private Direction d;
		
		private SquareSequence(Direction d) {
			this.d = d;
		}
		
		@Override
		public Iterator<Square> iterator() {
			return new Iterator<Square>() {

				private Square current = Square.this;
				
				@Override
				public boolean hasNext() {
					return current.hasNextInDirection(d);
				}

				@Override
				public Square next() {
					return current = current.nextInDirection(d);
				}
				
			};
		}
		
	}

	
}
