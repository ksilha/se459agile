package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class ChargingStationSensor extends FloorSensor {
	private static ChargingStationSensor chargingStationSensor;
	
	private ChargingStationSensor (){
		super (FloorType.CHARGING_STATION);
	}
	
	public static ChargingStationSensor getInstance(){
		if (chargingStationSensor == null)
			return new ChargingStationSensor();
		return chargingStationSensor;
	}
	
	@Override
	public boolean detect() {
		if (ControllerFacade.senseFloorType() == FloorType.CHARGING_STATION)
			return true;
		return false;
	}
}
