package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Floorplan {
	CoordinatesDTO getChargingStationCoordinates();
	String senseObstruction(CoordinatesDTO coordinates);
}
