package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LOW_RISK_STATE implements AirportStateI
{
	private AirportSecurity someState;
	String LowRiskOperationId;
	
	public LOW_RISK_STATE()
	{
		MyLogger.writeMessage("Low Risk State class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		LowRiskOperationId = "1 3 5 7 9";
	}
	
	public LOW_RISK_STATE(AirportSecurity airportSecurity) 
	{
		this();
		MyLogger.writeMessage("Low Risk State class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
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
		return "LOW RISK STATE";
	}
}