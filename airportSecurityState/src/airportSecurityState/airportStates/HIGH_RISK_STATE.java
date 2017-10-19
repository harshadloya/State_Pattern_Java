package airportSecurityState.airportStates;

public class HIGH_RISK_STATE implements AirportStateI 
{
	private AirportSecurity someState;
	
	public HIGH_RISK_STATE(AirportSecurity airportSecurity) 
	{
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues();
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState(someState);
		System.out.println("High Risk Alert");
	}
}
