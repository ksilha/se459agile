package cleansweep.obstacles;

public class Dirt extends Obstacle {

	Dirt(String location) { 
		super(location);
		this.canGoOver= true;	
	}
}
