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
