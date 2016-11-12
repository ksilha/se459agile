package cleansweep.processorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.processor.ProcessorImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ProcessorImplTest {

	@Test
	public void getWestBoundryTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getWestBoundary();
		
		assertNotNull(b);
		
	}
	
	@Test
	public void getEastBoundryTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getEastBoundary();
		
		assertNotNull(b);
		
	}
	
	@Test
	public void getNorthBoundryTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getNorthBoundary();
		
		assertNotNull(b);
		
	}
	
	@Test
	public void getSouthBoundryTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getSouthBoundary();
		
		assertNotNull(b);
		
	}
	
	@Test
	public void getEastWestDistanceTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getEastWestDistance();
		
		assertNotNull(b);
		
	}
	
	@Test
	public void getNorthSouthDistanceTest() throws Exception {
		ProcessorImpl p = new ProcessorImpl();
		int b = p.getNorthSouthDistance();
		
		assertNotNull(b);
	}
	
	@Test
	public void hasTraverseAllCellsTest() {
	//ADD TESTS
	}
	
	@Test
	public void goToNextCoordinateTest() {};
	
	@Test
	public void getPathTest(){};
	
	@Test
	public void getEastObstacleTest(){};
	
	@Test
	public void getWestObstacleTest(){};
	
	@Test
	public void getNorthObstacleTest(){};
	
	@Test
	public void getSouthObstacleTest(){};
	
	@Test
	public void getCurrentCoordinateTest() throws Exception{
		ProcessorImpl p = new ProcessorImpl();
		CoordinatesDTO c = p.getCurrentCoordinate();
		assertNotNull(c);
	}

	@Test
	public void getTotalDirtPickupTest() throws Exception{
		ProcessorImpl p = new ProcessorImpl();
		int d = p.getTotalDirtPickUp();
		assertTrue(d >= 0);

	}
	
	@Test
	public void remainingBagCapacityTest() throws Exception{
		ProcessorImpl p = new ProcessorImpl();
		assertTrue(p.remainingBagCapacity() >= 0);

	}
}
