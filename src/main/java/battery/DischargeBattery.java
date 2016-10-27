package battery;

public class DischargeBattery extends Battery{
	void useEnergy(int amount)
	{
		setEnergy(-amount);
	}

}
