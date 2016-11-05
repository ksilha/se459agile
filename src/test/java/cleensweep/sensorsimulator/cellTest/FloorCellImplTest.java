package cleensweep.sensorsimulator.cellTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;

public class FloorCellImplTest {
	@Test
	public void testFloorTypeHighCarpet() {
		Cell hFloorCell = CellFactory.createCell('H');
		FloorType t = hFloorCell.getFloorType();
		assertTrue(t == FloorType.HIGH_PILE_CARPET);
	}

	@Test
	public void testFloorTypeLowCarpet() {
		Cell lFloorCell = CellFactory.createCell('L');
		FloorType t = lFloorCell.getFloorType();
		assertTrue(t == FloorType.LOW_PILE_CARPET);
	}

	@Test
	public void testFloorTypeBare() {
		Cell bFloorCell = CellFactory.createCell('B');
		FloorType t = bFloorCell.getFloorType();
		assertTrue(t == FloorType.BARE_FLOOR);
	}

	@Test
	public void testFloorCellIsObstructionH() {
		Cell floorCell = CellFactory.createCell('H');
		assertTrue(floorCell.isObstruction() == false);
	}

	@Test
	public void testFloorCellIsObstructionL() {
		Cell floorCell = CellFactory.createCell('L');
		assertTrue(floorCell.isObstruction() == false);
	}

	@Test
	public void testFloorCellIsObstructionB() {
		Cell floorCell = CellFactory.createCell('B');
		assertTrue(floorCell.isObstruction() == false);
	}

}
