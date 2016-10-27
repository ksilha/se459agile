package battery;

public class BatteryInst {
	private static BatteryInst battery = new BatteryInst();
	private int energy;
	
	private BatteryInst()
	{
		energy = 100;
	}
	
	public static BatteryInst getInstance()
	{
		return battery;
	}
	
	public int getEnergy()
	{
		return energy;
	}

	public void setEnergy(int amount)
	{
		energy += amount;
	}
}
