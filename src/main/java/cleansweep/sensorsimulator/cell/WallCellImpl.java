package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class WallCellImpl implements Cell 
{
	Boolean obstruction;
	private static FloorType floorType = FloorType.INVALID;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public WallCellImpl()
	{
		obstruction = true;
	}

	@Override
	public FloorType getFloorType() {
		return floorType;
	}
}
