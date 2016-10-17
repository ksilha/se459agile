package cleansweep.sensor;

import cleansweep.sensor.SensorType;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

public abstract class Sensor {
	private SensorType type = null;
	
	public Sensor (SensorType type){
		setType (type);
		
	}
	
	public SensorType getType (SensorType model){
		return model;
	}
	
	private void setType (SensorType model){
		if (model == null){
			//error message;
		}
	    else
			type = model;
	}
	
	
	public abstract boolean detect ();
	
}
