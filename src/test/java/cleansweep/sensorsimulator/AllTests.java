package cleansweep.sensorsimulator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cleansweep.batteryTest.*;
import cleansweep.movementTest.*;
import cleansweep.navigationTest.*;
import cleansweep.processorTest.ProcessInitTest;
import cleansweep.sensorTest.*;
import cleansweep.sensorcontrollerTest.*;
import cleansweep.sensorsimulator.cellTest.*;
import cleansweep.sensorsimulator.floorplanTest.FloorplanFactoryTest;
import cleansweep.sensorsimulator.floorplanTest.FloorplanImplTest;
import cleansweep.sensorsimulator.simulationTest.CoordinatesDTOTest;
import cleansweep.vacuumTest.*;
@RunWith(Suite.class)
@SuiteClasses({ 
        MovementFactoryTest.class, 
        MovementImplTest.class, 
        BatteryTest.class, 
       // NavigationFactoryTest.class,
        NavigationImplTest.class,
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
        SensorFactoryTest.class,
        VacuumSystemFactoryTest.class,
        VacuumSystemImplTest.class,
        FloorplanImplTest.class,
        FloorplanFactoryTest.class,
        CoordinatesDTOTest.class,
        ProcessInitTest.class
        
        })

public class AllTests {

}
