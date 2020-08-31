package base;

import java.util.BitSet;

public class BitBoard {
	private int size;
	private BitSet bits;
	
	public BitBoard(int size) {
		this.size = size;
		this.bits = new BitSet(size);
	}

	public void populate(Square... coordinates) {
		for(Square coordinate : coordinates) {
			set(coordinate.getIndex());
		}
	}
	
	public void emptySquare(int targetIndex) {
		clear(targetIndex);
	}
	
	public void moveIfPossible(int source, int dest) {
		if(get(source)) {
			clear(source);
			set(dest);
		}
	}
	
	public BitSet getState() {
		return bits;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = super.equals(obj);
		if(!equals && obj instanceof BitBoard) {
			BitBoard that = (BitBoard) obj;
			equals = this.getState().equals(that.getState());
		}
		return equals;
	}
	
	private boolean get(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("index out of bounds for " + size + ": " + index);
		}
		return bits.get(index);
	}
	
	private void set(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("index out of bounds for " + size + ": " + index);
		}
		bits.set(index);
	}
	
	private void clear(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("index out of bounds for " + size + ": " + index);
		}
		bits.clear(index);
	}

	public boolean isOccupied(Square coordinate) {
		return bits.get(coordinate.getIndex());
	}
	
	
}
