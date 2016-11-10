package cleansweep.sensorsimulator.floorplanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class FloorplanImplTest {

	@Test
	public void getCurrentCoordinatesTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		assertNotNull(f.getCurrentCoordinates());
	}
	
}
