package cleansweep.sensorsimulator.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	public static String readFile(String fileName) {
		Path path = Paths.get(fileName);

	    try {
	      byte[] fileArray = Files.readAllBytes(path);

	      String fileString = new String(fileArray, "ISO-8859-1");
	      System.out.println(fileString);
	      return fileString;
	    } catch (IOException e) {
	      System.out.println(e.getMessage());
	      return e.getMessage();
	    }
	}
}
