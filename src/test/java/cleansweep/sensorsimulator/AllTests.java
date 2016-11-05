package cleansweep.sensorsimulator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import cleensweep.movementTest.*;
import batteryTest.*;

@RunWith(Suite.class)
@SuiteClasses({ 
        MovementFactoryTest.class, 
        MovementImplTest.class, 
        BatteryTest.class })

public class AllTests {

}
