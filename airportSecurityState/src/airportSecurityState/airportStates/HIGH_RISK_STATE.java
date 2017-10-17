package airportSecurityState.airportStates;

public class HIGH_RISK_STATE implements AirportStateI 
{
	public HIGH_RISK_STATE(AirportSecurity airportSecurity) 
	{
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		System.out.println("High Risk Alert");
	}
}
