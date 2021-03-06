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
import cleansweep.battery.Battery;

public class ProcessorImpl implements Processor {
	private Sensor dirtSensor;
	private Sensor lowCarpetSensor;
	private Sensor highCarpetSensor;
	private Sensor chargingStationSensor;
	private Sensor bareFloorSensor;
	private FloorType floorType;
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
	private CoordinatesDTO chargingStationLocation = new CoordinatesDTO (0,0);
	private Battery battery;
	
	public ProcessorImpl () throws Exception{
		createSensors();
		createVacuumSystem ();
		movement = MovementFactory.createMovement("VIRTUAL_WHEEL");
		processTracker = processTracker.getInstance();
		navigation = NavigationFactory.createNavigation();
		battery = new Battery();
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
	
	private FloorType getFloorType (){
		if (lowCarpetSensor.detect())
			return FloorType.LOW_PILE_CARPET;
		else if (highCarpetSensor.detect())
			return FloorType.HIGH_PILE_CARPET;
		else if (bareFloorSensor.detect())
			return FloorType.BARE_FLOOR;
		else if (chargingStationSensor.detect())
			return FloorType.CHARGING_STATION;
		return FloorType.INVALID;
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
		visitedMap = processTracker.getVisitedCoordinatesMap();
		addCoordinateToMap (currentCoordinate);
		
		Direction direction = navigation.getDirection(currentCoordinate, visitedMap);
			while (!hasTraverseAllCells(direction) && !isBagFull() && !battery.lowEnergy())
			{	
				if (isDirty())
					clean();
				
				floorType = getFloorType();
				
				System.out.println("Current Coordinate: "+currentCoordinate.toString());
				System.out.println("Current Direction: "+ direction.toString());
				System.out.println("Floor Type: "+floorType);
				System.out.println("Remaining Dirt Bag Capacity: "+vacuumSystem.getCapacity());
				System.out.println("Battery Charge: " + battery.getEnergy());
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
			
			addCoordinateToMap (newCoordinate);
			direction = navigation.getDirection(newCoordinate,visitedMap);
			}
			goBackToChargingStation();
	}
	
	private void addCoordinateToMap (CoordinatesDTO coordinate){		
		processTracker.addCoordinateToMap(coordinate);
		processTracker.addPath(coordinate);
	}
	
	private boolean isDirty (){
		return dirtSensor.detect();
	}
	
	private boolean isBagFull (){
		return vacuumSystem.isFull();
	}
	
	private void clean(){
		while (isDirty() && !isBagFull()){
			vacuumSystem.clean();
		}
	}
	
	private void goBackToChargingStation(){
		CoordinatesDTO newCoordinate = null;
		currentCoordinate = processTracker.getCurrentCoordinate();
		while (!currentCoordinate.equals(chargingStationLocation) && !battery.lowEnergy()){
			Direction dir = navigation.getDirectionToChargingStation(currentCoordinate, visitedMap);
			System.out.println("Current Coordinate: "+currentCoordinate.toString());
			System.out.println("Current Direction: "+ dir.toString());
			
			if (dir == Direction.WEST){
				movement.moveWest();
				newCoordinate = new CoordinatesDTO(currentCoordinate.row, currentCoordinate.column-1);
				updateBoundary (Direction.WEST, newCoordinate.row);
			}
			else if (dir == Direction.EAST){
				movement.moveEast();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row, currentCoordinate.column+1);
				updateBoundary (Direction.EAST, newCoordinate.row);
			}
			else if (dir == Direction.NORTH){
				movement.moveNorth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row+1, currentCoordinate.column);
				updateBoundary (Direction.EAST, newCoordinate.column);
			}
			else if (dir == Direction.SOUTH){
				movement.moveSouth();
				newCoordinate = new CoordinatesDTO (currentCoordinate.row-1, currentCoordinate.column);
			}
			
			addCoordinateToMap (newCoordinate);
			currentCoordinate = newCoordinate;
			System.out.println("Remaining Dirt Bag Capacity: "+vacuumSystem.getCapacity());
			System.out.println("Battery Charge:" + battery.getEnergy());
			System.out.println("");
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
