package cleansweep.sensorcontroller;

import cleansweep.sensorsimulator.simulation.SimulationControllerImpl;

public class ControllerFactory {
	public static Controller createController(String hardwareVersion) {
        if (hardwareVersion.equals("SIMULATION")) {
            return new SimulationControllerImpl();
        }
        else {
            //Todo: Develop impls for communicating with PLCs which interact with real sensors
        	return null;
        }
    }
}
