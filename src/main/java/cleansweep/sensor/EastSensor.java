package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class EastSensor extends ObstacleSensor {
	private static EastSensor eastSensor;
	
	private EastSensor (){
		super(Direction.EAST);
	}
	public static EastSensor getInstance (){
		if (eastSensor == null )
			return new EastSensor ();
		return eastSensor;
	}
	
	@Override
	public boolean detect() {
		return ControllerFacade.senseObstruction(Direction.EAST);
		
	}
	
	
	
}
