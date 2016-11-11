package cleansweep.vacuum;

import cleansweep.battery.Battery;
import cleansweep.battery.BatteryInst;
import cleansweep.sensorcontroller.ControllerFacade;

public class VacuumSystemImpl implements VacuumSystem {
	private static VacuumSystemImpl vacuumSystemImpl;
	private int totalDirtWeight;
	private int capacity = 50;
	private Battery battery;
	
	private VacuumSystemImpl (){
		battery = new Battery();
		BatteryInst.getInstance().resetEnergy();
	}
	
	public static VacuumSystemImpl getInstance (){
		if (vacuumSystemImpl == null)
			return new VacuumSystemImpl();
		return vacuumSystemImpl;
	}
	
	
	@Override
	public void clean() {
		ControllerFacade.clean();
		totalDirtWeight++;
		try
		{
			//battery.setEnergy(-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public int getTotalDirtWeight() {
		return totalDirtWeight;
	}

	@Override
	public void emptyDirtBasket() {
		totalDirtWeight = 0;
	}

	@Override
	public boolean isFull() {
		return totalDirtWeight == capacity;
	}

	@Override
	public boolean isEmpty() {
		return totalDirtWeight == 0;
	}

	@Override
	public int getCapacity() {
		return capacity-totalDirtWeight;
	}
}
