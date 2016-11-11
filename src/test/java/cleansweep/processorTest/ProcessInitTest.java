package cleansweep.processorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import cleansweep.processor.ProcessInit;
import cleansweep.processor.Processor;

public class ProcessInitTest {
	
	@Test
	public void getProcessorTest() {
		ProcessInit pi = new ProcessInit();
		Processor p = pi.getProcessor();
		assertNotNull(p);
	}
}
