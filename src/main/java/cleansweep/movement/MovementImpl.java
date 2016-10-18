package cleansweep.movement;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.floorplan.FloorplanImpl;

public class MovementImpl implements Movement {
	
	
	@Override
	public void moveNorth() {
		boolean legalMove = ControllerFacade.move(Direction.NORTH);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveSouth() {
		boolean legalMove = ControllerFacade.move(Direction.SOUTH);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveEast() {
		boolean legalMove = ControllerFacade.move(Direction.EAST);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveWest() {
		boolean legalMove = ControllerFacade.move(Direction.WEST);
		if (!legalMove){
			//throw exception
		}
	}

	
}
