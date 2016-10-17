package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class SouthSensor extends ObstacleSensor {
	private static SouthSensor southSensor;
	
	private SouthSensor (){
		super(Direction.SOUTH);
	}
	public static SouthSensor getInstance (){
		if (southSensor == null )
			return new SouthSensor ();
		return southSensor;
	}
	
	@Override
	public boolean detect() {
		return ControllerFacade.senseObstruction(Direction.SOUTH);
	}
	
	
}
