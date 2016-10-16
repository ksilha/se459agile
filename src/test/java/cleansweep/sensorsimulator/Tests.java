package cleansweep.sensorsimulator;
import org.junit.*;
import static org.junit.Assert.*;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.*;

public class Tests {

	//WallCellImpl Tests
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
	
	//StairsCellImp Tests
	
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
	
	//FloorCellImplTests
	
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
	
	//DoorCellImpl Tests
	@Test
	public void TestFloorTypeDoorway() {
		Cell doorCell = CellFactory.createCell('D');
		FloorType ft = doorCell.getFloorType();
		assertTrue(ft == FloorType.DOORWAY);
	}
	
	@Test 
	//test default constructor
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
	
	//ChargingBaseCellImpl Tests
	
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
	
	
	
	
	
	
	
	//FloorPlanImpl Tests
	//FloorPlanFactory Tests
	//SimulationControllerImpl Tests
	
	
	
	
	
	
	



	
	

}
