package base;

public class TablebaseID {
	private final String pieceDist;
	private final long placements;
	
	public TablebaseID(String pieceDist, long placements) {
		this.pieceDist = pieceDist;
		this.placements = placements;
	}
	
	public String getPieceDist() {
		return pieceDist;
	}
	
	public long getPlacements() {
		return placements;
	}
	
	@Override
	public String toString() {
		return getPieceDist() + ": " + getPlacements();
	}
}
