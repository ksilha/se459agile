package cleansweep.navigation;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.Sensor;
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
	
	
	public NavigationImpl (CoordinatesDTO current, Sensor northSensor2, Sensor southSensor2, Sensor eastSensor2, Sensor westSensor2, HashMap <CoordinatesDTO, Integer> map ){
		checkParameters (current, northSensor2, southSensor2, eastSensor2, westSensor2, map);
		setAllCoordinates ();
		senseObstaclesFromAllDirections();
	}
	
	private void checkParameters (CoordinatesDTO current, Sensor northSensor2, Sensor southSensor2, Sensor eastSensor2, Sensor westSensor2, HashMap <CoordinatesDTO, Integer> map){
		if (current != null)
			currentCoordinate = current;
		else{
			//throw exception
		}
		
		if (northSensor2 != null)
			this.northSensor = (NorthSensor) northSensor2;
		else {
			//throw exception
		}
		
		if (southSensor2 != null)
			this.southSensor = (SouthSensor) southSensor2;
		else{
			//throw exception
		}
		
		if (eastSensor2 != null)
			this.eastSensor = (EastSensor) eastSensor2;
		else{
			//throw exception
		}
		
		if (westSensor2 != null)
			this.westSensor = (WestSensor) westSensor2;
		else {
			//throw exception
		}
		
		if (map != null)
			visitedCoordinatesMap = map;
		else {
			//throw exception
		}
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
	public Direction getDirection() {		
		if (westObstacle == false && !visitedCoordinatesMap.containsKey(westCoordinate))
			return Direction.WEST;
		else if (southObstacle == false && !visitedCoordinatesMap.containsKey(southCoordinate) && visitedCoordinatesMap.containsKey(eastCoordinate) )
			return Direction.SOUTH;
		else if (eastObstacle == false && !visitedCoordinatesMap.containsKey(eastCoordinate))
			return Direction.EAST;
		else if (northObstacle == false && !visitedCoordinatesMap.containsKey(northCoordinate))
			return Direction.NORTH;
		return null;
	}

	@Override
	public boolean checkNorthObstacle() {
		return northObstacle;
	}

	@Override
	public boolean checkSouthObstacle() {
		return southObstacle;
	}

	@Override
	public boolean checkEastObstacle() {
		return eastObstacle;
	}

	@Override
	public boolean checkWestObstacle() {
		return westObstacle;
	}
	
	public int distanceToCharger()
	{
		int distance = currentCoordinate.column + currentCoordinate.row;
		
		return distance;
	}
}
