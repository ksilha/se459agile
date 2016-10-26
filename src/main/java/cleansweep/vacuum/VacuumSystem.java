package cleansweep.vacuum;

public interface VacuumSystem {
	void clean();
	int getTotalDirtWeight();
	void emptyDirtBasket();
	boolean isFull ();
	boolean isEmpty();
	int getCapacity();
}
