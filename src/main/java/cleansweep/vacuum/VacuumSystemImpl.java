package cleansweep.vacuum;

import cleansweep.sensorcontroller.ControllerFacade;

public class VacuumSystemImpl implements VacuumSystem {
	private static VacuumSystemImpl vacuumSystemImpl;
	private int totalDirtWeight;
	private int capacity = 50;
	
	private VacuumSystemImpl (){
		
	}
	
	public static VacuumSystemImpl getInstance (){
		if (vacuumSystemImpl == null)
			return new VacuumSystemImpl();
		return vacuumSystemImpl;
	}
	
	
	@Override
	public void clean() {
		ControllerFacade.clean();
		if (totalDirtWeight == capacity) {
			try {
				throw new Exception("Bag is full");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		totalDirtWeight++;
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
		return capacity;
	}
}
