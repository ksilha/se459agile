package cleansweep.obstacles;

public class Door extends Obstacle {
	boolean isOpen = false;
	
	Door(String location, Boolean isOpen) {
		super(location);
		this.isOpen = isOpen;
		this.canGoOver = isOpen;
}
	
	void openDoor() {
		this.isOpen = true;
		this.canGoOver = true;
	}
	
	void closeDoor() {
		this.isOpen = false;
		this.canGoOver = false;
	}
	
	public boolean isDoorOpen() {
		return this.isOpen;
	}
	
}
