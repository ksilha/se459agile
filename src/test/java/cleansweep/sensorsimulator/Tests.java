package cleansweep.sensorsimulator;
import org.junit.*;

import battery.Battery;
import battery.DischargeBattery;

import static org.junit.Assert.*;

import java.util.HashMap;

import cleansweep.movement.Movement;
import cleansweep.movement.MovementFactory;
import cleansweep.movement.MovementImpl;
import cleansweep.navigation.Navigation;
import cleansweep.navigation.NavigationFactory;
import cleansweep.navigation.NavigationImpl;
import cleansweep.processor.ProcessInit;
import cleansweep.processor.ProcessorImpl;
import cleansweep.sensor.*;
import cleansweep.sensorcontroller.*;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;
import cleansweep.sensorsimulator.cell.DoorCellImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;
import cleansweep.vacuum.VacuumSystem;
import cleansweep.vacuum.VacuumSystemFactory;


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

//ControllerFacade Tests

	@Test
	public void testSenseObstruction() {
		ControllerFacade.initialize("SIMULATION");
		Boolean obstructionN = ControllerFacade.senseObstruction(Direction.NORTH);
		Boolean obstructionS = ControllerFacade.senseObstruction(Direction.SOUTH);
		Boolean obstructionE =ControllerFacade.senseObstruction(Direction.EAST);
		Boolean obstructionW =ControllerFacade.senseObstruction(Direction.WEST);

		//Check if there is a way to know what the result should be ?
		assertNotNull(obstructionN);
		assertNotNull(obstructionS);
		assertNotNull(obstructionE);
		assertNotNull(obstructionW);
	}

	@Test
	public void testSenseFloorType() {
		ControllerFacade.initialize("SIMULATION");
		FloorType ft = ControllerFacade.senseFloorType();
		
		assertNotNull(ft);
		assertTrue(ft.equals(FloorType.BARE_FLOOR) ||
			ft.equals(FloorType.CHARGING_STATION) ||
			ft.equals(FloorType.BARE_FLOOR) ||
			ft.equals(FloorType.HIGH_PILE_CARPET) ||
			ft.equals(FloorType.LOW_PILE_CARPET) ||
			ft.equals(FloorType.INVALID));
	}

	@Test
	public void testMove() {
		ControllerFacade.initialize("SIMULATION");
		
		assertNotNull(ControllerFacade.move(Direction.NORTH));
		assertNotNull(ControllerFacade.move(Direction.SOUTH));
		assertNotNull(ControllerFacade.move(Direction.EAST));
		assertNotNull(ControllerFacade.move(Direction.WEST));
	}

	@Test
	public void testCheckPercentExplored() {
		ControllerFacade.initialize("SIMULATION");

		int percent = ControllerFacade.checkPercentExplored();
		System.out.println(percent + "Percent Explored");
		assertNotNull(percent);
	}

	@Test
	public void testCurrentLocation() {
		ControllerFacade.initialize("SIMULATION");

		CoordinatesDTO cl = ControllerFacade.currentLocation();
		assertNotNull(cl);
	}

