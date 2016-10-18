package cleansweep.navigation;
import java.util.ArrayList;

import cleansweep.sensorsimulator.cell.*;
import cleansweep.sensorsimulator.floorplan.*;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;


public interface Navigation {
	
	void senseObstaclesFromAllDirection ();
	int getWestBoundary ();
	int getEastBoundary ();
	int getNorthBoundary ();
	int getSouthBoundary ();
	int getEastWestDistance ();
	int getNorthSouthDistance ();
	ArrayList<CoordinatesDTO> visitedCellsList ();
	int shortestDistanceFromChargingStation ();
	boolean hasTraverseAllCells ();
}
