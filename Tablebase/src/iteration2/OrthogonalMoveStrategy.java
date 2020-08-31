package iteration2;

import java.util.ArrayList;
import java.util.Collection;

public class OrthogonalMoveStrategy extends LongRangeMoveStrategy {

	public OrthogonalMoveStrategy(BoardState<?> boardState) {
		super(boardState);
	}

	@Override
	public Collection<Direction> getDirections() {
		Collection<Direction> directions = new ArrayList<>(4);
		directions.add(Direction.UP);
		directions.add(Direction.DOWN);
		directions.add(Direction.LEFT);
		directions.add(Direction.RIGHT);
		return directions;
	}

}
