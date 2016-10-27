package battery;

public class Battery {
	BatteryInst batteryInstance = BatteryInst.getInstance();
	public int getEnergy()
	{
		return batteryInstance.getEnergy();
	}
	public void setEnergy(int energyChange)
	{
		batteryInstance.setEnergy(energyChange);
	}
}
