package cleansweep.movement;

import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Movement {
	void moveNorth ();
	void moveSouth ();
	void moveEast ();
	void moveWest ();
	void move (CoordinatesDTO coordinate);
}
