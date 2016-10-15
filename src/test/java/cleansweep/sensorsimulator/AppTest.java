package cleansweep.sensorsimulator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    /*
     * Test obstacles
     */
    
    //Test wall
    WallCellImpl wall = new WallCellImpl();
    
    //@test
    public void testWallObst()
    {
    	assertTrue(true == wall.isObstruction());
    }
    
    //test stairs
    StairsCellImpl stair = new StairsCellImpl();
    
    //@test
    public void testStairObst()
    {
    	assertTrue(true == stair.isObstruction());
    }
    
    //test closed door
    DoorCellImpl closedDoor = new DoorCellImpl(true);
    
    //@test
    public void testCloseDoorObst()
    {
    	assertTrue(true == closedDoor.isObstruction());
    }
    
    /*
     * Test unobstructed
     */
    
    //test floor
    FloorCellImpl floor = new FloorCellImpl(FloorType.BARE_FLOOR);
    
    //@test
    public void testFloorNonObst()
    {
    	assertTrue(false == floor.isObstruction());
    }
    
    //test open door
    DoorCellImpl openDoor = new DoorCellImpl(false);
    
    //@test
    public void testOpenDoorNonObst()
    {
    	assertTrue(false == openDoor.isObstruction());
    }
}
