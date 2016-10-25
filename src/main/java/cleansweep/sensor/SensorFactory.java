package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class SensorFactory {
	
	public static Sensor createDirtSensor (){
		return DirtSensor.getInstance();
	}
	
	public static Sensor createObstacleSensor (Direction direction){
		switch (direction) {
			case EAST:
				return EastSensor.getInstance();
			case WEST:
				return WestSensor.getInstance();
			case NORTH:
				return NorthSensor.getInstance();
			case SOUTH:
				return SouthSensor.getInstance();
			default:
				//throw exception
		}
		return null;
	}
	
	public static Sensor createFloorSensor (FloorType floorType){
		switch (floorType) {
		case BARE_FLOOR:
			return BareFloorSensor.getInstance();
		case LOW_PILE_CARPET:
			return LowCarpetSensor.getInstance();
		case HIGH_PILE_CARPET:
			return HighCarpetSensor.getInstance();
		case CHARGING_STATION:
			return ChargingStationSensor.getInstance();
		default:
			//throw exception
		}
		return null;
	}
	
}
