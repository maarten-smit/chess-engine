package base;

import java.util.ArrayList;
import java.util.Collection;

public class Promotion extends SpecialMoveType {
	private final PieceType result;
	
	public Promotion(PieceType result) {
		if(!result.canResultFromPromotion()) {
			throw new IllegalArgumentException("illegal promotion type");
		}
		this.result = result;
	}
	
	public static Collection<Promotion> promotions(boolean white) {
		Collection<Promotion> promotions = new ArrayList<>(4);
		if(white) {
			promotions.add(new Promotion(PieceType.WHITE_Q));
			promotions.add(new Promotion(PieceType.WHITE_R));
			promotions.add(new Promotion(PieceType.WHITE_B));
			promotions.add(new Promotion(PieceType.WHITE_N));
		} else {
			promotions.add(new Promotion(PieceType.BLACK_Q));
			promotions.add(new Promotion(PieceType.BLACK_R));
			promotions.add(new Promotion(PieceType.BLACK_B));
			promotions.add(new Promotion(PieceType.BLACK_N));
		}
		return promotions;
	}
	
	public PieceType getResult() {
		return result;
	}

	@Override
	public void handle(BoardState<?> boardState, Square dest) {
		boardState.empty(dest);
		boardState.add(result, dest);
	}
	
	@Override
	public String toString() {
		return "(" + result + ")";
	}
}
