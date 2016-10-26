package cleansweep.sensor;

import cleansweep.sensor.SensorType;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public class DirtSensor extends Sensor {
	private static DirtSensor dirtSensor;
	private boolean isDirty;
	
	private DirtSensor() {
		super(SensorType.DIRT);
	}
	
	public static DirtSensor getInstance (){
		if (dirtSensor == null)
			return new DirtSensor ();
		return dirtSensor;
	}

	@Override
	public boolean detect() {
		return ControllerFacade.senseDirt();
	}
}
