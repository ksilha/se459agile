package cleansweep.movement;

import cleansweep.sensorcontroller.Controller;

public class MovementFactory {
	
	public static Movement createMovement (String movementType, Controller controller){
		if (movementType == null){
			// error message
		} else if (movementType.equals("SIMULATOR"))
			return new MovementImpl (controller);

		return null; 
	
	}
}
