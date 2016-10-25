package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public abstract class FloorSensor extends Sensor{
	private FloorType floorSensorType;
	
	public FloorSensor(FloorType floorSensorType) {
		super(SensorType.FLOOR);
		setFloorSensorType (floorSensorType);
	}
	
	public FloorType getFloorSensorType (){
		return floorSensorType;
	}
	
	
	private void setFloorSensorType (FloorType floorSensorType){
		if (floorSensorType == null){
			//throw exception
		} else {
			this.floorSensorType = floorSensorType;
		}
	}
}
