package cleansweep.navigation;
import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.cell.*;
import cleansweep.sensorsimulator.floorplan.*;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;


public interface Navigation {	
	Direction getDirection ();
	boolean checkNorthObstacle ();
	boolean checkSouthObstacle ();
	boolean checkEastObstacle ();
	boolean checkWestObstacle ();

}
