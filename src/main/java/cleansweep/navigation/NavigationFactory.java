package cleansweep.navigation;

import java.util.HashMap;

import cleansweep.sensor.EastSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.Sensor;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class NavigationFactory {
	
	public static Navigation createNavigation(){
		return NavigationImpl.getInstance();
	}

}
