package base;

import java.util.ArrayList;
import java.util.Collection;

public class DiagonalMoveStrategy extends LongRangeMoveStrategy {

	public DiagonalMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	@Override
	public Collection<Direction> getDirections() {
		Collection<Direction> directions = new ArrayList<>(4);
		directions.add(Direction.UP_LEFT);
		directions.add(Direction.UP_RIGHT);
		directions.add(Direction.DOWN_LEFT);
		directions.add(Direction.DOWN_RIGHT);
		return directions;
	}


}
