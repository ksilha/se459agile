package cleansweep.sensorsimulator.cell;

public class CellFactory {
	public static Cell createCell(char cellType) {
        if (cellType == ' ') {
            return new FloorCellImpl();
        }
        else if (cellType == 'S') {
            return new StairsCellImpl();
        }
        else if (cellType == 'D') {
            return new DoorCellImpl();
        }
        else if (cellType == '-' || cellType == '|' || cellType == '+') {
            return new WallCellImpl();
        }
        else if (cellType == 'C') {
            return new WallCellImpl();
        }
        else {
            return null;
        }
    }
}
