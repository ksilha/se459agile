package cleansweep.movement;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.floorplan.FloorplanImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class MovementImpl implements Movement {
	
	public MovementImpl (){
	}
	
	@Override
	public void moveNorth() {
		boolean legalMove = ControllerFacade.move(Direction.NORTH);
		System.out.println("move to north");
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveSouth() {
		boolean legalMove = ControllerFacade.move(Direction.SOUTH);
		System.out.println("move to south");
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveEast() {
		boolean legalMove = ControllerFacade.move(Direction.EAST);
		System.out.println("move to east");
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void moveWest() {
		boolean legalMove = ControllerFacade.move(Direction.WEST);
		System.out.println("move to west");
		if (!legalMove){
			//throw exception
		}
	}

	@Override
	public void move(CoordinatesDTO coordinate) {
		//to be completed
		
	}
}
