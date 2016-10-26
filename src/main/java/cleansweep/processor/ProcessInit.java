package cleansweep.processor;

import cleansweep.navigation.Navigation;
import cleansweep.sensor.DirtSensor;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.FloorSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.ObstacleSensor;
import cleansweep.sensor.Sensor;
import cleansweep.sensor.SensorFactory;
import cleansweep.sensor.SensorType;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;
import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.vacuum.VacuumSystem;

public class ProcessInit {
	private Sensor dirtSensor;
	private Sensor eastSensor;
	private Sensor westSensor;
	private Sensor northSensor;
	private Sensor southSensor;
	private Sensor lowCarpetSensor;
	private Sensor highCarpetSensor;
	private Sensor chargingStationSensor;
	private Sensor bareFloorSensor;
	private Navigation navigation;
	private VacuumSystem vaccuumSystem;
	
	
	
	public ProcessInit (){
		createSensors();
		initializeSimulation();
	}
	
	
	private void createSensors (){
		SensorFactory.createDirtSensor();
	}
	
	private void initializeSimulation (){
		ControllerFacade.initialize("SIMULATION");
	}
	
	
	
}
