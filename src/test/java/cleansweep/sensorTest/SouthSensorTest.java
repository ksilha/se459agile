package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensor.SouthSensor;

public class SouthSensorTest {

	@Test
	public void getInstanceTest() {
		SouthSensor e = SouthSensor.getInstance();
		assertNotNull(e);
		assertTrue(e.getClass() == SouthSensor.class);

	}
	
	@Test
	public void detectTest() {
		SouthSensor e = SouthSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}

