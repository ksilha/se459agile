package cleansweep.movementTest;

import static org.junit.Assert.*;

import org.junit.Test;
import cleansweep.movement.Movement;
import cleansweep.movement.MovementFactory;
import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFactory;

public class MovementFactoryTest {
	@Test
	public void testCreateMovement() throws Exception {
		Controller cl = ControllerFactory.createController("SIMULATION");
		Movement m = MovementFactory.createMovement("SIMULATOR");
		assertNull("Movement m is null", m);
	}
	
	//change to correct type of exception 
	@Test (expected=Exception.class)
	public void testCreateMovementWithNullMovementType() throws Exception {
		Controller cl = ControllerFactory.createController("SIMULATION");
		Movement m = MovementFactory.createMovement(null);
	}
	
	@Test
	public void testCreateMovementWithVirtualWheelMovementType() throws Exception {
		Controller cl = ControllerFactory.createController("SIMULATION");
		Movement m = MovementFactory.createMovement("VIRTUAL_WHEEL");
		assertNotNull("m is " + m, m);
	}
	
}
