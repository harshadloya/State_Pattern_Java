package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportSecurity;
import airportSecurityState.util.MyLogger;

/**
 * Class containing the main method which is the starting point of code execution
 * @author hloya
 *
 */
public class Driver 
{
	/**
	 * Main method responsible for initializing the airportState and updating it based on the travelers it receives
	 * @param args - Input given from command line which contains location of Input file containing details of travelers, the Output File for the state of airport and debug value
	 */
	public static void main(String[] args) 
	{
		String inputFilePath = "";
		String outputFilePath = "";
		int debugLvl = -1;

		if (args.length == 3)
		{
			inputFilePath = args[0];
			outputFilePath	= args[1];
			if(args[2].matches("[0-4]"))
			{
				debugLvl = Integer.parseInt(args[2]);
				MyLogger.setDebugValue(debugLvl);
			}
			else
			{
				System.err.println("The third parameter should be a digit in range of 0-4 specifying debug level desired");
				System.exit(1);
			}
			
			AirportSecurity as = new AirportSecurity(inputFilePath, outputFilePath);	
		}
		else
		{
			System.err.println("Invalid number of arguments, please recheck");
			System.exit(1);
		}
		
	}
}