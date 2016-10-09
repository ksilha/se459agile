package cleansweep.sensorsimulator.cell;

public class DoorCellImpl implements Cell  
{
	Boolean obstruction;
	
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

}
