package objects;

public class PhoneNumber {
	private String phoneNumber;
	public static boolean PrettyPrint = true;
	public static final String pattern = "^(\\+?\\d\\d?[\\s-\\._]?)?\\(?\\d{3}\\)?[\\s-\\._]?\\d{3}[\\s-\\._]?\\d{4}$";
	
	public PhoneNumber(String number) {
		if(number.matches(PhoneNumber.pattern))
			phoneNumber = PhoneNumber.normailze(number);
		else
			System.err.println("\nIncorrect Phone Number Input");	
	}

	/**
	 * This static function allows you to send a string that represents a phone number and change it to a string that is suitable to create a new phone number object out of or store in a database.
	 * @param number - A String representing the phone number.
	 * @return A normalized String that represents a phone number.s
	 */
	private static String normailze(String number)
	{
		number.replaceAll("[^0-9]*", "");
		
		return (number.length() > 10 ? number.substring(0,number.length()-10): "") + number.substring(number.length()-10, number.length()-7) + number.substring(number.length()-7, number.length()-4)+number.substring(number.length()-4);
	}
	
	public String toString()
	{
		if(PhoneNumber.PrettyPrint)
		{
			return  (phoneNumber.length() > 10 ? "+" + phoneNumber.substring(0,phoneNumber.length()-10) +"(": "+1(") + 
					phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length()-7) + ") " + 
					phoneNumber.substring(phoneNumber.length()-7, phoneNumber.length()-4)+ "-" +
					phoneNumber.substring(phoneNumber.length()-4); 
		}
		else
		{
			return (phoneNumber.length() > 10 ? phoneNumber : "1"+phoneNumber);
		}
	}
	
	/**
	 * Gets the country code of a phone number which is the first 1 or 2 digits following the '+' Sign at the beginning of some phone numbers.
	 * @return A String representing the first 1 or 2 digits of a phone number following a + sign. not including the +
	 */
	public String getCountryCode()
	{
		return (phoneNumber.length() > 10 ?  phoneNumber.substring(0,phoneNumber.length()-10) : "1");
	}
	
	/**
	 * Gets the area code of a phone number which is the first 3 digits following the country code
	 * @return A String representing the first 3 digits of a phone number.
	 */
	public String getAreaCode()
	{
		return phoneNumber.substring(phoneNumber.length()-10, phoneNumber.length()-7);
	}
	
	/**
	 * Gets the prefix of a phone number, which is the 3 digits following the area code.
	 * @return A String representing the middle 3 digits of a phone number 
	 */
	public String getPrefix()
	{
		return phoneNumber.substring(phoneNumber.length()-7, phoneNumber.length()-4);
	}
	
	/**
	 * Gets the last 4 digits of a phone number.
	 * @return A String representing the last 4 digits of a phone number
	 */
	public String getLineNumber()
	{
		return phoneNumber.substring(phoneNumber.length()-4);
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
