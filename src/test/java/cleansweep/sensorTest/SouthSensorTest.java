package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.SouthSensor;

public class SouthSensorTest {

	public void getInstanceTest() {
		SouthSensor e = SouthSensor.getInstance();
		assertNotNull(e);
	}
	
	@Test
	public void detectTest() {
		SouthSensor e = SouthSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
