package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class HIGH_RISK_STATE implements AirportStateI 
{
	private AirportSecurity someState;
	String HighRiskOperationId;
	
	public HIGH_RISK_STATE()
	{
		MyLogger.writeMessage("High Risk State class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		HighRiskOperationId = "2 4 6 8 10";
	}
	
	public HIGH_RISK_STATE(AirportSecurity airportSecurity) 
	{
		this();
		MyLogger.writeMessage("High Risk State class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		someState = airportSecurity;
	}

	@Override
	public void tightenOrLoosenSecurity(String line)  throws NumberFormatException
	{
		AirportSecurityHelper.processInput(line);
		AirportSecurityHelper.calcValues();
		String previousState = someState.currentState.toString();
		try
		{
			someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState(someState);
			MyLogger.writeMessage("State Changed from " + previousState + " to " + someState.currentState.toString(), MyLogger.DebugLevel.STATE_CHANGE);
		}
		catch(NullPointerException ne)
		{
			System.err.println("Current State Null, something went terribly wrong in code");
			ne.printStackTrace();
			System.exit(1);
		}
		AirportSecurityHelper.printToFile();
	}

	@Override
	public String toString() 
	{
		return "HIGH RISK STATE";
	}
}
