package cleensweep.sensorcontrollerTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorcontroller.Controller;
import cleansweep.sensorcontroller.ControllerFactory;
import cleansweep.sensorsimulator.simulation.SimulationControllerImpl;

public class ControllerFactoryTest {
	@Test
	public void createControllerTest() {
		Controller s = ControllerFactory.createController("SIMULATION");
		assertNotNull(s);
	}
}



