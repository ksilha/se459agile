package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class SimulationControllerImpl implements Controller {
	private Floorplan floorplan;
	
	public SimulationControllerImpl() {
		floorplan = FloorplanFactory.createFloorplan("floorplan2.txt");
	}

	public boolean senseObstruction(Direction direction) {
		CoordinatesDTO coordinates = floorplan.calculateMovementCoordinates(direction);
		
		return floorplan.senseObstruction(coordinates);
	}

	public FloorType senseFloorType() {
		return floorplan.senseFloorType();
	}

	public boolean move(Direction direction) {
		CoordinatesDTO coordinates = floorplan.calculateMovementCoordinates(direction);
		
		Boolean obstructed = floorplan.senseObstruction(coordinates);
		
		if (!obstructed) {
			floorplan.setCurrentCoordinates(coordinates);
		}
		
		return !obstructed;
	}

	public int checkPercentExplored() {
		// TODO Auto-generated method stub
		return 0;
	}

	public CoordinatesDTO getCurrentLocation() {
		return floorplan.getCurrentCoordinates();
	}

	public Boolean senseDirt() {
		return floorplan.senseDirt();
	}

	public void clean() {
		floorplan.clean();
		
	}
}
