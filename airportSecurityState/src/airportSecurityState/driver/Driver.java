package airportSecurityState.driver;

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

		if (args.length == 3)
		{
			inputFilePath = args[0];
			outputFilePath	= args[1];
			
		}
		else
		{
			System.out.println("Invalid number of arguments, please recheck");
		}
		
	}
}