package airportSecurityState.airportStates;

public class MODERATE_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	String ModerateRiskOperationId;
	
	public MODERATE_RISK_STATE()
	{
		ModerateRiskOperationId = "2 3 5 8 9";
	}
	
	public MODERATE_RISK_STATE(AirportSecurity airportSecurity) 
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
