package cleansweep.sensorsimulator.cell;

public class WallCellImpl implements Cell 
{
	Boolean obstruction;
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
	
	public WallCellImpl()
	{
		obstruction = true;
	}
}
