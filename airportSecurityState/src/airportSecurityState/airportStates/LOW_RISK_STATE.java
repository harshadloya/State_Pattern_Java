package airportSecurityState.airportStates;

public class LOW_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	
	public LOW_RISK_STATE(AirportSecurity airportSecurity) 
	{
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues(someState);
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState();
		System.out.println("Low Risk Alert");
	}
}