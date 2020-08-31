package base;

public interface Reader<E> {
	GameState parse(E id);
}
