

import cleansweep.sensorcontroller.ControllerFacade;
import cleansweep.sensorcontroller.ControllerFacade.Direction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ControllerFacade.initialize("SIMULATION");
        
        String obstructionType = ControllerFacade.senseObstruction(Direction.NORTH);
        System.out.println(obstructionType);
        
        obstructionType = ControllerFacade.senseObstruction(Direction.SOUTH);
        System.out.println(obstructionType);
        
        obstructionType = ControllerFacade.senseObstruction(Direction.EAST);
        System.out.println(obstructionType);
        
        obstructionType = ControllerFacade.senseObstruction(Direction.WEST);
        System.out.println(obstructionType);
    }
}
