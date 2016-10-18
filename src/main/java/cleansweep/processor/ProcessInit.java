package cleansweep.processor;

import cleansweep.sensor.DirtSensor;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.FloorSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.ObstacleSensor;
import cleansweep.sensor.SensorType;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;
import cleansweep.sensorcontroller.ControllerFacade;

public class ProcessInit {
	
	public ProcessInit (){
		createSensors();
		initializeSimulation();
	}
	
	
	private void createSensors (){
		EastSensor.getInstance();
		WestSensor.getInstance();
		NorthSensor.getInstance();
		SouthSensor.getInstance();
	}
	
	private void initializeSimulation (){
		ControllerFacade.initialize("SIMULATION");
	}
	
	
	
}
