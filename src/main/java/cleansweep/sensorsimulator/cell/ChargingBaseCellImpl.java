package cleansweep.sensorsimulator.cell;

public class ChargingBaseCellImpl implements Cell 
{
	Boolean obstruction;
	
	ChargingBaseCellImpl()
	{
		obstruction = true;
	}
	
	public Boolean isObstruction()
	{
		return obstruction;
	}
}
