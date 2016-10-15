package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class SimulationControllerImpl implements Controller {
	private Floorplan floorplan;
	private int currentRow;
	private int currentColumn;
	
	public SimulationControllerImpl() {
		floorplan = FloorplanFactory.createFloorplan("floorplan.txt");
		CoordinatesDTO coordinates = floorplan.getCurrentCoordinates();
		currentRow = coordinates.row;
		currentColumn = coordinates.column;
	}

	public boolean senseObstruction(Direction direction) {
		CoordinatesDTO coordinates = calculateMovementCoordinates(direction);
		
		
		return floorplan.senseObstruction(coordinates);
	}

	public FloorType senseFloorType() {
		// TODO Auto-generated method stub
		return floorplan.senseFloorType();
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
		CoordinatesDTO coordinates = floorplan.getCurrentCoordinates();
		
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
