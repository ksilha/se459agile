package cleansweep.sensor;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public abstract class ObstacleSensor extends Sensor {
	private Direction direction;
	
	public ObstacleSensor(Direction dir) {
		super (SensorType.OBSTACLE);
		setDirection (dir);
	}
	
	private void setDirection (Direction dir){
		if (dir == null)
		{
			//error message
		}
		else
			direction = dir;
	}
	
	public Direction getDirection (){
		return direction;
	}

}
