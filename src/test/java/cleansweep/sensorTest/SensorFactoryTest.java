package cleansweep.sensorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensor.DirtSensor;
import cleansweep.sensor.Sensor;
import cleansweep.sensor.SensorFactory;
import cleansweep.sensor.SensorType;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class SensorFactoryTest {

	@Test
	public void createDirtSensorTest() {
		Sensor ds = SensorFactory.createDirtSensor();
		assertNotNull(ds);
	}
	
	@Test
	public void createObstacleSensorTestEast() throws Exception {
		Sensor os = SensorFactory.createObstacleSensor(Direction.EAST);
		assertNotNull(os);
	}
	
	@Test
	public void createObstacleSensorTestWest() throws Exception {
		Sensor os = SensorFactory.createObstacleSensor(Direction.WEST);
		assertNotNull(os);
	}
	
	@Test
	public void createObstacleSensorTestNorth() throws Exception {
		Sensor os = SensorFactory.createObstacleSensor(Direction.NORTH);
		assertNotNull(os);
	}
	
	@Test
	public void createObstacleSensorTestSouth() throws Exception {
		Sensor os = SensorFactory.createObstacleSensor(Direction.SOUTH);
		assertNotNull(os);
	}
	
	@Test (expected = Exception.class)
	public void createObstacleSensorTestException() throws Exception {
		Sensor os = SensorFactory.createObstacleSensor(null);
		
	}
	
	@Test
	public void createFloorSensorTestBARE_FLOOR() throws Exception {
		Sensor fs = SensorFactory.createFloorSensor(FloorType.BARE_FLOOR);
		assertNotNull(fs);
	}
	
	@Test
	public void createFloorSensorTestLOW_PILE_CARPET() throws Exception {
		Sensor fs = SensorFactory.createFloorSensor(FloorType.LOW_PILE_CARPET);
		assertNotNull(fs);
	}
	
	@Test
	public void createFloorSensorTestHIGH_PILE_CARPET() throws Exception {
		Sensor fs = SensorFactory.createFloorSensor(FloorType.HIGH_PILE_CARPET);
		assertNotNull(fs);
	}
	
	@Test
	public void createFloorSensorTestCHARGING_STATION() throws Exception {
		Sensor fs = SensorFactory.createFloorSensor(FloorType.CHARGING_STATION);
		assertNotNull(fs);
	}
	
	@Test (expected = Exception.class)
	public void createFloorSensorTestException() throws Exception {
		Sensor fs = SensorFactory.createFloorSensor(null);	
	}
	
	@Test
	public void setSensorTypeTest() throws Exception {
		Sensor ds = SensorFactory.createDirtSensor();
		Sensor fs = SensorFactory.createFloorSensor(FloorType.BARE_FLOOR);
		
		assertTrue(ds.getType() == SensorType.DIRT);
		assertTrue(fs.getType() == SensorType.FLOOR);
	}
	
}
