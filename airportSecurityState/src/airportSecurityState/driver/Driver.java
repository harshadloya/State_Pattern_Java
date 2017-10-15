package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportSecurity;

/**
 * Class containing the main method which is the starting point of code execution
 * @author hloya
 *
 */
public class Driver 
{
	/**
	 * Main method responsible for creating the tree and then calling the delete function
	 * @param args - Input given from command line which contains location of Input file, the Output File for the 
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
				debugLvl = Integer.parseInt(args[2]);
			else
			{
				System.err.println("The third parameter should be a digit in range of 0-4 specifying debug level desired");
				System.exit(1);
			}
			
			AirportSecurity as = new AirportSecurity(inputFilePath, outputFilePath, debugLvl);	
		}
		else
		{
			System.err.println("Invalid number of arguments, please recheck");
			System.exit(1);
		}
		
	}
}