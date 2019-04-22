package helpers;

import java.util.HashMap;
import java.util.List;

public class DataTableRequest {

    private int draw;
    private List<HashMap<String, String>> columns;
    private List<HashMap<String, String>> order;
    private HashMap<String,String> search;
    private int start;
    private int length;

    public int getDraw() {
        return draw;
    }
    public void setDraw(int draw) {
        this.draw = draw;
    }
    public List<HashMap<String, String>> getColumns() {
        return columns;
    }
    public void setColumns(List<HashMap<String, String>> columns) {
        this.columns = columns;
    }
    public List<HashMap<String, String>> getOrder() {
        return order;
    }
    public void setOrder(List<HashMap<String, String>> order) {
        this.order = order;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
	public HashMap<String,String> getSearch()
	{
		return search;
	}
	public void setSearch(HashMap<String,String> search)
	{
		this.search = search;
	}
}