package cleansweep.sensorsimulator.cell;

public class FloorCellImpl implements Cell 
{
	Boolean obstruction;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public FloorCellImpl()
	{
		obstruction = false;
	}

}
