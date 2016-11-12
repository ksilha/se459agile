package cleansweep.movementTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.battery.Battery;
import cleansweep.movement.MovementImpl;
import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFactory;

public class MovementImplTest {
	
	@Test
	public void testMovementImpl() {
		Controller cl = ControllerFactory.createController("SIMULATION", "floorplan.txt");
		MovementImpl ml = new MovementImpl();
		
		assertNotNull(ml);
	}
	

	
	
}
