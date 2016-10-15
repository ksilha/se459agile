package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class FloorCellImpl implements Cell 
{
	Boolean obstruction;
	private FloorType floorType;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public FloorCellImpl(FloorType floorType)
	{
		this.floorType = floorType;
		obstruction = false;
	}

	public FloorType getFloorType() {
		return floorType;
	}

}
