package cleensweep.sensorsimulator.cellTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;
import cleansweep.sensorsimulator.cell.DoorCellImpl;

public class DoorCellImplTest {
	@Test
	public void TestFloorTypeDoorway() {
		Cell doorCell = CellFactory.createCell('D');
		FloorType ft = doorCell.getFloorType();
		assertTrue(ft == FloorType.BARE_FLOOR);
	}

	@Test 
	//tests default constructor
	public void testDoorwayIsObstructionDefault() { 
		Cell doorCell = CellFactory.createCell('D');
		assertTrue(doorCell.isObstruction() == true);
	}

	@Test
	public void testDoorwayIsObstructionClosed2() {
		Cell doorCell = new DoorCellImpl(true);
		assertTrue(doorCell.isObstruction() == true);
	}

	@Test
	public void testDoorwayIsObstructionOpen() {
		Cell doorCell = new DoorCellImpl(false);
		assertTrue(doorCell.isObstruction() == false);
	}
}
