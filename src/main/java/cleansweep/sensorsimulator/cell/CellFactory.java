package cleansweep.sensorsimulator.cell;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;

public class CellFactory {
	public static Cell createCell(char cellType) {
        if (cellType == 'S') {
            return new StairsCellImpl();
        }
        else if (cellType == 'D') {
            return new DoorCellImpl();
        }
        else if (cellType == '-' || cellType == '|' || cellType == '+') {
            return new WallCellImpl();
        }
        else if (cellType == 'C') {
            return new ChargingBaseCellImpl();
        }
        else {
        	FloorType floorType = getFloorType(cellType);
        	return new FloorCellImpl(floorType);
        }
    }
	
	private static FloorType getFloorType(char cellType) {
		if (cellType == 'H') {
			return FloorType.HIGH_PILE_CARPET;
		}
		else if (cellType == 'L') {
			return FloorType.LOW_PILE_CARPET;
		}
		else {
			return FloorType.BARE_FLOOR;
		}

	}
}
