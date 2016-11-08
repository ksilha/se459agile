package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.movement.MovementFactory;
import cleansweep.navigation.Navigation;
import cleansweep.navigation.NavigationFactory;
import cleansweep.sensor.Sensor;
import cleansweep.sensor.SensorFactory;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;
import cleansweep.vacuum.VacuumSystem;
import cleansweep.vacuum.VacuumSystemFactory;

public class ProcessorImpl implements Processor {
	private Sensor dirtSensor;
	private Sensor lowCarpetSensor;
	private Sensor highCarpetSensor;
	private Sensor chargingStationSensor;
	private Sensor bareFloorSensor;
	private VacuumSystem vacuumSystem;
	private CoordinatesDTO currentCoordinate;
	private HashMap <CoordinatesDTO,Integer> visitedMap;
	private Navigation navigation;
	private Movement movement;
	private int westBoundary; 
	private int eastBoundary;
	private int southBoundary;
	private int northBoundary;
	private ProcessTracker processTracker;
	private VacuumSystem vacuum;
	
	public ProcessorImpl () throws Exception{
		createSensors();
		createVacuumSystem ();
		movement = MovementFactory.createMovement("VIRTUAL_WHEEL");
		processTracker = processTracker.getInstance();
		navigation = NavigationFactory.createNavigation();
	}
	
	private void createSensors () throws Exception{
		dirtSensor = SensorFactory.createDirtSensor();
		bareFloorSensor = SensorFactory.createFloorSensor(FloorType.BARE_FLOOR);
		lowCarpetSensor = SensorFactory.createFloorSensor(FloorType.LOW_PILE_CARPET);
		highCarpetSensor = SensorFactory.createFloorSensor(FloorType.HIGH_PILE_CARPET);
		chargingStationSensor = SensorFactory.createFloorSensor(FloorType.CHARGING_STATION);
	}
	
	private void createVacuumSystem (){
		vacuumSystem = VacuumSystemFactory.createVacuum();
	}
	
	private void checkParameters (Movement mov){
		if (mov == null){
			//throw exception
		} else
			movement = mov;
	}
	
	private void updateBoundary (Direction dir, int rowOrColumn){
		if (dir == null){
			//Throw exception
		} else{
			if (dir == Direction.WEST && rowOrColumn < westBoundary && navigation.checkWestObstacle())
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
	public boolean hasTraverseAllCells(Direction dir) {
		currentCoordinate = processTracker.getCurrentCoordinate();
		if (dir==null)
			return true;
		
		if (dir == Direction.EAST){
			if (navigation.checkEastObstacle() && navigation.checkSouthObstacle() && currentCoordinate.row == eastBoundary)
				return true;
			else
				return false;
		} else if (dir == Direction.WEST){
			if (navigation.checkWestObstacle() && navigation.checkSouthObstacle()&& currentCoordinate.row == westBoundary){
				return true;
			}
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
	public void goToNextCoordinate () {
		CoordinatesDTO newCoordinate = null;
		
		currentCoordinate = processTracker.getCurrentCoordinate();
		processTracker.addCoordinateToMap(currentCoordinate);
		processTracker.addPath(currentCoordinate);
		visitedMap = processTracker.getVisitedCoordinatesMap();
		
		
		Direction direction = navigation.getDirection(currentCoordinate, visitedMap);
			while (!hasTraverseAllCells(direction))
			{	
				System.out.println("Current Coordinate: "+currentCoordinate.toString());
				System.out.println("Current Direction: "+ direction.toString());
				System.out.println("");
			if (direction == Direction.WEST){
				movement.moveWest();
				newCoordinate = new CoordinatesDTO(currentCoordinate.row, currentCoordinate.column-1);
				updateBoundary (Direction.WEST, newCoordinate.row);
			}
			else if (direction == Direction.EAST){
				movement.moveEast();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column+1);
				updateBoundary (Direction.EAST, newCoordinate.row);
			}
			else if (direction == Direction.NORTH){
				movement.moveNorth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row+1, currentCoordinate.column);
				updateBoundary (Direction.EAST, newCoordinate.column);
			}
			else if (direction == Direction.SOUTH){
				movement.moveSouth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row-1, currentCoordinate.column);
			}
			
			processTracker.addCoordinateToMap(newCoordinate);
			processTracker.addPath(newCoordinate);
			direction = navigation.getDirection(newCoordinate,visitedMap);
			checkDirt();
			System.out.println("Total dirt picked up: "+vacuumSystem.getTotalDirtWeight());
			System.out.println("Remaining Dirt Bag Capacity: "+vacuumSystem.getCapacity());
			}
	}
	
	
	private void checkDirt(){
		if (dirtSensor.detect()){
			System.out.println("dirt detected");
			vacuumSystem.clean();
		}
	}

	@Override
	public ArrayList<CoordinatesDTO> getPath() {
		return processTracker.getPath();
	}

	@Override
	public boolean getEastObstacle() {
		return navigation.checkEastObstacle();
	}

	@Override
	public boolean getWestObstacle() {
		return navigation.checkWestObstacle();
	}

	@Override
	public boolean getNorthObstacle() {
		return navigation.checkNorthObstacle();
	}

	@Override
	public boolean getSouthObstacle() {
		return navigation.checkSouthObstacle();
	}

	@Override
	public CoordinatesDTO getCurrentCoordinate() {
		return currentCoordinate;
	}

	@Override
	public int getTotalDirtPickUp() {
		return vacuumSystem.getTotalDirtWeight();
	}

	@Override
	public int remainingBagCapacity() {
		return vacuumSystem.getCapacity();
	}
}
