

import cleansweep.movement.Movement;
import cleansweep.movement.MovementFactory;
import cleansweep.navigation.Navigation;
import cleansweep.processor.ProcessInit;
import cleansweep.processor.ProcessTracker;
import cleansweep.processor.Processor;
import cleansweep.processor.ProcessorImpl;
import cleansweep.sensorcontroller.Controller;
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
    	
    	
    	
    	ProcessInit process1 = new ProcessInit ();
    	process1.initializeSimulation("floorPlan1.txt");
    	process1.startRobot();
    	Processor p1 = process1.getProcessor();
		System.out.println("Robot Path :"+p1.getPath().toString());
		System.out.println("");
		System.out.println("LastCoordinate: "+p1.getCurrentCoordinate());
		System.out.println("");
		System.out.println("");
		System.out.println("");
    	
    	
    	ProcessInit process2 = new ProcessInit ();
    	process2.initializeSimulation("floorPlan2.txt");
    	process2.startRobot();
    	Processor p2 = process2.getProcessor();
		System.out.println("Robot Path :"+p2.getPath().toString());
		System.out.println("");
		System.out.println("LastCoordinate: "+p2.getCurrentCoordinate());
		System.out.println("");
		System.out.println("");
		System.out.println("");
    	
    	
    	ProcessInit process3 = new ProcessInit ();
    	process3.initializeSimulation("floorPlan3.txt");
    	process3.startRobot();
    	Processor p3 = process3.getProcessor();
		System.out.println("Robot Path :"+p3.getPath().toString());
		System.out.println("");
		System.out.println("LastCoordinate: "+p3.getCurrentCoordinate());
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
    	ProcessInit process5 = new ProcessInit ();
    	process5.initializeSimulation("floorPlan5.txt");
    	process5.startRobot();
    	Processor p5 = process5.getProcessor();
		System.out.println("Robot Path :"+p5.getPath().toString());
		System.out.println("");
		System.out.println("LastCoordinate: "+p5.getCurrentCoordinate());
		System.out.println("");
		System.out.println("");
		System.out.println("");
    	
    }
}
