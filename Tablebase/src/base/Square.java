package base;

/**
 * datatype class for board coordinate
 * @author Maarten
 *
 */

public class Square {
	private int file;
	private int rank;
	
	private int fileCount;
	private int rankCount;

	private void setFile(int file) {
		this.file = file;
	}

	private void setRank(int rank) {
		this.rank = rank;
	}

	private void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	private void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}

	public int getFile() {
		return file;
	}

	public int getRank() {
		return rank;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = super.equals(obj);
		if(!equals && obj instanceof Square) {
			Square that = (Square) obj;
			equals = this.getFile() == that.getFile() && this.getRank() == that.getRank();
		}
		return equals;
	}
	
	public static BoardCoordinateBuilder of(int fileCount, int rankCount) {
		if(fileCount <= 0 || rankCount <= 0) {
			throw new IllegalArgumentException("empty board");
		}
		return new BoardCoordinateBuilder(fileCount, rankCount);
	}
	
	public static BoardCoordinateBuilder of(Board board) {
		return of(board.getFileCount(), board.getRankCount());
	}
	
	public static class BoardCoordinateBuilder {
		
		private int file;
		private int rank;
		
		private int fileCount;
		private int rankCount;
		
		private BoardCoordinateBuilder(int fileCount, int rankCount) {
			this.fileCount = fileCount;
			this.rankCount = rankCount;
		}
		
		public BoardCoordinateBuilder file(int file) {
			if(file < 0 || file >= fileCount) {
				throw new IllegalArgumentException("file index out of bounds");
			}
			this.file = file;
			return this;
		}
		
		public BoardCoordinateBuilder rank(int rank) {
			if(rank < 0 || rank >= rankCount) {
				throw new IllegalArgumentException("rank index out of bounds");
			}
			this.rank = rank;
			return this;
		}
		
		/**
		 * overwrites file and rank
		 */
		public BoardCoordinateBuilder index(int index) {
			if(index < 0 || index >= rankCount * fileCount) {
				throw new IllegalArgumentException("general index out of bounds");
			}
			file = index % fileCount;
			rank = rankCount - 1 - index / fileCount;
			return this;
		}
		
		public Square build() {
			Square result = new Square();
			
			result.setFileCount(fileCount);
			result.setRankCount(rankCount);
			result.setFile(file);
			result.setRank(rank);
			
			return result;
		}
	}

	/**
	 * 
	 * @param board the board in question
	 * @return true if and only if the board dimensions match the expected dimensions
	 */
	public boolean fits(Board board) {
		return fileCount == board.getFileCount() && rankCount == board.getRankCount();
	}

	/**
	 * 
	 * @return index of this coordinate in order of printing (i.e. a8 = 0, b8 = 1 etc. for a standard size board)
	 */
	public int getIndex() {
		return file + (rankCount - 1 - rank) * fileCount;
	}
	
	@Override
	public String toString() {
		return "" + (char)(file + 'a') + (rank + 1);
	}
}
