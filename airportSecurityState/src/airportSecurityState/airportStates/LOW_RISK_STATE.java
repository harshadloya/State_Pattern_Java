package airportSecurityState.airportStates;

public class LOW_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	String LowRiskOperationId;
	
	public LOW_RISK_STATE()
	{
		LowRiskOperationId = "1 3 5 7 9";
	}
	
	public LOW_RISK_STATE(AirportSecurity airportSecurity) 
	{
		this();
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues();
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState(someState);
		AirportSecurityHelper.printToFile();
	}
}