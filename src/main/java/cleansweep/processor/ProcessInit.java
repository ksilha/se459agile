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
	private Controller simulatorController;
	private Processor robotProcessor;
	
	
	public ProcessInit (){
		
	}
	
	
	public void initializeSimulation (String floorPlan){
		ControllerFacade.initialize("SIMULATION", floorPlan);
	}
	
	public void startRobot() throws Exception{
		robotProcessor =  new ProcessorImpl();
		robotProcessor.goToNextCoordinate();
	}
	
	public Processor getProcessor (){
		return robotProcessor;
	}
	
	public Controller getSimulatorController(){
		return simulatorController;
	}
	
	
}
