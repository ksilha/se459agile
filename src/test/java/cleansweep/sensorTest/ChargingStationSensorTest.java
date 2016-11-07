package cleansweep.sensorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensor.ChargingStationSensor;

public class ChargingStationSensorTest {

	@Test
	public void getInstanceTest() {
		ChargingStationSensor b = ChargingStationSensor.getInstance();
		assertNotNull(b);
	}
	
	@Test
	public void detectTest() {
		ChargingStationSensor b = ChargingStationSensor.getInstance();
		boolean d = b.detect();
		assertNotNull(b.detect());
	}
}
