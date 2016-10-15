package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class SimulationControllerImpl implements Controller {
	private Floorplan floorplan;
	private int currentRow;
	private int currentColumn;
	
	public SimulationControllerImpl() {
		floorplan = FloorplanFactory.createFloorplan("floorplan.txt");
		CoordinatesDTO coordinates = floorplan.getChargingStationCoordinates();
		currentRow = coordinates.row;
		currentColumn = coordinates.column;
	}

	public String senseObstruction(Direction direction) {
		CoordinatesDTO coordinates = calculateMovementCoordinates(direction);
		
		
		return floorplan.senseObstruction(coordinates);
	}

	public String senseFloorType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean move(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}

	public int checkPercentExplored() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private CoordinatesDTO calculateMovementCoordinates(Direction direction) {
		CoordinatesDTO coordinates = floorplan.getChargingStationCoordinates();
		
		if (direction == Direction.NORTH) {
			coordinates.row = currentRow - 1;
			coordinates.column = currentColumn;
		}
		else if (direction == Direction.SOUTH) {
			coordinates.row = currentRow + 1;
			coordinates.column = currentColumn;
		}
		else if (direction == Direction.EAST) {
			coordinates.row = currentRow;
			coordinates.column = currentColumn + 1;
		}
		else if (direction == Direction.WEST) {
			coordinates.row = currentRow;
			coordinates.column = currentColumn - 1;
		}
		
		return coordinates;
	}
}
