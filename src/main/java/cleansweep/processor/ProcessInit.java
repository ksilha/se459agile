package cleansweep.processor;

import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.movement.MovementFactory;
import cleansweep.navigation.Navigation;
import cleansweep.navigation.NavigationFactory;
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
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;
import cleansweep.vacuum.VacuumSystem;
import cleansweep.vacuum.VacuumSystemFactory;

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
	private VacuumSystem vacuumSystem;
	private Movement movement;
	private ProcessTracker processTracker;
	private CoordinatesDTO currentCoordinate;
	private Processor processor;
	
	
	public ProcessInit () throws Exception{
		createSensors();
		createVacuumSystem ();
		createMovement();
	}
	
	public void initializeSimulation (){
		ControllerFacade.initialize("SIMULATION");
	}
	
	public void startRobot(){
		createNavigation ();
		processor =  new ProcessorImpl (currentCoordinate, navigation,movement);
		while (!processor.hasTraverseAllCells()){
			processor.goToNextCoordinate();
		}
	}
	
	private void createSensors (){
		dirtSensor = SensorFactory.createDirtSensor();
		eastSensor = SensorFactory.createObstacleSensor(Direction.EAST);
		westSensor = SensorFactory.createObstacleSensor(Direction.WEST);
		northSensor = SensorFactory.createObstacleSensor(Direction.NORTH);
		southSensor = SensorFactory.createObstacleSensor(Direction.SOUTH);
		bareFloorSensor = SensorFactory.createFloorSensor(FloorType.BARE_FLOOR);
		lowCarpetSensor = SensorFactory.createFloorSensor(FloorType.LOW_PILE_CARPET);
		highCarpetSensor = SensorFactory.createFloorSensor(FloorType.HIGH_PILE_CARPET);
		chargingStationSensor = SensorFactory.createFloorSensor(FloorType.CHARGING_STATION);
	}
	
	private void createNavigation (){
		currentCoordinate = processTracker.getCurrentCoordinate();
		HashMap <CoordinatesDTO,Integer> map = processTracker.getVisitedCoordinatesMap();
		navigation = NavigationFactory.createNavigation(currentCoordinate, northSensor, southSensor, eastSensor, westSensor, map);
	}
	
	private void createVacuumSystem (){
		vacuumSystem = VacuumSystemFactory.createVacuum();
	}
	
	private void createMovement() throws Exception{
		movement = MovementFactory.createMovement("VIRTUAL_WHEEL");
	}
	
	
	
}
