package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Processor {
	int getWestBoundary ();
	int getEastBoundary ();
	int getNorthBoundary ();
	int getSouthBoundary ();
	int getEastWestDistance ();
	int getNorthSouthDistance ();
	int shortestDistanceFromChargingStation ();
	boolean hasTraverseAllCells ();
	CoordinatesDTO goToNextCoordinate ();
}
