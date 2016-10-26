package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class HighCarpetSensor extends FloorSensor{
	private static HighCarpetSensor highCarpetSensor;
	
	private HighCarpetSensor(){
		super (FloorType.HIGH_PILE_CARPET);
	}
	
	public static HighCarpetSensor getInstance (){
		if (highCarpetSensor == null)
			return new HighCarpetSensor();
		return highCarpetSensor;
	}

	@Override
	public boolean detect() {
		if (ControllerFacade.senseFloorType() == FloorType.HIGH_PILE_CARPET)
			return true;
		return false;
	}
}
