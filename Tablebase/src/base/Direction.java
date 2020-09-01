package base;

public final class Direction {
	private final int fileDisplacement;
	private final int rankDisplacement;
	
	public static final Direction UP = new Direction(0, 1);
	public static final Direction DOWN = new Direction(0, -1);
	public static final Direction LEFT = new Direction(-1, 0);
	public static final Direction RIGHT = new Direction(1, 0);
	public static final Direction UP_LEFT = new Direction(-1, 1);
	public static final Direction UP_RIGHT = new Direction(1, 1);
	public static final Direction DOWN_LEFT = new Direction(-1, -1);
	public static final Direction DOWN_RIGHT = new Direction(1, -1);
	
	public Direction(int fileDisplacement, int rankDisplacement) {
		this.fileDisplacement = fileDisplacement;
		this.rankDisplacement = rankDisplacement;
	}

	public int getFileDisplacement() {
		return fileDisplacement;
	}

	public int getRankDisplacement() {
		return rankDisplacement;
	}
}
