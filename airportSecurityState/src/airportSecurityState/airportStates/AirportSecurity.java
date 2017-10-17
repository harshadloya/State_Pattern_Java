package airportSecurityState.airportStates;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.TravelerInfo;

public class AirportSecurity implements AirportStateI
{
	private int totalNumberOfTravellers;
	private int totalNumberOfDays;
	private int totalProhibitedItemsCount;
	private int avgTrafficPerDay;
	private int avgProhibitedItemCountPerDay;
	
	private HashMap<Integer, TravelerInfo> travellerData;
	
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
	
	int prevDay = -1;
	
	private AirportStateI HighRiskState, LowRiskState, ModerateRiskState;
	private AirportStateI currentState = null;
	
	public enum ProhibitedItems {Gun, NailCutter, Blade, Knife};
	
	public AirportSecurity()
	{	
		travellerData = new HashMap<Integer, TravelerInfo>();
		
		HighRiskState = new HIGH_RISK_STATE(this);
		LowRiskState = new LOW_RISK_STATE(this);
		ModerateRiskState = new MODERATE_RISK_STATE(this);
		
		totalNumberOfDays = 0;
		totalNumberOfTravellers = 0;
		totalProhibitedItemsCount = 0;
		avgTrafficPerDay = 0;
		avgProhibitedItemCountPerDay = 0;
	}
	
	public AirportSecurity(String inputFilePath, String outputFilePath)
	{
		this();
		outputFile = outputFilePath;
		
		fileProcessor = new FileProcessor(inputFilePath);
		
		String line = "";
		int i = 0;

		while((line = fileProcessor.readLine(inputFilePath)) != null)
		{
			int day = 0;
			String item = "";
			String temp[];
			
			boolean dayCheck = false;
			boolean itemCheck = false;

			//remove leading or trailing whitespaces if any
			line = line.trim();
			temp = line.split(":|;");
			day = Integer.parseInt(temp[1].trim());
			
			item = temp[8].trim();
					
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(temp[3].trim()));
			cal.set(Calendar.MINUTE, Integer.parseInt(temp[4].trim()));
			
			TravelerInfo traveller = new TravelerInfo(day, cal.getTime(), temp[6].trim(), item);
			travellerData.put(i, traveller);
			i++;
			
			totalNumberOfTravellers = i;
			dayCheck = checkDayNo(day);
			
			if(dayCheck)
				totalNumberOfDays += 1;
			
			itemCheck = checkItem(item);
			if(itemCheck)
				totalProhibitedItemsCount += 1;
			
			calcValues();
			tightenOrLoosenSecurity();
		}
		
		//close the open file in the end of reading
		fileProcessor.closeFile();
	}
	
	private boolean checkItem(String item) 
	{
		for(ProhibitedItems pItem : ProhibitedItems.values())
			if(item.compareTo(pItem.name()) == 0)
			{
				return true;
			}
		return false;
	}

	private boolean checkDayNo(int day) 
	{
		if(prevDay != day)
		{
			prevDay = day;
			return true;
		}
			
		return false;
	}

	private void calcValues()
	{
		avgTrafficPerDay = totalNumberOfTravellers / totalNumberOfDays;
		
		avgProhibitedItemCountPerDay = totalProhibitedItemsCount / totalNumberOfDays;
		
		checkAndUpdateAirportState();
	}

	private void checkAndUpdateAirportState() 
	{
		if(8 <= avgTrafficPerDay || 2 <= avgProhibitedItemCountPerDay)
		{
			currentState = HighRiskState;
		}
		
		else if((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (1 <= avgProhibitedItemCountPerDay && 2 > avgProhibitedItemCountPerDay))
		{
			currentState = ModerateRiskState;
		}
		
		else if((0 <= avgTrafficPerDay && 4 > avgTrafficPerDay) || (0 <= avgProhibitedItemCountPerDay && 1 > avgProhibitedItemCountPerDay))
		{
			currentState = LowRiskState;
		}
	}

	@Override
	public void tightenOrLoosenSecurity() 
	{
		currentState.tightenOrLoosenSecurity();
	}
}
