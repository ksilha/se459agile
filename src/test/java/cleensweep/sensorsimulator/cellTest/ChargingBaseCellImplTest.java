package cleensweep.sensorsimulator.cellTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;

public class ChargingBaseCellImplTest {
	@Test
	public void testChargingBaseCellGetFloorType() {
		Cell chargeCell = CellFactory.createCell('C');
		FloorType ft = chargeCell.getFloorType();
		assertTrue(ft == FloorType.CHARGING_STATION);
	}

	@Test 
	public void testChargeingBaseCellIsObstruction() { 
		Cell chargeCell = CellFactory.createCell('C');
		assertTrue(chargeCell.isObstruction() == false);
	}
}
