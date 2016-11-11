package cleansweep.battery;

public class Battery {
	BatteryInst batteryInstance = BatteryInst.getInstance();
	
	public Battery()
	{
		batteryInstance.resetEnergy();
	}
	public int getEnergy()
	{
		return batteryInstance.getEnergy();
	}
	public void setEnergy(int energyChange) throws Exception
	{
		batteryInstance.setEnergy(energyChange);
	}
	
	public boolean lowEnergy()
	{
		return batteryInstance.getLowEnergy();
	}
	
	public void setLowEnergy(boolean state)
	{
		batteryInstance.setLowEnergy(state);
	}
}
