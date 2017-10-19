package airportSecurityState.airportStates;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class AirportSecurity implements AirportStateI
{
	/**
	 * Data member that is used for reading from a file
	 */
	private FileProcessor fileProcessor;

	Results resultObj;
	
	AirportStateI HighRiskState, LowRiskState, ModerateRiskState;
	AirportStateI currentState = null;
	
	public enum ProhibitedItems {Gun, NailCutter, Blade, Knife};
	
	public AirportSecurity()
	{	
		MyLogger.writeMessage("Context class default constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		
		HighRiskState = new HIGH_RISK_STATE(this);
		LowRiskState = new LOW_RISK_STATE(this);
		ModerateRiskState = new MODERATE_RISK_STATE(this);
		
		currentState = LowRiskState;
	}
	
	public AirportSecurity(String inputFilePath, Results result)
	{
		this();
		
		MyLogger.writeMessage("Context class parameterized constructor was called", MyLogger.DebugLevel.CONSTRUCTOR);
		
		resultObj = result;
		fileProcessor = new FileProcessor(inputFilePath);
		
		String line = "";
		while((line = fileProcessor.readLine(inputFilePath)) != null)
		{
			AirportSecurityHelper.processInput(line);
			tightenOrLoosenSecurity();
		}
		
		//close the open file in the end of reading
		fileProcessor.closeFile();
	}
	
	@Override
	public void tightenOrLoosenSecurity() 
	{
		currentState.tightenOrLoosenSecurity();
	}
	
}
