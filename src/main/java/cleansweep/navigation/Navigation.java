package cleansweep.navigation;
import cleansweep.sensorsimulator.cell.*;
import cleansweep.sensorsimulator.floorplan.*;


public class Navigation {
	Floorplan plan;
	Cell[][] cells;
	
	public Navigation(Floorplan floorplan)
	{
		plan = floorplan;
	}
	
	//Should this be a void function, updating a global array?
	void locatePermiter()
	{
		int xDimension = 0;
		int yDimension = 0;
		
		
		Cell[][] dimensions = new Cell[xDimension][yDimension];
		cells = dimensions;
	}
	
	void traverseFloorPlan()
	{
		
	}

}
