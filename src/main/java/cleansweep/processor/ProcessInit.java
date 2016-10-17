package cleansweep.processor;

import cleansweep.sensor.DirtSensor;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.FloorSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.ObstacleSensor;
import cleansweep.sensor.SensorType;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;

public class ProcessInit {
	
	public ProcessInit (){
		createSensors();
	}
	
	
	private void createSensors (){
		EastSensor.getInstance();
		WestSensor.getInstance();
		NorthSensor.getInstance();
		SouthSensor.getInstance();
	}
	
	
	
	
}
