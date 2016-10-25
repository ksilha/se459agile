package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class LowCarpetSensor extends FloorSensor {
	private static LowCarpetSensor lowCarpetSensor;
	
	private LowCarpetSensor (){
		super (FloorType.LOW_PILE_CARPET);
	}
	
	public static LowCarpetSensor getInstance (){
		if (lowCarpetSensor == null)
			return new LowCarpetSensor();
		return lowCarpetSensor;
	}

	@Override
	public boolean detect() {
		if (ControllerFacade.senseFloorType() == FloorType.LOW_PILE_CARPET)
			return true;
		return false;
	}	
}
