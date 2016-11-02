package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.navigation.Navigation;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ProcessorImpl implements Processor {
	private CoordinatesDTO currentCoordinate;
	private Navigation navigation;
	private Movement movement;
	private int westBoundary; 
	private int eastBoundary;
	private int southBoundary;
	private int northBoundary;
	private ProcessTracker processTracker;
	
	public ProcessorImpl (CoordinatesDTO currentCoordinate, Navigation nav, Movement mov ){
		checkParameters (currentCoordinate, nav, mov);
		processTracker = processTracker.getInstance();
	}
	
	
	private void checkParameters (CoordinatesDTO current, Navigation nav, Movement mov){
		if (currentCoordinate == null){
			//throw exception
		} else 
			currentCoordinate = current;
		
		if (nav == null ){
			//throw exception
		} else 
			navigation = nav;
		
		if (mov == null){
			//throw exception
		} else
			movement = mov;
	}
	
	private void updateBoundary (Direction dir, int rowOrColumn){
		if (dir == null){
			//Throw exception
		} else{
			if (dir == Direction.WEST && rowOrColumn < westBoundary )
					westBoundary = rowOrColumn;
			else if (dir == Direction.EAST && rowOrColumn > eastBoundary)
					eastBoundary = rowOrColumn;
			else if (dir == Direction.NORTH && rowOrColumn > northBoundary)
					northBoundary = rowOrColumn;
			else if (dir == Direction.SOUTH && rowOrColumn < southBoundary)
					southBoundary = rowOrColumn;
			}
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
	public int shortestDistanceFromChargingStation() {
		return Math.abs(currentCoordinate.column) + Math.abs(currentCoordinate.row);
	}

	@Override
	public boolean hasTraverseAllCells() {
		Direction dir = navigation.getDirection();
		if (dir == null)
			return true;
		
		if (dir == Direction.EAST){
			if (navigation.checkEastObstacle() && navigation.checkSouthObstacle() && currentCoordinate.column == eastBoundary)
				return true;
			else
				return false;
		} else if (dir == Direction.WEST){
			if (navigation.checkWestObstacle() && navigation.checkSouthObstacle() && currentCoordinate.column == westBoundary)
				return true;
			else
				return false;
		}
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

	@Override
	public CoordinatesDTO goToNextCoordinate () {
		CoordinatesDTO newCoordinate = null;
		Direction direction = navigation.getDirection();
		
		if (hasTraverseAllCells()){
			// back to charging station
		} else {
			if (direction == Direction.WEST){
				movement.moveWest();
				newCoordinate = new CoordinatesDTO(currentCoordinate.row-1, currentCoordinate.column);
			}
			else if (direction == Direction.EAST){
				movement.moveEast();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row+1, currentCoordinate.column);
			}
			else if (direction == Direction.NORTH){
				movement.moveNorth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column+1);
			}
			else if (direction == Direction.SOUTH){
				movement.moveSouth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column-1);
			}
			processTracker.addCoordinateToMap(newCoordinate);
			processTracker.addPath(newCoordinate);
		}
		return newCoordinate;
	}
}
