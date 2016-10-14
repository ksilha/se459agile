package cleansweep.sensor;

public class SensorFactory {
	
	public static Sensor buildSensor (SensorType type){
		Sensor sensor = null;
		
		switch (type){
			case DIRT:
				sensor = new DirtSensor ();
				break;
			
			case FLOOR:
				sensor = new FloorSensor ();
				break;
				
			case OBSTACLE:
				sensor = new ObstacleSensor ();
				break;
			
			default:
				// throw execption;
				break;
		}
		
		return sensor;
		
	}
}
