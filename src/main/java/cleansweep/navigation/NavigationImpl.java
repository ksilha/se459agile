package cleansweep.navigation;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.processor.ProcessTracker;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.Sensor;
import cleansweep.sensor.SensorFactory;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class NavigationImpl implements Navigation {
	private CoordinatesDTO currentCoordinate;
	private boolean northObstacle;
	private boolean southObstacle;
	private boolean eastObstacle;
	private boolean westObstacle;
	private CoordinatesDTO westCoordinate;
	private CoordinatesDTO eastCoordinate;
	private CoordinatesDTO northCoordinate;
	private CoordinatesDTO southCoordinate;
	private NorthSensor northSensor;
	private SouthSensor southSensor;
	private EastSensor eastSensor;
	private WestSensor westSensor;
	private HashMap <CoordinatesDTO, Integer> visitedCoordinatesMap;
	private static Navigation navigation;
	private Direction currentDir = Direction.WEST;
	
	private NavigationImpl (){
		eastSensor = (EastSensor) SensorFactory.createObstacleSensor(Direction.EAST);
		westSensor = (WestSensor) SensorFactory.createObstacleSensor(Direction.WEST);
		northSensor = (NorthSensor) SensorFactory.createObstacleSensor(Direction.NORTH);
		southSensor = (SouthSensor) SensorFactory.createObstacleSensor(Direction.SOUTH);
	}
	
	public static Navigation getInstance (){
		if (navigation == null)
			return new NavigationImpl ();
		return navigation;
	}
	
	
	private void setAllCoordinates(){
		northCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column+1);
		southCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column-1);
		eastCoordinate = new CoordinatesDTO (currentCoordinate.row+1, currentCoordinate.column);
		westCoordinate = new CoordinatesDTO (currentCoordinate.row-1, currentCoordinate.column);
	}
	
	
	private void senseObstaclesFromAllDirections() {
		northObstacle = northSensor.detect();
		southObstacle = southSensor.detect();
		eastObstacle = eastSensor.detect();
		westObstacle = westSensor.detect();
	}			

	@Override
	public Direction getDirection(CoordinatesDTO currentCoor) {
		//System.out.println(visitedCoordinatesMap.toString());
		currentCoordinate = currentCoor;
		setAllCoordinates();
		senseObstaclesFromAllDirections();
		System.out.println("current direction"+currentDir);
		
		if (currentDir == Direction.WEST){
			if (westObstacle == false)
				return Direction.WEST;
			else{
				if (northObstacle == true && southObstacle == true){
					return Direction.WEST;
				} else if (northObstacle == true && southObstacle == false)
					return Direction.SOUTH;
				else if (northObstacle == false && southObstacle == true){
					currentDir = Direction.EAST;
					return Direction.EAST;
				}
				else {
					currentDir = Direction.EAST;
					return Direction.SOUTH;
				}
			}
		}
			else if (currentDir == Direction.EAST){
				if (eastObstacle == false)
					return Direction.EAST;
				else{
					if (northObstacle == true && southObstacle == true){
						return Direction.EAST;
					} else if (northObstacle == true && southObstacle == false)
						return Direction.SOUTH;
					else if (northObstacle == false && southObstacle == true)
						return Direction.EAST;
					else {
						currentDir = Direction.WEST;
						return Direction.SOUTH;
					}
				}
			}
		
		return null;	
	}

	@Override
	public boolean checkNorthObstacle() {
		return northObstacle;
	}

	@Override
	public boolean checkSouthObstacle() {
		return southSensor.detect();
	}

	@Override
	public boolean checkEastObstacle() {
		return eastObstacle;
	}

	@Override
	public boolean checkWestObstacle() {
		return westSensor.detect();
	}
	
	public int distanceToCharger()
	{
		int distance = currentCoordinate.column + currentCoordinate.row;
		
		return distance;
	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub
		northObstacle = false;
		southObstacle = false;
		eastObstacle = false;
		westObstacle = false;
		
	}
}
