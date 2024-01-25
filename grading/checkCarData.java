import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class bailey_checkCarData
{
	public static void main(String[] args)
	{
		if( args.length != 6 )
		{
			System.out.println("format testCarData \"input file\" \"check file\" \"min total range\" \"max total range\" \"min remaining range\" \"max remaining range\"");
			System.exit(0);
		}
		
		double[] testResults = new double[11];
		ArrayList<ArrayList<String>> checkLists = new ArrayList<>(); 
		for( int i = 0; i < testResults.length; i++ )
		{
			checkLists.add(new ArrayList<String>());
		}
		
		// get the command line arguments
		String filename = args[0];
		String checkFilename = args[1];
		double minTotalRange = Double.parseDouble(args[2]);
		double maxTotalRange = Double.parseDouble(args[3]);
		double minRemainingRange = Double.parseDouble(args[4]);
		double maxRemainingRange = Double.parseDouble(args[5]);
		
		System.out.println("testing bailey");
		
		try
		{
			System.out.println("reading " + checkFilename);
			String inn;
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(checkFilename)));
			for( int i = 0; i < checkLists.size(); i++ )
			{
				ArrayList<String> currentArrayList = checkLists.get(i);
				input.readLine();
				while( (inn = input.readLine()) != null ) 
				{
					if( inn.length() > 0 )
					{
						currentArrayList.add(inn);
					}
					else
					{
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
				
		// create a ManageCarData object
		ManageCarDataFunctions manageCarData = new bailey_ManageCarData();
		
		// read the car definitions from the input file
		manageCarData.readData(filename);
		
		// get the list of cars that is stored as an arraylist and print it out
		System.out.println("carList");
		ArrayList<CarFunctions> carList = manageCarData.getCarList();
		testResults[0] = compareCarListToStringList(carList, checkLists.get(0));
		
		for( CarFunctions c : carList )
		{
			System.out.println(c);
		}
		System.out.println();

		// get the list of cars stored in the PriorityQueue ordered by total range via an iterator and print it out
		System.out.println("carListByTotalRange iterator");
		ArrayList<CarFunctions> carListByTotalRangeByIterator = manageCarData.getCarListByTotalRangeUsingIterator();
		testResults[1] = compareCarListToStringList(carListByTotalRangeByIterator, checkLists.get(1));
		
		for( CarFunctions c : carListByTotalRangeByIterator )
		{
			System.out.println(c);
		}
		System.out.println();
		
		// get an iterator for the PriorityQueue ordered by total range and print them out
		System.out.println("carListByTotalRange iterator local");
		Iterator<CarFunctions> itByTotalRange = manageCarData.getCarListByTotalRange().iterator();
		ArrayList<String> tempGetCarListByTotalRange = new ArrayList<>();
		while( itByTotalRange.hasNext() )
		{
			tempGetCarListByTotalRange.add(itByTotalRange.next().toString());
		}
		testResults[2] = compare(tempGetCarListByTotalRange, checkLists.get(2));
		
		for( String s : tempGetCarListByTotalRange )
		{
			System.out.println(s);
		}
		System.out.println(); 
		
		// poll out the elements of the PriorityQueue ordered by remaining range 
		System.out.println("carListByRemainingRange poll");
		java.util.PriorityQueue<CarFunctions> carsByRemaingRange = manageCarData.getCarListByRemainingRange();
		ArrayList<String> tempGetCarListByRemainingRangeQueue = new ArrayList<>();
		while( carsByRemaingRange.size() > 0 )
		{
			tempGetCarListByRemainingRangeQueue.add(carsByRemaingRange.poll().toString());
		}
		testResults[3] = compare(tempGetCarListByRemainingRangeQueue, checkLists.get(3));
		
		for( String s : tempGetCarListByRemainingRangeQueue )
		{
			System.out.println(s);
		}
		System.out.println();
		
		// poll out the elements of the PriorityQueue ordered by total range 
		System.out.println("carListByTotalRange poll");
		java.util.PriorityQueue<CarFunctions> carsByTotalRange = manageCarData.getCarListByTotalRange();
		ArrayList<String> tempGetCarListByTotalRangeQueue = new ArrayList<>();
		while( carsByTotalRange.size() > 0 )
		{
			tempGetCarListByTotalRangeQueue.add(carsByTotalRange.poll().toString());
		}
		testResults[4] = compare(tempGetCarListByTotalRangeQueue, checkLists.get(4));
		
		for( String s : tempGetCarListByTotalRangeQueue )
		{
			System.out.println(s);
		}
		System.out.println();
		
		// get the list of cars stored in the PriorityQueue ordered by remaining range via an iterator and print it out
		System.out.println("carListByRemainingRange iterator");
		ArrayList<CarFunctions> carListByRemainingRangeByIterator = manageCarData.getCarListByRemainingRangeUsingIterator();
		testResults[5] = compareCarListToStringList(carListByRemainingRangeByIterator, checkLists.get(5));
		
		for( CarFunctions c : carListByRemainingRangeByIterator )
		{
			System.out.println(c);
		}
		System.out.println();
		
		// get an iterator for the PriorityQueue ordered by remaining range and print them out
		System.out.println("carListByRemainingRange iterator local");
		Iterator<CarFunctions> itByRemaininglRange = manageCarData.getCarListByRemainingRange().iterator();
		ArrayList<String> tempGetCarListByRemainingRange = new ArrayList<>();
		while( itByRemaininglRange.hasNext() )
		{
			tempGetCarListByRemainingRange.add(itByRemaininglRange.next().toString());
		}
		testResults[6] = compare(tempGetCarListByRemainingRange, checkLists.get(6));
		
		for( String s : tempGetCarListByRemainingRange )
		{
			System.out.println(s);
		}
		System.out.println();
		
		// get the list of cars stored in the PriroityQueue ordered by total range having total range [minTotalRange, maxTotalRange]
		System.out.println("carListByTotalRange.poll().getTotalRangeInMiles() in [" + minTotalRange + "," + maxTotalRange + "]");
		ArrayList<String> carListByTotalRangeByPoll = manageCarData.getCarListByTotalRangeViaPoll(minTotalRange, maxTotalRange);
		testResults[7] = compare(carListByTotalRangeByPoll, checkLists.get(7));
		
		for( String s : carListByTotalRangeByPoll )
		{
			System.out.println(s);
		}
		System.out.println();
		
		// get the list of cars stored in the PriroityQueue ordered by remaining range having total range [minRemainingRange, maxRemainingRange]
		System.out.println("carListByRemainingRange.poll().getRemainingRangeInMiles() in [" + minRemainingRange + "," + maxRemainingRange + "]");
		ArrayList<String> carListByRemainingRangeByPoll = manageCarData.getCarListByRemainingRangeViaPoll(minRemainingRange, maxRemainingRange);
		testResults[8] = compare(carListByRemainingRangeByPoll, checkLists.get(8));
		
		for( String s : carListByRemainingRangeByPoll )
		{
			System.out.println(s);
		}
		System.out.println();
		
		// get the list of cars stored in the PriorityQueue ordered by total range via an iterator and print it out
		System.out.println("carListByTotalRange iterator (if empty, you didn't refill carListByTotalRange after polling all of the elements)");
		carListByTotalRangeByIterator = manageCarData.getCarListByTotalRangeUsingIterator();
		testResults[9] = compareCarListToStringList(carListByTotalRangeByIterator, checkLists.get(9));
		
		for( CarFunctions c : carListByTotalRangeByIterator )
		{
			System.out.println(c);
		}
		System.out.println();
		
		// get the list of cars stored in the PriorityQueue ordered by remaining range via an iterator and print it out
		System.out.println("carListByRemainingRange iterator (if empty, you didn't refill carListByRemainingRange after polling all of the elements)");
		carListByRemainingRangeByIterator = manageCarData.getCarListByRemainingRangeUsingIterator();
		testResults[10] = compareCarListToStringList(carListByRemainingRangeByIterator, checkLists.get(10));
		
		for( CarFunctions c : carListByRemainingRangeByIterator )
		{
			System.out.println(c);
		}
		System.out.println();
				
		System.err.print("testResults =");
		for( int i = 0; i < testResults.length; i++ )
		{
			System.err.print("\t"+testResults[i]);
		}
		System.err.println();
	}
	
	private static double compareCarListToStringList(ArrayList<CarFunctions> carList, ArrayList<String> checkList)
	{
		ArrayList<String> list = new ArrayList<>();
		for( CarFunctions c : carList )
		{
			list.add(c.toString());
		}
		
		return compare(list, checkList);
	}
		
	private static double compare(ArrayList<String> carList, ArrayList<String> checkList)
	{
		double result = 0.0;
		double delta = 0.05;
		ArrayList<String> tempCarList = new ArrayList<>();
		ArrayList<String> tempCheckList = new ArrayList<>();
		
		if( carList.size() != checkList.size() )
		{
			result = result + (Math.abs(carList.size()-checkList.size())*delta);
		}
		
		for( String s : carList )
		{
			if( !checkList.contains(s) )
			{
				result = result + delta;
			}
			else
			{
				tempCarList.add(s);
			}
		}
		
		for( String s : checkList )
		{
			if( !carList.contains(s) )
			{
				result = result + delta;
			}
			else
			{
				tempCheckList.add(s);
			}
		}
		
		int minSize = (int) Math.min(tempCarList.size(), tempCheckList.size());
		
		for( int i = 0; i < minSize; i++ )
		{
			if( !tempCarList.get(i).equals(tempCheckList.get(i)) )
			{
				result = result + delta;
			}
		}
		
		return Math.min(1.0, result);
	}
}
