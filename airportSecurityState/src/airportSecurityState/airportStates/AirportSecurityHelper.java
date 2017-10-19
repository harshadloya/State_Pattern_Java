package airportSecurityState.airportStates;

import java.util.Calendar;

import airportSecurityState.airportStates.AirportSecurity.ProhibitedItems;

public class AirportSecurityHelper 
{
	private static AirportSecurity someState;

	private static int totalNumberOfTravellers;
	private static int totalNumberOfDays;
	private static int totalProhibitedItemsCount;
	private static int avgTrafficPerDay;
	private static int avgProhibitedItemCountPerDay;
	private static int prevDay = -1;

	//Extension
	//private HashMap<Integer, TravelerInfo> travellerData = new HashMap<Integer, TravelerInfo>();

	public static void processInput(String inputLine)
	{
		int day = 0;
		String item = "";
		String temp[];

		boolean dayCheck = false;
		boolean itemCheck = false;

		//remove leading or trailing whitespaces if any
		inputLine = inputLine.trim();
		temp = inputLine.split(":|;");
		day = Integer.parseInt(temp[1].trim());

		item = temp[8].trim();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[3].trim()));
		cal.set(Calendar.MINUTE, Integer.parseInt(temp[4].trim()));

		/* Extension Code
		 * TravelerInfo traveller = new TravelerInfo(day, cal.getTime(), temp[6].trim(), item);
		 * travellerData.put(i, traveller);
		 */

		totalNumberOfTravellers += 1;

		dayCheck = checkDayNo(day);
		if(dayCheck)
			totalNumberOfDays += 1;

		itemCheck = checkItem(item);
		if(itemCheck)
			totalProhibitedItemsCount += 1;
	}

	private static boolean checkItem(String item) 
	{
		for(ProhibitedItems pItem : ProhibitedItems.values())
			if(item.compareTo(pItem.name()) == 0)
			{
				return true;
			}
		return false;
	}

	private static boolean checkDayNo(int day) 
	{
		if(prevDay != day)
		{
			prevDay = day;
			return true;
		}
		return false;
	}

	public static void calcValues()
	{
		avgTrafficPerDay = totalNumberOfTravellers / totalNumberOfDays;

		avgProhibitedItemCountPerDay = totalProhibitedItemsCount / totalNumberOfDays;
	}

	public static AirportStateI checkAndUpdateAirportState(AirportSecurity as)
	{
		someState = as;

		if(8 <= avgTrafficPerDay || 2 <= avgProhibitedItemCountPerDay)
		{
			return someState.HighRiskState;
		}

		else if((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (1 <= avgProhibitedItemCountPerDay && 2 > avgProhibitedItemCountPerDay))
		{
			return someState.ModerateRiskState;
		}

		else if((0 <= avgTrafficPerDay && 4 > avgTrafficPerDay) || (0 <= avgProhibitedItemCountPerDay && 1 > avgProhibitedItemCountPerDay))
		{
			return someState.LowRiskState;
		}
		
		//Code should never reach this point
		return null;
	}

	public static void printToFile()
	{
		if(someState.currentState == someState.LowRiskState)
		{
			someState.resultObj.storeNewResult(((LOW_RISK_STATE)someState.LowRiskState).LowRiskOperationId);
		}
		else if(someState.currentState == someState.ModerateRiskState)
		{
			someState.resultObj.storeNewResult(((MODERATE_RISK_STATE)someState.ModerateRiskState).ModerateRiskOperationId);
		}
		else if(someState.currentState == someState.HighRiskState)
		{
			someState.resultObj.storeNewResult(((HIGH_RISK_STATE)someState.HighRiskState).HighRiskOperationId);
		}
	}
}
