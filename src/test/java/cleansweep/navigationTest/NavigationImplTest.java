package cleansweep.navigationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.navigation.Navigation;
import cleansweep.navigation.NavigationImpl;

public class NavigationImplTest {
	@Test
	public void getInstanceTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		assertNotNull(n);
	}
	
	@Test
	public void testGetDirection() {
	}
	
	@Test
	public void checkNorthObstacleTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		boolean b = n.checkNorthObstacle();
		assertNotNull(b);
	}
	
	@Test
	public void checkSouthObstacleTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		boolean b = n.checkSouthObstacle();
		assertNotNull(b);
	}
	
	@Test
	public void checkEastObstacleTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		boolean b = n.checkEastObstacle();
		assertNotNull(b);
	}
	
	@Test
	public void checkWestObstacleTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		boolean b = n.checkWestObstacle();
		assertNotNull(b);
	}
	
	@Test
	public void distanceToChargerTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		int d = n.distanceToCharger();
		assertNotNull(d);

	}
	
	@Test
	public void resetSensorsTest() throws Exception {
		Navigation n = NavigationImpl.getInstance();
		n.resetSensors();
		
		assertFalse(n.checkNorthObstacle());
		assertFalse(n.checkEastObstacle());
		assertFalse(n.checkSouthObstacle());
		assertFalse(n.checkWestObstacle());
	}
	
	

}
