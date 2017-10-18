package airportSecurityState.airportStates;

public class MODERATE_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	
	public MODERATE_RISK_STATE(AirportSecurity airportSecurity) 
	{
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues(someState);
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState();
		System.out.println("Moderate Risk Alert");
	}
}
