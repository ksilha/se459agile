package cleansweep.movement;

import cleansweep.sensorcontroller.Controller;

public class MovementFactory {
	
	public static Movement createMovement (String movementType){
		if (movementType == null){
			// error message
		} else if (movementType.equals("VIRTUAL_WHEEL"))
			return new MovementImpl ();

		return null; 
	
	}
}
