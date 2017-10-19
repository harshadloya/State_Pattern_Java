package airportSecurityState.util;

import java.util.Date;

/**
 * Not using currently
 * @author hloya
 *
 */
public class TravelerInfo 
{
	private int Day;
	private Date TOD;
	private String Airline;
	private String Item;

	public TravelerInfo() 
	{
		MyLogger.writeMessage("TravelerInfo class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public TravelerInfo(int dayLn, Date todLn, String airlineLn, String itemLn) 
	{
		MyLogger.writeMessage("TravelerInfo class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		
		Day = dayLn;
		TOD = todLn;
		Airline = airlineLn;
		Item = itemLn;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public Date getTOD() {
		return TOD;
	}

	public void setTOD(Date tOD) {
		TOD = tOD;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}
}
