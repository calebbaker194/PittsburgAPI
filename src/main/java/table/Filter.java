package table;

public class Filter {
	private String label;
	private boolean isSelection;
	private String[] options;
	
	public Filter() {
		
	}

	public Filter(String label) {
		setSelection(false);
		setLabel(label);
		options = new String [0];
	}
	
	public String[] getOptions()
	{
		return options;
	}

	public void setOptions(String[] options)
	{
		this.options = options;
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public boolean isSelection()
	{
		return isSelection;
	}

	public void setSelection(boolean isSelection)
	{
		this.isSelection = isSelection;
	}
}
