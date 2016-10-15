package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class ChargingBaseCellImpl implements Cell 
{
	Boolean obstruction;
	private static FloorType floorType = FloorType.CHARGING_STATION;
	
	ChargingBaseCellImpl()
	{
		obstruction = false;
	}
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public FloorType getFloorType() {
		return floorType;
	}
}
