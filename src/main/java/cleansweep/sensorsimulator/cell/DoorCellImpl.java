package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class DoorCellImpl implements Cell  
{
	Boolean obstruction;
	private static FloorType floorType = FloorType.BARE_FLOOR;
	
	public DoorCellImpl(Boolean isClosed)
	{
		obstruction = isClosed;
	}
	
	//default construction, door closed by default
	public DoorCellImpl()	
	{
		obstruction = true;
	}
	
	public Boolean isObstruction()
	{
		return obstruction;
	}

	@Override
	public FloorType getFloorType() {
		return floorType;
	}

}
