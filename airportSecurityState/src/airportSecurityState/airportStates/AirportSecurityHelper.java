package airportSecurityState.airportStates;

public class AirportSecurityHelper 
{
	private static AirportStateI someState;
	private static int avgTrafficPerDay;
	private static int avgProhibitedItemCountPerDay;
	
	public static void calcValues(AirportStateI as)
	{
		someState = as;
		avgTrafficPerDay = ((AirportSecurity) as).getTotalNumberOfTravellers() / ((AirportSecurity) as).getTotalNumberOfDays();
		
		avgProhibitedItemCountPerDay = ((AirportSecurity) as).getTotalProhibitedItemsCount() / ((AirportSecurity) as).getTotalNumberOfDays();
		
		//checkAndUpdateAirportState();
	}

	public static AirportStateI checkAndUpdateAirportState()
	{
		if(8 <= avgTrafficPerDay || 2 <= avgProhibitedItemCountPerDay)
		{
			//currentState = HighRiskState;
			return ((AirportSecurity) someState).HighRiskState;
		}
		
		else if((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (1 <= avgProhibitedItemCountPerDay && 2 > avgProhibitedItemCountPerDay))
		{
			return ((AirportSecurity) someState).ModerateRiskState;
		}
		
		else if((0 <= avgTrafficPerDay && 4 > avgTrafficPerDay) || (0 <= avgProhibitedItemCountPerDay && 1 > avgProhibitedItemCountPerDay))
		{
			return ((AirportSecurity) someState).LowRiskState;
		}
		
		return null;
	}
}
