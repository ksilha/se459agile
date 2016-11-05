package cleansweep.sensorsimulator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cleansweep.batteryTest.*;
import cleansweep.movementTest.*;
import cleansweep.navigationTest.*;
import cleansweep.sensorTest.*;
import cleansweep.sensorcontrollerTest.*;
import cleansweep.sensorsimulator.cellTest.*;
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
        WallCellImplTest.class,
        ControllerFacadeTest.class,
        ControllerFactoryTest.class,
        BareFloorSensorTest.class,
        ChargingStationSensorTest.class,
        DirtSensorTest.class,
        NorthSensorTest.class,
        SouthSensorTest.class,
        EastSensorTest.class,
        WestSensorTest.class,
        HighCarpetSensorTest.class,
        LowCarpetSensorTest.class,
        })

public class AllTests {

}
