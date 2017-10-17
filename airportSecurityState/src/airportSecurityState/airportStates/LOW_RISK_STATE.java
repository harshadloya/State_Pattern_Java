package airportSecurityState.airportStates;

public class LOW_RISK_STATE implements AirportStateI
{
	public LOW_RISK_STATE(AirportSecurity airportSecurity) 
	{
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		System.out.println("Low Risk Alert");
	}
}