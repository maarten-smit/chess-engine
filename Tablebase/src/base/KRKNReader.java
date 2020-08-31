package base;

public class KRKNReader implements Reader<Long> {

	@Override
	public GameState parse(Long id) {
		return new TablebaseReader().parse(new TablebaseID("KRkn", id));
	}
}
