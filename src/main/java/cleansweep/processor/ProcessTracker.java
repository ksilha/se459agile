package cleansweep.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import cleansweep.sensorsimulator.simulation.CoordinatesDTO;

public class ProcessTracker {
	private ArrayList <CoordinatesDTO> path = new ArrayList <CoordinatesDTO>();
	private HashMap <CoordinatesDTO, Integer> visitedCoordinatesMap =  new  HashMap <CoordinatesDTO, Integer>() ;
	private static ProcessTracker processTracker;  
	
	private ProcessTracker(){
		
	}
	
	public static ProcessTracker  getInstance (){
		if (processTracker == null)
			return new ProcessTracker();
		return processTracker; 
	}
	
	public ArrayList<CoordinatesDTO> getPath() {
		return path;
	}

	public HashMap<CoordinatesDTO, Integer> getVisitedCoordinatesMap() {
		return visitedCoordinatesMap;
	}
	
	public void addPath (CoordinatesDTO coordinate){
		if (coordinate == null){
			//throw exception
		}
		path.add(coordinate);
	}
	
	public CoordinatesDTO getCurrentCoordinate(){
		if (path.size()==0)
			return new CoordinatesDTO (0,0);
		return path.get(path.size()-1);
	}
	
	public void addCoordinateToMap (CoordinatesDTO coordinate){
		if (coordinate == null){
			//throw exception
		}
		
		if (visitedCoordinatesMap.containsKey(coordinate)){
			visitedCoordinatesMap.put(coordinate, visitedCoordinatesMap.get(coordinate)+1);
		}else {
			visitedCoordinatesMap.put (coordinate,1);
		}
	}
	
	
	
}
