package cleansweep.sensorsimulator;

import cleansweep.sensorsimulator.simulation.Simulation;
import cleansweep.sensorsimulator.simulation.SimulationFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Simulation mySimulation = SimulationFactory.createSimulation();
    }
}