//Sensor Tests
	
	@Test
	public void setSensorTypeTest() {
		Sensor ds = SensorFactory.createDirtSensor();
		Sensor fs = SensorFactory.createFloorSensor(FloorType.BARE_FLOOR);
		
		assertTrue(ds.getType() == SensorType.DIRT);
		assertTrue(fs.getType() == SensorType.FLOOR);
	}
	
	@Test
	public void testGetWestSensor() {
		WestSensor ws = WestSensor.getInstance();
		assertNotNull(ws);
		assertTrue(ws.getClass() == WestSensor.class);
	}
	
	@Test
	public void testCheckWest() {
		WestSensor ws = WestSensor.getInstance();
		boolean obstruction = ws.detect();
		assertNotNull(obstruction);
	}
	
	@Test
	public void testGetSouthSensor() {
		SouthSensor ss = SouthSensor.getInstance();
		assertNotNull(ss);
		assertTrue(ss.getClass() == SouthSensor.class);
	}
	
	@Test
	public void testCheckSouth() {
		SouthSensor ss = SouthSensor.getInstance();
		boolean obstruction = ss.detect();
		assertNotNull(obstruction);
	}
	
	@Test
	public void testGetNorthSensor() {
		NorthSensor ns = NorthSensor.getInstance();
		assertNotNull(ns);
		assertTrue(ns.getClass() == NorthSensor.class);
	}
	
	@Test
	public void testCheckNorth() {
		NorthSensor ns = NorthSensor.getInstance();
		boolean obstruction = ns.detect();
		assertNotNull(obstruction);
	}
	
	@Test
	public void testGetEastSensor() {
		EastSensor es = EastSensor.getInstance();
		assertNotNull(es);
		assertTrue(es.getClass() == EastSensor.class);
	}
	
	@Test
	public void testCheckEast() {
		EastSensor es = EastSensor.getInstance();
		boolean obstruction = es.detect();
		assertNotNull(obstruction);
	}
	
	//Movement Tests
	
	@Test
	public void testMovementImpl() {
		Controller cl = ControllerFactory.createController("SIMULATION");
		MovementImpl ml = new MovementImpl();
		
		assertNotNull(ml);
	}
	

	
	@Test
	public void testCreateMovement() throws Exception {
		Controller cl = ControllerFactory.createController("SIMULATION");
		Movement m = MovementFactory.createMovement("SIMULATOR");
		assertNull("Movement m is null", m);
	}
	
	//change to correct type of exception 
	@Test
	public void testCreateMovementWithNullMovementType() throws Exception {
		Controller cl = ControllerFactory.createController("SIMULATION");
		Movement m = MovementFactory.createMovement(null);
	}
	
	//Battery Tests
	@Test
	public void testNewBattery() {
		Battery b = new Battery();
		int e = b.getEnergy();
		assertEquals(e,100);
	}
	
	@Test
	public void testSetEnergy() throws Exception {
		Battery b = new Battery();
		int e = b.getEnergy();
		b.setEnergy(-50);
		assertEquals("Energy is " + b.getEnergy() + " but should be 50", b.getEnergy(), 50);
	}
	
	@Test(expected=Exception.class)
		public void addEnergyOver100() throws Exception {
		Battery b = new Battery() ;
		int e1 = b.getEnergy();
		b.setEnergy(101);
	}

	//Vaccuum Tests
	@Test
	public void testCreateVaccuum() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		assertNotNull("Error, VacuumSystem v was not created", v);
	}
	
	@Test
	public void testClean() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		int dirt = v.getTotalDirtWeight();
		v.clean();
		assertTrue("There was an error: starting dirt weight was " + dirt + " current dirt weight is " + v.getTotalDirtWeight(),v.getTotalDirtWeight() > dirt);
	}
	
	@Test
	public void testIsFull() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		int i = 0;
		while (!v.isFull()) {
			v.clean();
			i++;
		}
		assertEquals(v.getTotalDirtWeight(), 50);
	}
	
	@Test
	public void testIsEmpty() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		assertTrue(v.isEmpty());

		
	}
	
	@Test(expected=Exception.class)
	public void testOverCapacity() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		int i = 0;
		while (i < 100) {
			v.clean();
			i++;
		}
	}
	
	@Test
	public void testEmptyDirt() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		int i = 0;
		while (!v.isFull()) {
			v.clean();
			i++;
		}
		int currentDirt = v.getTotalDirtWeight();
		v.emptyDirtBasket();
		assertTrue("Error - After emptying, dirt weight is " + v.getTotalDirtWeight(),currentDirt == 50 && v.getTotalDirtWeight() == 0);
	}
	
	@Test
	public void testGetDirtCapacity() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		assertEquals("Dirt capacity is " + v.getCapacity() + " but should be 50", v.getCapacity(), 50);
	}
}
