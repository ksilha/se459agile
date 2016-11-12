package cleansweep.sensorsimulator.floorplanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.floorplan.Floorplan;
import cleansweep.sensorsimulator.floorplan.FloorplanFactory;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class FloorplanImplTest {

	@Test
	public void getCurrentCoordinatesTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		assertNotNull(f.getCurrentCoordinates());
	}
	
	@Test
	public void setCurrentCoordinatesTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = new CoordinatesDTO();
		f.setCurrentCoordinates(c);
		
		assertEquals("incorrect cooridnates returned", c, f.getCurrentCoordinates());
	}
	
	@Test
	public void senseObstructionTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = new CoordinatesDTO();
		
		boolean o = f.senseObstruction(c);
		
		assertNotNull(o);
	}
	
	@Test
	public void senseFloorTypeTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
	
		FloorType f2 = f.senseFloorType();
		
		assertNotNull(f2);
	}
	
	@Test
	public void calculateMovementCoordinatesNORTHTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = f.getCurrentCoordinates();
		int oldRow = c.row;
		int oldCol = c.column;
		
		f.calculateMovementCoordinates(Direction.NORTH);
		
		int newRow = c.row;
		int newCol = c.column;
		
		assertEquals("Row coordinates are not correct",oldRow, newRow);
		assertEquals("Column coordinates are not coorect", oldCol, newCol);
	}
	
	@Test
	public void calculateMovementCoordinatesSOUTHTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = f.getCurrentCoordinates();
		int oldRow = c.row;
		int oldCol = c.column;
		
		f.calculateMovementCoordinates(Direction.SOUTH);
		
		int newRow = c.row;
		int newCol = c.column;
		
		assertEquals("Row coordinates are not correct",oldRow, newRow);
		assertEquals("Column coordinates are not coorect", oldCol, newCol);
	}
	
	@Test
	public void calculateMovementCoordinatesEASTTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = f.getCurrentCoordinates();
		int oldRow = c.row;
		int oldCol = c.column;
		
		f.calculateMovementCoordinates(Direction.EAST);
		
		int newRow = c.row;
		int newCol = c.column;
		
		assertEquals("Row coordinates are not correct",oldRow , newRow);
		assertEquals("Column coordinates are not coorect", oldCol, newCol);
	}
	
	@Test
	public void calculateMovementCoordinatesWESTTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		CoordinatesDTO c = f.getCurrentCoordinates();
		int oldRow = c.row;
		int oldCol = c.column;
		
		f.calculateMovementCoordinates(Direction.WEST);
		
		int newRow = c.row;
		int newCol = c.column;
		
		assertEquals("Row coordinates are not correct",oldRow, newRow);
		assertEquals("Column coordinates are not coorect", oldCol, newCol);
	}
	
	@Test
	public void senseDirtTest() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		assertNotNull(f.senseDirt());

		
	}
	
	@Test
	public void testClean() {
		Floorplan f = FloorplanFactory.createFloorplan("floorplan1.txt");
		f.clean();
		assertFalse(f.senseDirt());
	}
	
}
