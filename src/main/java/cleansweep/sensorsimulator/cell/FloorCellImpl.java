package cleansweep.sensorsimulator.cell;

import java.util.Random;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class FloorCellImpl implements Cell 
{
	Boolean obstruction;
	private FloorType floorType;
	private int dirtLevel;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public FloorCellImpl(FloorType floorType)
	{
		this.floorType = floorType;
		obstruction = false;
		
		Random rand = new Random();
		dirtLevel = rand.nextInt((2 - 1) + 1) + 1;
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
