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
	public void tightenOrLoosenSecurity() 
	{
		AirportSecurityHelper.calcValues();
		someState.currentState = AirportSecurityHelper.checkAndUpdateAirportState(someState);
		AirportSecurityHelper.printToFile();
	}
}
