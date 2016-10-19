package cleansweep.movement;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.floorplan.FloorplanImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class MovementImpl implements Movement {
	private Controller controller;
	
	public MovementImpl (Controller control){
		if (control == null){
			//throw exception
		} else 
			controller = control;
	}
	
	@Override
	public void moveNorth() {
		boolean legalMove = controller.move(Direction.NORTH);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveSouth() {
		boolean legalMove = controller.move(Direction.SOUTH);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveEast() {
		boolean legalMove = controller.move(Direction.EAST);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveWest() {
		boolean legalMove = controller.move(Direction.WEST);
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void move(CoordinatesDTO coordinate) {
		//to be completed
		
	}
}
