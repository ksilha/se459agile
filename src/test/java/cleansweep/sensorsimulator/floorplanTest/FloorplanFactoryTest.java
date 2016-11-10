package cleansweep.sensorsimulator.floorplanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;

public class FloorplanFactoryTest {
	@Test
	public void createFloorPlanTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorPlan1.txt");
		assertNotNull(f);
	}
}
