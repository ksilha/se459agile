package cleansweep.sensorcontrollerTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ControllerFacadeTest {
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

}
