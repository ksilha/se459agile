package cleansweep.obstacles;

public class Obstacle {
	protected static String location; //change to something else ...  location object or cell
	protected boolean canGoOver = false; // better name?
	
	Obstacle(String location) {
		Obstacle.location = location;
	}
	
	String getLocation() {
		return Obstacle.location;
	}
	
	boolean mustAvoid() {
		return this.canGoOver;
	}
}
