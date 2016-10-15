package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class StairsCellImpl implements Cell 
{
	Boolean obstruction;
	private static FloorType floorType = FloorType.INVALID;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public StairsCellImpl()
	{
		obstruction = true;
	}

	@Override
	public FloorType getFloorType() {
		return floorType;
	}

}
