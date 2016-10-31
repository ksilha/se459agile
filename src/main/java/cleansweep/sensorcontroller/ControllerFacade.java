package cleansweep.sensorcontroller;

import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ControllerFacade {
	public enum Direction {
	    NORTH, SOUTH, EAST, WEST 
	}
	
	public enum FloorType {
	    BARE_FLOOR, LOW_PILE_CARPET, HIGH_PILE_CARPET, CHARGING_STATION, INVALID
	}
	
	private static Controller controller;
	
	public static void initialize(String hardwareVersion) {
		controller = ControllerFactory.createController(hardwareVersion);
	}
	
	public static Boolean senseObstruction(Direction direction) {
		return controller.senseObstruction(direction);
	}
	
	public static FloorType senseFloorType() {
		
		return controller.senseFloorType();
	}
	
	public static boolean move(Direction direction) {
		return controller.move(direction);
	}
	
	public static int checkPercentExplored() {
		
		return controller.checkPercentExplored();
	}
	
	public static CoordinatesDTO currentLocation (){
		return controller.getCurrentLocation();
	}
	
	public static Boolean senseDirt() {
		return controller.senseDirt();
	}
	
	public static void clean() {
		controller.clean();
	}
}
