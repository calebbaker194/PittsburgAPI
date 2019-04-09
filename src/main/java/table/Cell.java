package table;

public class Cell {
	public static final String RIGHT_ALIGN="c-rightalign";
	public static final String LEFT_ALIGN="c-leftalign";
	public static final String CENTER_ALIGN="c-centeralign";
	private String className;
	private String data;
	
	public Cell() {
		
	}
	
	public Cell(String className, String data) {
		setClassName(className);
		setData(data);
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}
}
