package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class FloorSensor extends Sensor{

	public FloorSensor() {
		super(SensorType.FLOOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean detect() {
		// TODO Auto-generated method stub
		return true;
	}
}
