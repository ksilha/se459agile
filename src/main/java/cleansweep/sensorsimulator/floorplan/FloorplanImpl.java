package cleansweep.sensorsimulator.floorplan;

import cleansweep.sensorsimulator.cell.Cell;
import cleansweep.sensorsimulator.cell.CellFactory;
import cleansweep.sensorsimulator.utils.FileManager;

public class FloorplanImpl implements Floorplan {
	FloorplanImpl(String fileName) {
		System.out.println(fileName);
		
		String fileContents = FileManager.readFile(fileName);
        
        String[] rows = fileContents.split("\n");
        
        Cell[][] grid = new Cell[rows.length][rows[0].length()];
        
        for (int r=0; r < rows.length; r++) {
        	String row = rows[r];
        	
        	for (int c=0; c < row.length(); c++) {
        		char character = row.charAt(c);
        		
        		Cell cell = CellFactory.createCell(character);
        		
        		grid[r][c] = cell;
        	}
        }
        
        System.out.println(grid[0][0].getClass());
        System.out.println(grid[1][1].getClass());
        System.out.println(grid[5][1].getClass());
        
    }
}
