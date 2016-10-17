package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class WestSensor extends ObstacleSensor{
	private static WestSensor westSensor;
	
	private WestSensor (){
		super(Direction.WEST);
	}
	public static WestSensor getInstance (){
		if (westSensor == null )
			return new WestSensor ();
		return westSensor;
	}
	
	@Override
	public boolean detect() {
		return ControllerFacade.senseObstruction(Direction.WEST);
	}
	
	
}
