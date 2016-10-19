package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public interface Processor {
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
