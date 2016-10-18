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
	private int westBoundary; 
	private int eastBoundary;
	private int southBoundary;
	private int northBoundary;
	private NorthSensor northSensor;
	private SouthSensor southSensor;
	private EastSensor eastSensor;
	private WestSensor westSensor;
	private ArrayList <CoordinatesDTO> path;
	private HashMap <CoordinatesDTO, Integer> visitedCoordinatesMap;
	
	
	public NavigationImpl (CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor, EastSensor eastSensor, WestSensor westSensor){
		checkInputs (current, northSensor, southSensor, eastSensor, westSensor);
	}
	
	private void checkInputs (CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor, EastSensor eastSensor, WestSensor westSensor){
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
	}
	
	@Override
	public void senseObstaclesFromAllDirection() {
		northObstacle = northSensor.detect();
		southObstacle = southSensor.detect();
		eastObstacle = eastSensor.detect();
		westObstacle = westSensor.detect();
	}

	@Override
	public int getWestBoundary() {
		return westBoundary;
	}

	@Override
	public int getEastBoundary() {
		return eastBoundary;
	}

	@Override
	public int getNorthBoundary() {
		return northBoundary;
	}

	@Override
	public int getSouthBoundary() {
		return southBoundary;
	}

	@Override
	public int getEastWestDistance() {
		return Math.abs(eastBoundary) + Math.abs(westBoundary) + 1;
	}

	@Override
	public int getNorthSouthDistance() {
		return Math.abs(northBoundary) + Math.abs(southBoundary)+1;
	}

	@Override
	public ArrayList<CoordinatesDTO> getPath() {
		return path;
	}

	@Override
	public int shortestDistanceFromChargingStation() {
		return Math.abs(currentCoordinate.column) + Math.abs(currentCoordinate.row);
	}

	@Override
	public boolean hasTraverseAllCells() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<CoordinatesDTO, Integer> getVisitedCoordinatesMap() {
		return visitedCoordinatesMap;
	}


	private int setWestBoundary(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int setEastBoundary(int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int setNorthBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int setSouthBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int setEastWestDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int setNorthSouthDistance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void addPath (CoordinatesDTO coordinate){
		if (coordinate != null)
			path.add(coordinate);
		else {
			//throw exception
		}
	}
	
	private void addToVisitedCoordinatesMap (CoordinatesDTO coordinate){
		if (coordinate == null){
			//throw exception
		} else {
			if (visitedCoordinatesMap == null){
				visitedCoordinatesMap = new HashMap <CoordinatesDTO, Integer>();
				visitedCoordinatesMap.put(coordinate, 1);				
			} else{
				if (visitedCoordinatesMap.containsKey(coordinate))
					visitedCoordinatesMap.put(coordinate, visitedCoordinatesMap.get(coordinate)+1);
				else
					visitedCoordinatesMap.put(coordinate, 1);
			}
		}
	}
	
}
