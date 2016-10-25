package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class BareFloorSensor extends FloorSensor {
	private static BareFloorSensor bareFloorSensor;
	
	private BareFloorSensor (){
		super (FloorType.BARE_FLOOR);
	}
	
	public static BareFloorSensor getInstance (){
		if (bareFloorSensor == null)
			return new BareFloorSensor ();
		return bareFloorSensor;
	}

	@Override
	public boolean detect() {
		if (ControllerFacade.senseFloorType() == FloorType.BARE_FLOOR)
			return true;
		return false;
	}
	
}
