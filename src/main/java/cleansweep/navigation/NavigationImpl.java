package cleansweep.navigation;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.sensor.EastSensor;
import cleansweep.sensor.NorthSensor;
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
	
	
	public NavigationImpl (CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor, EastSensor eastSensor, WestSensor westSensor, HashMap <CoordinatesDTO, Integer> map ){
		checkParameters (current, northSensor, southSensor, eastSensor, westSensor, map);
		setAllCoordinates ();
		senseObstaclesFromAllDirections();
	}
	
	private void checkParameters (CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor, EastSensor eastSensor, WestSensor westSensor, HashMap <CoordinatesDTO, Integer> map){
		if (current != null)
			currentCoordinate = current;
		else{
			//throw exception
		}
		
		if (northSensor != null)
			this.northSensor = northSensor;
		else {
			//throw exception
		}
		
		if (southSensor != null)
			this.southSensor = southSensor;
		else{
			//throw exception
		}
		
		if (eastSensor != null)
			this.eastSensor = eastSensor;
		else{
			//throw exception
		}
		
		if (westSensor != null)
			this.westSensor = westSensor;
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
		
		return Direction.NORTH;
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
}
