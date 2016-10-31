package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Floorplan {
	CoordinatesDTO getCurrentCoordinates();
	void setCurrentCoordinates(CoordinatesDTO coordinates);
	FloorType senseFloorType();
	boolean senseObstruction(CoordinatesDTO coordinates);
	CoordinatesDTO calculateMovementCoordinates(Direction direction);
	boolean senseDirt();
	void clean();
}
