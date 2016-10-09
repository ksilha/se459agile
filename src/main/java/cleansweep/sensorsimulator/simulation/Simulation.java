package cleansweep.sensorsimulator.simulation;

import cleansweep.sensorsimulator.utils.NavigationManager.Direction;

public interface Simulation {
	public String senseObstruction(Direction direction);
	
	public String senseFloorType();
}
