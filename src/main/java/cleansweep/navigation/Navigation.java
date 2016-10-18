package cleansweep.navigation;
import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.cell.*;
import cleansweep.sensorsimulator.floorplan.*;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;


public interface Navigation {	
	Direction getDirection ();
	void senseObstaclesFromAllDirection ();
	int getWestBoundary ();
	int getEastBoundary ();
	int getNorthBoundary ();
	int getSouthBoundary ();
	int getEastWestDistance ();
	int getNorthSouthDistance ();
	ArrayList<CoordinatesDTO> getPath ();
	HashMap <CoordinatesDTO, Integer> getVisitedCoordinatesMap ();
	int shortestDistanceFromChargingStation ();
	boolean hasTraverseAllCells ();
}
