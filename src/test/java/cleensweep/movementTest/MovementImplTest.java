package cleensweep.movementTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import cleansweep.movement.MovementImpl;
import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFactory;

public class MovementImplTest {
	
	@Test
	public void testMovementImpl() {
		Controller cl = ControllerFactory.createController("SIMULATION");
		MovementImpl ml = new MovementImpl();
		
		assertNotNull(ml);
	}
	
	
}
