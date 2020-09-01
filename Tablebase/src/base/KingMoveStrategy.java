package base;

public class KingMoveStrategy extends ShortRangeMoveStrategy {

	public KingMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	@Override
	protected int[][] getDeltas() {
		return new int[][] {
			new int[] {1, 1},
			new int[] {1, 0},
			new int[] {1, -1},
			new int[] {0, -1},
			new int[] {-1, -1},
			new int[] {-1, 0},
			new int[] {-1, 1},
			new int[] {0, 1}
		};
	}

}
