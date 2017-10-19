package airportSecurityState.airportStates;

import java.util.Calendar;
import java.util.HashMap;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.TravelerInfo;

public class AirportSecurity implements AirportStateI
{
	/**
	 * Data member that is used for reading from a file
	 */
	private FileProcessor fileProcessor;
	
	
	/**
	 * Data member that holds the path of input file
	 */
	//private String inputFile;

	/**
	 * Data member that holds the path of output file
	 */
	private String outputFile;
	
	AirportStateI HighRiskState, LowRiskState, ModerateRiskState;
	AirportStateI currentState = null;
	
	public enum ProhibitedItems {Gun, NailCutter, Blade, Knife};
	
	public AirportSecurity()
	{	
		HighRiskState = new HIGH_RISK_STATE(this);
		LowRiskState = new LOW_RISK_STATE(this);
		ModerateRiskState = new MODERATE_RISK_STATE(this);
		
		currentState = LowRiskState;
	}
	
	public AirportSecurity(String inputFilePath, String outputFilePath)
	{
		this();
		outputFile = outputFilePath;
		
		fileProcessor = new FileProcessor(inputFilePath);
		
		String line = "";
		//int i = 0;

		while((line = fileProcessor.readLine(inputFilePath)) != null)
		{
			//i++;
			AirportSecurityHelper.processInput(line);
			tightenOrLoosenSecurity();
			//System.out.println(currentState.toString());
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
