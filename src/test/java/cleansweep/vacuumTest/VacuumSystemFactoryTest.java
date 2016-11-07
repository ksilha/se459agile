package cleansweep.vacuumTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.vacuum.VacuumSystem;
import cleansweep.vacuum.VacuumSystemFactory;

public class VacuumSystemFactoryTest {
	@Test
	public void createVacuumTest() {
		VacuumSystem v = VacuumSystemFactory.createVacuum();
		assertNotNull(v);
	}

}
