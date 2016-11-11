package cleansweep.battery;

public class BatteryInst {
	private static BatteryInst battery = new BatteryInst();
	private int energy;
	private boolean lowEnergy;
	
	private BatteryInst()
	{
		energy = 100;
		lowEnergy = false;
	}
	
	public static BatteryInst getInstance()
	{
		return battery;
	}
	
	public int getEnergy()
	{
		return energy;
	}

	public void setEnergy(int amount) throws Exception
	{
		energy += amount;
		if (energy > 100) {
			throw new Exception("Charge cannot be over 100");
		}
		else if(energy < 0)
		{
			throw new Exception("Charge cannot be less than 0");
		}
	}
	
	public void resetEnergy()
	{
		energy = 100;
	}
	
	public boolean getLowEnergy()
	{
		return lowEnergy;
	}
	
	public void setLowEnergy(boolean state)
	{
		lowEnergy = state;
	}
}
