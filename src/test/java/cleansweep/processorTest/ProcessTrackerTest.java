package cleansweep.processorTest;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import cleansweep.processor.ProcessTracker;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ProcessTrackerTest {

	@Test
	public void getInstanceTest() {
		ProcessTracker t = ProcessTracker.getInstance();
		assertNotNull(t);
	}
	
	@Test
	public void getPathTest() {
		ProcessTracker t = ProcessTracker.getInstance();
		ArrayList<CoordinatesDTO> path = t.getPath();
		//assertThat(subClass, instanceOf(BaseClass.class));
		assertNotNull(path);
	}
	
	@Test
	public void getVisitedCoordinatesMap() {
		ProcessTracker t = ProcessTracker.getInstance();
		HashMap<CoordinatesDTO, Integer> vcm = t.getVisitedCoordinatesMap();
		assertNotNull(vcm);
	}
	
	@Test
	public void addPathTest() throws Exception {
		ProcessTracker t = ProcessTracker.getInstance();
		CoordinatesDTO c = new CoordinatesDTO(2,4);
		t.addPath(c);
		assertTrue(t.getCurrentCoordinate() == c);
	}
	
	/*@Test (expected = Exception.class)
	public void addPathTestException() throws Exception {
		ProcessTracker t = ProcessTracker.getInstance();
		t.addPath(null);
	}*/
	
	@Test
	public void testGetCurrentCoordinate() {
		ProcessTracker t = ProcessTracker.getInstance();
		CoordinatesDTO c = t.getCurrentCoordinate();
		assertNotNull(c);
	}
	
	/*@Test (expected = Exception.class)
	public void addCoordinateToMap() throws Exception {
		ProcessTracker t = ProcessTracker.getInstance();
		t.addCoordinateToMap(null);
		
	}*/
	
	
	@Test
	public void addCoordinateToMapTest() {
		ProcessTracker t = ProcessTracker.getInstance();
		CoordinatesDTO d = new CoordinatesDTO(12,17);
		t.addCoordinateToMap(d);
		
		//test first branch
		assertTrue(t.getVisitedCoordinatesMap().containsKey(d));
		t.addCoordinateToMap(d);
		//test second branch
		assertTrue(t.getVisitedCoordinatesMap().containsKey(d));


		
		

	}
	
	
	
	
	
}
