package cleansweep.sensorsimulator.cellTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;

public class StairsCellImplTest {
	@Test
	public void testIsObstructionStairs() {
		Cell stairCell = CellFactory.createCell('S');
		assertTrue(stairCell.isObstruction());
	}

	@Test
	public void TestFloorTypeStairs() {
		Cell stairCell = CellFactory.createCell('S');
		FloorType ft = stairCell.getFloorType();
		assertTrue(ft == FloorType.INVALID);
	}

}
