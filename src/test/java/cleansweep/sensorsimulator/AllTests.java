package cleansweep.sensorsimulator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import cleensweep.movementTest.*;
import cleensweep.navigationTest.NavigationFactoryTest;
import cleensweep.navigationTest.NavigationImplTest;
import cleensweep.sensorsimulator.cellTest.ChargingBaseCellImplTest;
import cleensweep.sensorsimulator.cellTest.DoorCellImplTest;
import cleensweep.sensorsimulator.cellTest.FloorCellImplTest;
import cleensweep.sensorsimulator.cellTest.StairsCellImplTest;
import cleensweep.sensorsimulator.cellTest.WallCellImplTest;
import batteryTest.*;

@RunWith(Suite.class)
@SuiteClasses({ 
        MovementFactoryTest.class, 
        MovementImplTest.class, 
        BatteryTest.class, 
       // NavigationFactoryTest.class,
       // NavigationImplTest.class,
        ChargingBaseCellImplTest.class,
        DoorCellImplTest.class,
        FloorCellImplTest.class,
        StairsCellImplTest.class,
        WallCellImplTest.class})

public class AllTests {

}
