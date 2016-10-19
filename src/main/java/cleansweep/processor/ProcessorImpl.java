package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.navigation.Navigation;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ProcessorImpl implements Processor {
	private CoordinatesDTO currentCoordinate;
	private int westBoundary; 
	private int eastBoundary;
	private int southBoundary;
	private int northBoundary;
	private ArrayList <CoordinatesDTO> path;
	private HashMap <CoordinatesDTO, Integer> visitedCoordinatesMap;
	
	public ProcessorImpl (CoordinatesDTO currentCoordinate, Navigation nav, Movement mov ){
		
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
	public HashMap<CoordinatesDTO, Integer> getVisitedCoordinatesMap() {
		return visitedCoordinatesMap;
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
	
	private void setWestBoundary(int column) {
		if (column != westBoundary)
			westBoundary = column;
		else{
			//throw exception
		}
	}

	private void setEastBoundary(int column) {
		if (column != eastBoundary)
			eastBoundary = column;
		else{
			//throw exception
		}
	}

	private void setNorthBoundary(int row) {
		if (row != northBoundary)
			northBoundary = row;
		else{
			//throw exception
		}
	}

	private void setSouthBoundary(int row) {
		if (row != southBoundary)
			southBoundary = row;
		else {
			// throw exception
		}
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
