package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.navigation.Navigation;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Processor {
	int getWestBoundary ();
	int getEastBoundary ();
	int getNorthBoundary ();
	int getSouthBoundary ();
	boolean getEastObstacle ();
	boolean getWestObstacle();
	boolean getNorthObstacle();
	boolean getSouthObstacle();
	CoordinatesDTO getCurrentCoordinate();
	int getEastWestDistance ();
	int getNorthSouthDistance ();
	int shortestDistanceFromChargingStation ();
	boolean hasTraverseAllCells (Direction dir);
	ArrayList <CoordinatesDTO> getPath ();
	void goToNextCoordinate ();
	int getTotalDirtPickUp ();
	int remainingBagCapacity();
}
