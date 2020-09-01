package base;

import java.util.ArrayList;
import java.util.Collection;

public class QueenMoveStrategy extends LongRangeMoveStrategy {

	public QueenMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	@Override
	public Collection<Direction> getDirections() {
		Collection<Direction> directions = new ArrayList<>(4);
		directions.add(Direction.UP);
		directions.add(Direction.DOWN);
		directions.add(Direction.LEFT);
		directions.add(Direction.RIGHT);
		directions.add(Direction.UP_LEFT);
		directions.add(Direction.UP_RIGHT);
		directions.add(Direction.DOWN_LEFT);
		directions.add(Direction.DOWN_RIGHT);
		return directions;
	}

}
