package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.HighCarpetSensor;

public class HighCarpetSensorTest {
	@Test
	public void getInstanceTest() {
		HighCarpetSensor e = HighCarpetSensor.getInstance();
		assertNotNull(e);
	}
	
	@Test
	public void detectTest() {
		HighCarpetSensor e = HighCarpetSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
}
