package base;

import java.util.Collection;

//TODO nadenken of naam anders moet sinds BoardState mutable is geworden

public interface BoardState<T extends BoardState<T>> extends Iterable<Square> {
	/**
	 * Checks whether the given square is occupied by a piece, and if so which piece.
	 * @param sq the square in question
	 * @return the type of the piece occupying the square, null if the square is not occupied
	 */
	PieceType getPiece(Square sq);
	
	/**
	 * Applies the given move to the board if it is legal.
	 * @param m the move to be applied
	 * @throws IllegalMoveException
	 */
	void apply(Move m);
	
	/**
	 * 
	 * @return the number of ranks on this board
	 */
	int getRankCount();
	
	/**
	 * 
	 * @return the number of files on this board
	 */
	int getFileCount();
	
	/**
	 * Looks for all occurrences of the given piece.
	 * @param type the type of the piece to be found
	 * @return a collection consisting of all the squares on the board which contain the given piece type.
	 */
	Collection<Square> getSquares(PieceType type);
	
	/**
	 * Adds a piece to the board at given square, overwriting any piece currently at that square.
	 * @param type the type of piece to be added
	 * @param target the target square for the piece
	 */
	void add(PieceType type, Square target);
	
	/**
	 * Empties the given square, potentially removing the piece occupying that square.
	 * @param target the square to be emptied
	 */
	void empty(Square target);
	
	/**
	 * Checks whether a king could be captured next move
	 * @param white which king should be checked
	 * @return whether given king is in check
	 */
	boolean inCheck(boolean white);
	
	boolean inCheckMate(boolean white);
	
	boolean inStaleMate(boolean white);
}
