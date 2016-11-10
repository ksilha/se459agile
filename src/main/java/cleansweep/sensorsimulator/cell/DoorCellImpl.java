package cleansweep.sensorsimulator.cell;

import java.util.Random;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class DoorCellImpl implements Cell  
{
	Boolean obstruction;
	private static FloorType floorType = FloorType.BARE_FLOOR;
	private int dirtLevel;
	
	public DoorCellImpl(Boolean isClosed)
	{
		obstruction = isClosed;
		
		Random rand = new Random();
		dirtLevel = rand.nextInt((5 - 1) + 1) + 1;
	}
	
	//default construction, door closed by default
	public DoorCellImpl()	
	{
		obstruction = false;
		
		Random rand = new Random();
		dirtLevel = rand.nextInt((2 - 1) + 1) + 1;
	}
	
	public Boolean isObstruction()
	{
		return obstruction;
	}

	public FloorType getFloorType() {
		return floorType;
	}

	public boolean senseDirt() {
		if (dirtLevel > 0)
			return true;
			
		return false;
	}

	public void clean() {
		if (dirtLevel > 0)
			dirtLevel--;
		
	}

}
