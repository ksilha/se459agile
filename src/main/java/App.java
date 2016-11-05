

import cleansweep.processor.ProcessInit;
import cleansweep.processor.ProcessTracker;
import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/*
        ControllerFacade.initialize("SIMULATION");
        
        Boolean isObstruction = ControllerFacade.senseObstruction(Direction.NORTH);
        System.out.println("North Obstructed: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.SOUTH);
        System.out.println("South Obstructed: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.EAST);
        System.out.println("East Obstructed: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.WEST);
        System.out.println("West Obstructed: " + isObstruction);
        
        FloorType floorType = ControllerFacade.senseFloorType();
        System.out.println("Floor Type: " + floorType);
        
        Boolean moved = ControllerFacade.move(Direction.NORTH);
        System.out.println("Moved North: " + moved);
        
        moved = ControllerFacade.move(Direction.SOUTH);
        System.out.println("Moved South: " + moved);
        
        floorType = ControllerFacade.senseFloorType();
        System.out.println("Floor Type: " + floorType);
        
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        moved = ControllerFacade.move(Direction.WEST);
        System.out.println("Moved West: " + moved);
        
        floorType = ControllerFacade.senseFloorType();
        System.out.println("Floor Type: " + floorType);
        
        moved = ControllerFacade.move(Direction.WEST);
        System.out.println("Moved West: " + moved);
        
        floorType = ControllerFacade.senseFloorType();
        System.out.println("Floor Type: " + floorType);
        */
    	
    	ProcessInit process = new ProcessInit ();
    	
    	process.initializeSimulation();
    	process.startRobot();
    	ProcessTracker pt = ProcessTracker.getInstance();
    	pt.getPath().toString();
    }
}
