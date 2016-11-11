package cleansweep.sensorsimulator.simulationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class CoordinatesDTOTest {

	@Test
	public void testConstructor() {
		CoordinatesDTO d = new CoordinatesDTO(2,4);
		assertTrue(d.column == 4);
		assertTrue(d.row == 2);
	}
	
	@Test
	public void toStringTest() {
		CoordinatesDTO d = new CoordinatesDTO(2,4);
		String s = d.toString();
		assertEquals(s, "(2,4)");
	}
	
	@Test
	public void equalsTest() {
	}
	
	@Test
	public void hashCodeTest() {
		CoordinatesDTO d = new CoordinatesDTO(2,4);
		int hc = d.hashCode();
		assertEquals(hc,16403);
	}
	
	/*
	 NOTES FOT HASH CODE TEST
	 (R,C)
	 DTO = (2,4)
	 31 * 17 + 2 = 529
	 31 * 529 + 4 = 16403
	 Result = 16,403
	 */
}
