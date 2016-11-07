package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensor.WestSensor;

public class WestSensorTest {

	@Test
	public void getInstanceTest() {
		WestSensor e = WestSensor.getInstance();
		assertTrue(e.getClass() == WestSensor.class);

	}
	
	@Test
	public void detectTest() {
		WestSensor e = WestSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
