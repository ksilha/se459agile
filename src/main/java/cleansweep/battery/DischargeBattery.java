package cleansweep.battery;

public class DischargeBattery extends Battery{
	void useEnergy(int amount) throws Exception
	{
		setEnergy(-amount);
	}

}
