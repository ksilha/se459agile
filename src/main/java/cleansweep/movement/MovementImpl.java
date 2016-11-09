package cleansweep.movement;

import cleansweep.battery.BatteryInst;
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
		if (!legalMove){
			
		}
		else {
			consumePower();
		}
	}

	@Override
	public void moveSouth() {
		boolean legalMove = ControllerFacade.move(Direction.SOUTH);
		if (!legalMove){
			//throw exception
		}
		else {
			consumePower();
		}
	}

	@Override
	public void moveEast() {
		boolean legalMove = ControllerFacade.move(Direction.EAST);
		if (!legalMove){
			//throw exception
		}
		else {
			consumePower();
		}
	}

	@Override
	public void moveWest() {
		boolean legalMove = ControllerFacade.move(Direction.WEST);
		if (!legalMove){
			//throw exception
		}
		else {
			consumePower();
		}
	}

	@Override
	public void move(CoordinatesDTO coordinate) {
		//to be completed
		
	}
	
	private void consumePower() {
		if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.BARE_FLOOR) {
			try {
				BatteryInst.getInstance().setEnergy(-1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.LOW_PILE_CARPET) {
			try {
				BatteryInst.getInstance().setEnergy(-2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.HIGH_PILE_CARPET) {
			try {
				BatteryInst.getInstance().setEnergy(-3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
