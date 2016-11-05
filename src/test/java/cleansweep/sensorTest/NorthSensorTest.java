package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.NorthSensor;

public class NorthSensorTest {

	public void getInstanceTest() {
		NorthSensor e = NorthSensor.getInstance();
		assertNotNull(e);
	}
	
	@Test
	public void detectTest() {
		NorthSensor e = NorthSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
