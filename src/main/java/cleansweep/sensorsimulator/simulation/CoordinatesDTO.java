package cleansweep.sensorsimulator.simulation;

public class CoordinatesDTO {
	public int row;
	public int column;
	
	public CoordinatesDTO (){
		
	}
	
	public CoordinatesDTO (int rowInput, int columnInput){
		row = rowInput;
		column = columnInput;
	}
	
	public String toString(){
		return "("+row+","+column+")";
	}
	
	@Override
	public boolean equals (Object o){
		if (o==this) return true;
		if (!(o instanceof CoordinatesDTO)){
			return false;
		}
		
		CoordinatesDTO coor = (CoordinatesDTO) o;
		
		return coor.row==row && coor.column==column;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result = 31*result+row;
		result = 31*result+column;
		return result;
	}
	
	
	
}
