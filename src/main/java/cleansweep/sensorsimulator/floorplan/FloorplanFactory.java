package cleansweep.sensorsimulator.floorplan;

public class FloorplanFactory {
	public static Floorplan createFloorplan(String fileName) {
        return new FloorplanImpl(fileName);
    }
}
