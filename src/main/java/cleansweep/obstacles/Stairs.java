package cleansweep.obstacles;

public class Stairs extends Obstacle {

	Stairs(String location) {
		super(location);
		this.canGoOver = false;
	}
}
