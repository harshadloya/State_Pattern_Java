package airportSecurityState.airportStates;

public class HIGH_RISK_STATE implements AirportStateI 
{
	private AirportSecurity someState;
	String HighRiskOperationId;
	
	public HIGH_RISK_STATE()
	{
		HighRiskOperationId = "2 4 6 8 10";
	}
	
	public HIGH_RISK_STATE(AirportSecurity airportSecurity) 
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
