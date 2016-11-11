package cleansweep.movement;

import cleansweep.battery.Battery;
import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.floorplan.FloorplanImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class MovementImpl implements Movement {
	private Battery battery;
	
	public MovementImpl (){
		battery = new Battery();
	}
	
	@Override
	public void moveNorth() {
		if (energyForMovement())
		{
			boolean legalMove = (ControllerFacade.move(Direction.NORTH));
			if (!legalMove){
				//throw exception
			}
			else {
				consumePower();
			}
		}
		else
		{
			battery.setLowEnergy(true);
		}
	}

	@Override
	public void moveSouth() {
		if (energyForMovement())
		{
			boolean legalMove = (ControllerFacade.move(Direction.SOUTH) && energyForMovement());
			if (!legalMove){
				//throw exception
			}
			else {
				consumePower();
			}
		}
		else
		{
			battery.setLowEnergy(true);
		}
	}

	@Override
	public void moveEast() {
		if (energyForMovement())
		{
			boolean legalMove = (ControllerFacade.move(Direction.EAST)&& energyForMovement());
			if (!legalMove){
				//throw exception
			}
			else {
				consumePower();
			}
		}
		else
		{
			battery.setLowEnergy(true);
		}
		
	}

	@Override
	public void moveWest() {
		if (energyForMovement())
		{
			boolean legalMove = (ControllerFacade.move(Direction.WEST)&& energyForMovement());
			if (!legalMove){
				//throw exception
			}
			else {
				consumePower();
			}
		}
		else
		{
			battery.setLowEnergy(true);
		}
	}

	@Override
	public void move(CoordinatesDTO coordinate) {
		//to be completed
		
	}
	
	private void consumePower() {
		if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.BARE_FLOOR) {
			try {
				battery.setEnergy(-1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.LOW_PILE_CARPET) {
			try {
				battery.setEnergy(-2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (ControllerFacade.senseFloorType() == ControllerFacade.FloorType.HIGH_PILE_CARPET) {
			try {
				battery.setEnergy(-3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean energyForMovement()
	{
		int neededEnergy = 0;
		ControllerFacade.FloorType floorType = ControllerFacade.senseFloorType();
		if (floorType == ControllerFacade.FloorType.BARE_FLOOR)
		{
			neededEnergy = 1;
		}
		else if (floorType == ControllerFacade.FloorType.LOW_PILE_CARPET)
		{
			neededEnergy = 2;
		}
		else if (floorType == ControllerFacade.FloorType.HIGH_PILE_CARPET)
		{
			neededEnergy = 3;
		}
		
		if (battery.getEnergy() >= neededEnergy)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
