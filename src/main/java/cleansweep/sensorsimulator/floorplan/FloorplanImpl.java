package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.FloorType;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;
import cleansweep.sensorsimulator.cell.ChargingBaseCellImpl;
import cleansweep.sensorsimulator.cell.FloorCellImpl;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;
import cleansweep.sensorsimulator.utils.FileManager;

public class FloorplanImpl implements Floorplan {
	private Cell[][] grid;
	private int currentRow;
	private int currentCol;
	
	FloorplanImpl(String fileName) {
		System.out.println(fileName);
		
		String fileContents = FileManager.readFile(fileName);
        
        String[] rows = fileContents.split("\n");
        
        grid = new Cell[rows.length][rows[0].length()];
        
        for (int r=0; r < rows.length; r++) {
        	String row = rows[r];
        	
        	for (int c=0; c < row.length(); c++) {
        		char character = row.charAt(c);
        		
        		if (character == 'C') {
        			currentRow = r;
        			currentCol = c;
        		}
        		
        		Cell cell = CellFactory.createCell(character);
        		
        		grid[r][c] = cell;
        	}
        }
        
    }

	public CoordinatesDTO getCurrentCoordinates() {
		CoordinatesDTO coordinates = new CoordinatesDTO();
		coordinates.row = currentRow;
		coordinates.column = currentCol;
		
		return coordinates;
	}

	@Override
	public boolean senseObstruction(CoordinatesDTO coordinates) {
		Cell cell = grid[coordinates.row][coordinates.column];
		return cell.isObstruction();
	}

	@Override
	public FloorType senseFloorType() {
		Cell cell = grid[currentRow][currentCol];
		
		if (cell.getClass().getSimpleName().equals("FloorCellImpl")) {
			return ((FloorCellImpl)cell).getFloorType();
		}
		else if (cell.getClass().getSimpleName().equals("ChargingBaseCellImpl")) {
			return ((ChargingBaseCellImpl)cell).getFloorType();
		}
		
		return null;
	}
}
