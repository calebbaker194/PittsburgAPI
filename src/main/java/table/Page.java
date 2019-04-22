package table;

public class Page {
	private int start=0;
	private int length=30;

	public Page() {
		
	}

	public Page(int start, int length)
	{
		setStart(start);
		setLength(length);
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}
	
}
