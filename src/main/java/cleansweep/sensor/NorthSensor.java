package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class NorthSensor extends ObstacleSensor {
	private static NorthSensor northSensor;
	
	private NorthSensor (){
		super(Direction.NORTH);
	}
	public static NorthSensor getInstance (){
		if (northSensor == null )
			return new NorthSensor ();
		return northSensor;
	}
	
	@Override
	public boolean detect() {
		return ControllerFacade.senseObstruction(Direction.NORTH);
	}
	
	
}
