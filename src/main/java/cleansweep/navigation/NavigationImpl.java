package cleansweep.navigation;

import java.util.ArrayList;

import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class NavigationImpl implements Navigation {
	private CoordinatesDTO currentCoordinates;
	private boolean northObstacle;
	private boolean southObstacle;
	private boolean eastObstacle;
	private boolean westObstacle;
	private int westBoundary;
	private int eastBoundary;
	private int southBoundary;
	private int northBoundary;
	
	public NavigationImpl (CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor ){
		if (current != null)
			currentCoordinates = current;
		else{
			//throw exception
		}
	}
	
	@Override
	public void senseObstaclesFromAllDirection() {

		
	}

	@Override
	public int getWestBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEastBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNorthBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSouthBoundary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEastWestDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNorthSouthDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CoordinatesDTO> visitedCellsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int shortestDistanceFromChargingStation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasTraverseAllCells() {
		// TODO Auto-generated method stub
		return false;
	}

}
