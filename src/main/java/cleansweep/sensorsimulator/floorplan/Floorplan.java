package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Floorplan {
	CoordinatesDTO getCurrentCoordinates();
	FloorType senseFloorType();
	boolean senseObstruction(CoordinatesDTO coordinates);
}
