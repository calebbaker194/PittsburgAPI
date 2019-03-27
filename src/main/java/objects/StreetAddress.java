package objects;

public class StreetAddress {
	private String countryCode = "US";
	private String street = "NA";
	private String state = "NA";
	private String zip = "NA";
	private String unit = "NA";
	
	public StreetAddress()
	{
		
	}
	
	public String toString()
	{
		return street + "\n" + state + " " + zip + "\n" + unit;
	}

	public String getCountryCode()
	{
		return countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}
}
