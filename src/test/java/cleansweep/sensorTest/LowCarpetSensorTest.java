package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.LowCarpetSensor;

public class LowCarpetSensorTest {
	@Test
	public void getInstanceTest() {
		LowCarpetSensor e = LowCarpetSensor.getInstance();
		assertNotNull(e);
	}
	
	@Test
	public void detectTest() {
		LowCarpetSensor e = LowCarpetSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
}
