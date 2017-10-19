package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class MODERATE_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	String ModerateRiskOperationId;
	
	public MODERATE_RISK_STATE()
	{
		MyLogger.writeMessage("Moderate Risk State class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		ModerateRiskOperationId = "2 3 5 8 9";
	}
	
	public MODERATE_RISK_STATE(AirportSecurity airportSecurity) 
	{
		this();
		MyLogger.writeMessage("Moderate Risk State class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues();
		String previousState = someState.currentState.toString();
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState(someState);
		MyLogger.writeMessage("State Changed from " + previousState + " to " + someState.currentState.toString(), MyLogger.DebugLevel.STATE_CHANGE);
		AirportSecurityHelper.printToFile();
	}
	
	@Override
	public String toString() 
	{
		return "MODERATE RISK STATE";
	}
}
