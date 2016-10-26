package cleansweep.vacuum;

public class VacuumSystemFactory {
	
	public static VacuumSystem createVacuum (){
		return VacuumSystemImpl.getInstance();
	}
}
