package airportSecurityState.util;

import java.util.Date;

public class TravellerInfo 
{
	private int Day;
	private Date TOD;
	private String Airline;
	private String Item;

	public TravellerInfo() {}

	public TravellerInfo(int dayLn, Date todLn, String airlineLn, String itemLn) 
	{
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
