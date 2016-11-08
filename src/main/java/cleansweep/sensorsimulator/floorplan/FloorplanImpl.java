package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
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
	private int currentColumn;
	
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
        			currentColumn = c;
        		}
        		
        		Cell cell = CellFactory.createCell(character);
        		
        		grid[r][c] = cell;
        	}
        }
        
    }

	public CoordinatesDTO getCurrentCoordinates() {
		CoordinatesDTO coordinates = new CoordinatesDTO();
		coordinates.row = currentRow;
		coordinates.column = currentColumn;
		
		return coordinates;
	}
	
	public void setCurrentCoordinates(CoordinatesDTO coordinates) {
		currentRow = coordinates.row;
		currentColumn = coordinates.column;
	}

	public boolean senseObstruction(CoordinatesDTO coordinates) {
		Cell cell = grid[coordinates.row][coordinates.column];
		return cell.isObstruction();
	}

	public FloorType senseFloorType() {
		Cell cell = grid[currentRow][currentColumn];
		
		return cell.getFloorType();
	}
	
	public CoordinatesDTO calculateMovementCoordinates(Direction direction) {
		CoordinatesDTO coordinates = new CoordinatesDTO();
		
		if (direction == Direction.NORTH) {
			coordinates.row = currentRow - 1;
			coordinates.column = currentColumn;
		}
		else if (direction == Direction.SOUTH) {
			coordinates.row = currentRow + 1;
			coordinates.column = currentColumn;
		}
		else if (direction == Direction.EAST) {
			coordinates.row = currentRow;
			coordinates.column = currentColumn + 1;
		}
		else if (direction == Direction.WEST) {
			coordinates.row = currentRow;
			coordinates.column = currentColumn - 1;
		}
		
		return coordinates;
	}

	public boolean senseDirt() {
		Cell cell = grid[currentRow][currentColumn];
		
		return cell.senseDirt();
	}

	public void clean() {
		Cell cell = grid[currentRow][currentColumn];
		
		cell.clean();
	}
}
