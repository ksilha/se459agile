package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public interface Cell {
	public Boolean isObstruction();
	FloorType getFloorType();
	boolean senseDirt();
	void clean();
}
