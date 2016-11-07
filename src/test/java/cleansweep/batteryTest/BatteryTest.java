package cleansweep.batteryTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import cleansweep.battery.Battery;

public class BatteryTest {
	
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

}
