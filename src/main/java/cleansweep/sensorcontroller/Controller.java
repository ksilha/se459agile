package cleansweep.sensorcontroller;

import cleansweep.sensorcontroller.ControllerFacade.Direction;

public interface Controller {
	String senseObstruction(Direction direction);
	String senseFloorType();
	boolean move(Direction direction);
	int checkPercentExplored();
}
