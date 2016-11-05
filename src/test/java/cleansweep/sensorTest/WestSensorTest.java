package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.WestSensor;

public class WestSensorTest {

	public void getInstanceTest() {
		WestSensor e = WestSensor.getInstance();
		assertNotNull(e);
	}
	
	@Test
	public void detectTest() {
		WestSensor e = WestSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
