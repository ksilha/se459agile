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
	private static Navigation navigation;
	private Direction currentDir = Direction.WEST;
	
	private NavigationImpl () throws Exception{
		eastSensor = (EastSensor) SensorFactory.createObstacleSensor(Direction.EAST);
		westSensor = (WestSensor) SensorFactory.createObstacleSensor(Direction.WEST);
		northSensor = (NorthSensor) SensorFactory.createObstacleSensor(Direction.NORTH);
		southSensor = (SouthSensor) SensorFactory.createObstacleSensor(Direction.SOUTH);
	}
	
	public static Navigation getInstance () throws Exception{
		if (navigation == null)
			return new NavigationImpl ();
		return navigation;
	}
	
	
	private void setAllCoordinates(){
		northCoordinate = new CoordinatesDTO (currentCoordinate.row+1, currentCoordinate.column);
		southCoordinate = new CoordinatesDTO (currentCoordinate.row-1, currentCoordinate.column);
		eastCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column+1);
		westCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column-1);
	}
	
	
	private void senseObstaclesFromAllDirections() {
		northObstacle = northSensor.detect();
		southObstacle = southSensor.detect();
		eastObstacle = eastSensor.detect();
		westObstacle = westSensor.detect();
	}			

	@Override
	public Direction getDirection(CoordinatesDTO currentCoor, HashMap <CoordinatesDTO,Integer> visitedMap ) {
		//System.out.println(visitedCoordinatesMap.toString());
		currentCoordinate = currentCoor;
		setAllCoordinates();
		senseObstaclesFromAllDirections();
		
		if (westObstacle == false && !visitedMap.containsKey(westCoordinate)){
			return Direction.WEST;
		} else if (southObstacle == false && !visitedMap.containsKey(southCoordinate) && ((westObstacle == true && visitedMap.containsKey(eastCoordinate)) || (eastObstacle == true && visitedMap.containsKey(westCoordinate)))){
			return Direction.SOUTH;
		} else if (eastObstacle == false && !visitedMap.containsKey(eastCoordinate)){
			return Direction.EAST;
		} else if (northObstacle == false && !visitedMap.containsKey(northCoordinate))
			return Direction.NORTH;
		
		return null;
		
		
		
		/*
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
					System.out.println(visitedMap.toString());
					currentDir = Direction.EAST;
					if (visitedMap.containsKey(eastCoordinate))
						return Direction.SOUTH;
					return Direction.EAST;
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
					else if (northObstacle == false && southObstacle == true){
						currentDir = Direction.EAST;
						return Direction.EAST;
					}
					else {
						currentDir = Direction.WEST;
						if (visitedMap.containsKey(westCoordinate))
							return Direction.SOUTH;
						return Direction.WEST;
					}
				}
			}

		return null;	
		*/
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
