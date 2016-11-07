package cleansweep.sensorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensor.BareFloorSensor;

public class BareFloorSensorTest {

	@Test
	public void getInstanceTest() {
		BareFloorSensor b = BareFloorSensor.getInstance();
		assertNotNull(b);
	}
	
	@Test
	public void detectTest() {
		BareFloorSensor b = BareFloorSensor.getInstance();
		boolean d = b.detect();
		assertNotNull(b.detect());
	}
}
