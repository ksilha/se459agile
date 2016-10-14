package cleansweep.obstacles;

public class Furniture extends Obstacle{

	Furniture(String location) {
		super(location);
		this.canGoOver = false;
	}
}
