package cleansweep.navigation;

import java.util.HashMap;

import cleansweep.sensor.EastSensor;
import cleansweep.sensor.NorthSensor;
import cleansweep.sensor.SouthSensor;
import cleansweep.sensor.WestSensor;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class NavigationFactory {
	
	public static Navigation createNavigation(CoordinatesDTO current, NorthSensor northSensor, SouthSensor southSensor, EastSensor eastSensor, WestSensor westSensor, HashMap <CoordinatesDTO, Integer> map ){
		return new NavigationImpl (current, northSensor, southSensor, eastSensor, westSensor, map);
	}

}
