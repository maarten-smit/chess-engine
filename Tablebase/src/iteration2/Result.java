package iteration2;

public enum Result {
	WHITE("1-0", 1000.0),
	BLACK("0-1", -1000.0),
	DRAW("1/2-1/2", 0.0),
	ONGOING("*", 0.0);
	
	public final String notation;
	public final double eval;
	
	private Result(String notation, double eval) {
		this.notation = notation;
		this.eval = eval;
	}
}
