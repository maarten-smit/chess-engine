package base;

public class KnightMoveStrategy extends ShortRangeMoveStrategy {

	public KnightMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	@Override
	protected int[][] getDeltas() {
		return new int[][] {
			new int[] {1, 2},
			new int[] {2, 1},
			new int[] {-1, 2},
			new int[] {-2, 1},
			new int[] {1, -2},
			new int[] {2, -1},
			new int[] {-1, -2},
			new int[] {-2, -1}
		};
	}

}
