package airportSecurityState.airportStates;

public class MODERATE_RISK_STATE implements AirportStateI
{
	public MODERATE_RISK_STATE(AirportSecurity airportSecurity) 
	{
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		System.out.println("Moderate Risk Alert");
	}
}
