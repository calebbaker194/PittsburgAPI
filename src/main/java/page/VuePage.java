package page;

import java.util.ArrayList;
import java.util.Arrays;

import table.Cell;
import table.Filter;
import table.Row;

public class VuePage {

	private ArrayList<Filter> filters;
	private Row columns;
	private ArrayList<Row> columnData;
	private String nextPage;
	
	public Filter[] getFilters()
	{
		return (Filter[]) filters.toArray();
	}
	public void setFilters(Filter[] filters)
	{
		this.filters = (ArrayList<Filter>) Arrays.asList(filters);
	}
	public Row getColumns()
	{
		return columns;
	}
	public void setColumns(Row columns)
	{
		this.columns = columns;
	}
	public void addColumn(Cell e) {
		columns.addCell(e);
	}
	public Row[] getColumnData()
	{
		return (Row[]) columnData.toArray();
	}
	public void addFilter(Filter f) {
		filters.add(f);
	}
	public void setColumnData(Row[] columnData)
	{
		this.columnData = (ArrayList<Row>) Arrays.asList(columnData);
	}
	public String getNextPage()
	{
		return nextPage;
	}
	public void setNextPage(String nextPage)
	{
		this.nextPage = nextPage;
	}
	
}
