package cleansweep.movement;

import cleansweep.sensorcontroller.Controller;

public class MovementFactory {
	
	public static Movement createMovement (String movementType) throws Exception{
		if (movementType == null){
			// error message
			throw new Exception("movement type is null");
		} else if (movementType.equals("VIRTUAL_WHEEL"))
			return new MovementImpl ();

		return null; 
	
	}
}
