package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensor.NorthSensor;

public class NorthSensorTest {

	@Test
	public void getInstanceTest() {
		NorthSensor e = NorthSensor.getInstance();
		assertTrue(e.getClass() == NorthSensor.class);

	}
	
	@Test
	public void detectTest() {
		NorthSensor e = NorthSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
