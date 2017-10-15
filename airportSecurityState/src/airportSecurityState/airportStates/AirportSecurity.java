package airportSecurityState.airportStates;

import java.util.Date;
import java.util.HashMap;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.TravellerInfo;

public class AirportSecurity 
{
	private int debugLvl;
	//private int totalNumberOfTravellers;
	private int totalNumberOfDays;
	private int totalProhibitedItemsCount;
	private int avgPassengerCountPerDay;
	private int avgProhibitedItemCountPerDay;
	
	private HashMap<Integer, TravellerInfo> travellerData;
	
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
	
	
	public AirportSecurity()
	{
		travellerData = new HashMap<Integer, TravellerInfo>();
	}
	
	public AirportSecurity(String inputFilePath, String outputFilePath, int dLvl)
	{
		this();
		debugLvl = dLvl;
		outputFile = outputFilePath;
		
		fileProcessor = new FileProcessor(inputFilePath);
		
		String line = "";
		String temp[];
		int day = 0;
		int i = 0;


		while((line = fileProcessor.readLine(inputFilePath)) != null)
		{
			boolean dayCheck = false;
			boolean TODCheck = false;
			boolean airlineCheck = false;
			boolean itemCheck = false;

			//remove leading or trailing whitespaces if any
			line = line.trim();
			temp = line.split(":|;");
			day = Integer.parseInt(temp[1]);
			
			TravellerInfo traveller = new TravellerInfo(day, new Date(), temp[5], temp[7]);
			travellerData.put(i,traveller);
			i++;
		}

		//uncomment after other variables have been populated
		//calcValues();
		
		//close the open file in the end of reading
		fileProcessor.closeFile();
	}
	
	private void calcValues()
	{
		avgPassengerCountPerDay = travellerData.size() / totalNumberOfDays;
		
		avgProhibitedItemCountPerDay = totalProhibitedItemsCount / totalNumberOfDays;
	}
}
