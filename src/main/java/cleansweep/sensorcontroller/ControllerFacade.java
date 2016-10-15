package cleansweep.sensorcontroller;

public class ControllerFacade {
	public enum Direction {
	    NORTH, SOUTH, EAST, WEST 
	}
	
	private static Controller controller;
	
	public static void initialize(String hardwareVersion) {
		controller = ControllerFactory.createController(hardwareVersion);
	}
	
	public static String senseObstruction(Direction direction) {
		return controller.senseObstruction(direction);
	}
	
	public static String senseFloorType() {
		
		return controller.senseFloorType();
	}
	
	public static boolean move(Direction direction) {
		return controller.move(direction);
	}
	
	public static int checkPercentExplored() {
		
		
		return controller.checkPercentExplored();
	}
}
