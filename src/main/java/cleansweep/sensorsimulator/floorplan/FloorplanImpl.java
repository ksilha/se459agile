package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorcontroller.ControllerFacade.Direction;
import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;
import cleansweep.sensorsimulator.simulation.CoordinatesDTO;
import cleansweep.sensorsimulator.utils.FileManager;

public class FloorplanImpl implements Floorplan {
	private Cell[][] grid;
	private int chargingStationRow;
	private int chargingStationCol;
	
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
        			chargingStationRow = r;
        			chargingStationCol = c;
        		}
        		
        		Cell cell = CellFactory.createCell(character);
        		
        		grid[r][c] = cell;
        	}
        }
        
    }

	public CoordinatesDTO getChargingStationCoordinates() {
		CoordinatesDTO coordinates = new CoordinatesDTO();
		coordinates.row = chargingStationRow;
		coordinates.column = chargingStationCol;
		
		return coordinates;
	}

	@Override
	public String senseObstruction(CoordinatesDTO coordinates) {
		Cell cell = grid[coordinates.row][coordinates.column];
		return cell.getClass().getSimpleName();
	}
}
