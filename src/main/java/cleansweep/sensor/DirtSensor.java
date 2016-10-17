package cleansweep.sensor;

import cleansweep.sensor.SensorType;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class DirtSensor extends Sensor {

	public DirtSensor() {
		super(SensorType.DIRT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean detect() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
