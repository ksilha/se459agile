package cleansweep.sensorcontroller;

import cleansweep.sensorsimulator.simulation.SimulationControllerImpl;

public class ControllerFactory {
	public static Controller createController(String hardwareVersion, String floorPlan) {
        if (hardwareVersion.equals("SIMULATION")) {
            return new SimulationControllerImpl(floorPlan);
        }
        else {
            //Todo: Develop impls for communicating with PLCs which interact with real sensors
        	return null;
        }
    }
}
