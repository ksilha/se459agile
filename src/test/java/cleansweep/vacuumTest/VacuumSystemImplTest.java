package cleansweep.vacuumTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.vacuum.VacuumSystem;
import cleansweep.vacuum.VacuumSystemFactory;

public class VacuumSystemImplTest {
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
	public void isEmptyTest() {
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
	
	@Test
	public void isEmptyTest2() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		v.clean();
		assertFalse(v.isEmpty());

		
	}
}
