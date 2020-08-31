package base;

public interface Board {
	int getRankCount();
	int getFileCount();
	
	void apply(Move move);
	
	int getPiece(Square coordinate);
}
