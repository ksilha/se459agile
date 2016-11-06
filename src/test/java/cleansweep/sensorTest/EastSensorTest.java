package cleansweep.sensorTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensor.BareFloorSensor;
import cleansweep.sensor.EastSensor;

public class EastSensorTest {
	
	@Test
	public void getInstanceTest() {
		EastSensor e = EastSensor.getInstance();
		assertTrue(e.getClass() == EastSensor.class);

	}
	
	@Test
	public void detectTest() {
		EastSensor e = EastSensor.getInstance();
		boolean d  = e.detect();
		assertNotNull(d);
	}
	
	
}
