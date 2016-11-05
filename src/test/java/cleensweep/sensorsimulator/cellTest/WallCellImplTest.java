package cleensweep.sensorsimulator.cellTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;

public class WallCellImplTest {
	@Test
	public void testFloorTypeWall1() {
		Cell wallCell = CellFactory.createCell('+');
		FloorType ft = wallCell.getFloorType();
		assertTrue(ft == FloorType.INVALID);
	}

	@Test
	public void testFloorTypeWall2() {
		Cell wallCell = CellFactory.createCell('-');
		FloorType ft = wallCell.getFloorType();
		assertTrue(ft == FloorType.INVALID);
	}

	@Test
	public void testFloorTypeWall3() {
		Cell wallCell = CellFactory.createCell('|');
		FloorType ft = wallCell.getFloorType();
		assertTrue(ft == FloorType.INVALID);
	}

	@Test
	public void testIsObstructionWall1() {
		Cell wallCell = CellFactory.createCell('-');
		assertTrue(wallCell.isObstruction());
	}

	@Test
	public void testIsObstructionWall2() {
		Cell wallCell = CellFactory.createCell('+');
		assertTrue(wallCell.isObstruction());
	}

	@Test
	public void testIsObstructionWall3() {
		Cell wallCell = CellFactory.createCell('|');
		assertTrue(wallCell.isObstruction());
	}


}
