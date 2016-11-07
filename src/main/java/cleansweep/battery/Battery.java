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
}
