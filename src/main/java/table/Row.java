package table;

import java.util.ArrayList;
import java.util.Arrays;

public class Row {
	private ArrayList<Cell> cells;
	
	public Row() {
		
	}
	
	public void addCell(Cell c)
	{
		cells.add(c);
	}
	
	public Cell[] getCells()
	{
		return (Cell[])cells.toArray();
	}
	
	public void setCells(Cell[] tmpCells)
	{
		cells = (ArrayList<Cell>) Arrays.asList(tmpCells);
	}
	
	
	
}
