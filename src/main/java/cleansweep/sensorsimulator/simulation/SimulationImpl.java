package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;
import cleansweep.sensorsimulator.utils.NavigationManager.Direction;

public class SimulationImpl implements Simulation {
	SimulationImpl() {
		Floorplan floorplan = FloorplanFactory.createFloorplan("floorplan.txt");
	}

	public String senseObstruction(Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

	public String senseFloorType() {
		// TODO Auto-generated method stub
		return null;
	}
}
