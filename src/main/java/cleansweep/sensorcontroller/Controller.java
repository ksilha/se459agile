package cleansweep.sensorcontroller;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public interface Controller {
	boolean senseObstruction(Direction direction);
	FloorType senseFloorType();
	boolean move(Direction direction);
	int checkPercentExplored();
}
