package cleansweep.sensorTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cleansweep.sensor.DirtSensor;

public class DirtSensorTest {
	public void getInstanceTest() {
		DirtSensor b = DirtSensor.getInstance();
		assertNotNull(b);
	}
	
	@Test
	public void detectTest() {
		DirtSensor b = DirtSensor.getInstance();
		boolean d = b.detect();
		assertNotNull(b.detect());
	}
}
