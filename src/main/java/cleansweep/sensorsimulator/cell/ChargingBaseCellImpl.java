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

	public boolean senseDirt() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clean() {
		// TODO Auto-generated method stub
		
	}
}
