package cleansweep.sensorsimulator.simulation;

public class SimulationFactory {
	public static Simulation createSimulation() {
        return new SimulationImpl();
    }
}
