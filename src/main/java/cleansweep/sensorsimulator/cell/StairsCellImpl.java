package cleansweep.sensorsimulator.cell;

public class StairsCellImpl implements Cell 
{
	Boolean obstruction;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public StairsCellImpl()
	{
		obstruction = true;
	}

}
