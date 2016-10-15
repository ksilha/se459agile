

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ControllerFacade.initialize("SIMULATION");
        
        Boolean isObstruction = ControllerFacade.senseObstruction(Direction.NORTH);
        System.out.println("North: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.SOUTH);
        System.out.println("South: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.EAST);
        System.out.println("East: " + isObstruction);
        
        isObstruction = ControllerFacade.senseObstruction(Direction.WEST);
        System.out.println("West: " + isObstruction);
        
        FloorType floorType = ControllerFacade.senseFloorType();
        System.out.println("Floor Type: " + floorType);
    }
}
