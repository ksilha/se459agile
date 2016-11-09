package cleansweep.navigation;
import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.cell.*;
import cleansweep.sensorsimulator.floorplan.*;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;


public interface Navigation {	
	Direction getDirection (CoordinatesDTO currentCoor, HashMap <CoordinatesDTO, Integer> visitedMap);
	boolean checkNorthObstacle ();
	boolean checkSouthObstacle ();
	boolean checkEastObstacle ();
	boolean checkWestObstacle ();
	int distanceToCharger();
	void resetSensors ();
	Direction getDirectionToChargingStation (CoordinatesDTO currentCoordinate, HashMap <CoordinatesDTO, Integer> visitedMap);
}
