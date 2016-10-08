package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class SimulationImpl implements Simulation {
	SimulationImpl() {
		Floorplan floorplan = FloorplanFactory.createFloorplan("floorplan.txt");
	}

	public String checkCoordinateObjectType(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	public String checkCoordinateFloorType(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
}
