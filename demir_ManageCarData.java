import java.util.*;
import java.io.*;

class demir_ManageCarData implements ManageCarDataFunctions
{
	private final ArrayList<CarFunctions> carList;
	private final PriorityQueue<CarFunctions> carListByTotalRange;		
	private final PriorityQueue<CarFunctions> carListByRemainingRange;	
	
	
	
	public demir_ManageCarData()
	{
		carList = new ArrayList<>();
		carListByTotalRange = new PriorityQueue<CarFunctions>(new TotalRangeComparator());
		carListByRemainingRange = new PriorityQueue<CarFunctions>(new RemainingRangeComparator());
	}
	
	public void readData(String filename)
	{
		try
		{
		BufferedReader input =
				new BufferedReader(
						new InputStreamReader(
								new FileInputStream(filename)));
		
		
		String line = input.readLine();
        ArrayList<String> inputLines = new ArrayList<>(0);

		
		while(line != null)
		{
			inputLines.add(line);
            line=input.readLine();
		}
		
		
		
		for( int i = 0; i < inputLines.size(); i++)
		{
			
		line = inputLines.get(i);
		
		//StringTokenizer st = new StringTokenizer(line, " ");
		
		String[] parsed = line.split("	");
	
			
				CarFunctions MyCar = new demir_Car(parsed[0], Integer.parseInt(parsed[1]), Integer.parseInt(parsed[2]), Double.parseDouble(parsed[3]));
				
				carList.add(MyCar);
				carListByTotalRange.add(MyCar);
				carListByRemainingRange.add(MyCar);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println(e.toString());
			System.exit(0);
		}
		
	}
	public ArrayList<CarFunctions> getCarList() //correct
	{
		ArrayList<CarFunctions>tempCarList = new ArrayList<>();
		for(int i=0; i<carList.size(); i++)
		{
			tempCarList.add(carList.get(i));
		}
		return tempCarList;
	}
	
	public PriorityQueue<CarFunctions> getCarListByTotalRange()
	{
		PriorityQueue<CarFunctions>tempCarList1 = new PriorityQueue<>(new TotalRangeComparator());
		for(int i=0; i<carList.size(); i++)
		{
			tempCarList1.add(carList.get(i));
		}
		return tempCarList1;
	}
	
	public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator()
	{
		ArrayList<CarFunctions>newList = new ArrayList<>();
		Iterator<CarFunctions> it = carListByTotalRange.iterator();
		while(it.hasNext())
		{
			newList.add(it.next());
		}
		return newList;
	}
	
	public PriorityQueue<CarFunctions> getCarListByRemainingRange()
	{
		PriorityQueue<CarFunctions>tempCarList2 = new PriorityQueue<>(new RemainingRangeComparator());
		for(int i=0; i<carList.size(); i++)
		{
			tempCarList2.add(carList.get(i));
		}
		return tempCarList2;
	}
	
	public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator()
	{
		ArrayList<CarFunctions>newList1 = new ArrayList<>();
		Iterator<CarFunctions> it = carListByRemainingRange.iterator();
		while(it.hasNext())
		{
			newList1.add(it.next());
		}
		return newList1;
	}
	
	public ArrayList<String> getCarListByTotalRangeViaPoll(
							 double minTotalRange, double maxTotalRange)
	{
		ArrayList<String>StringCarList = new ArrayList<>();
		 
		 while(carListByTotalRange.size()!=0) 
		 {
			 
			CarFunctions a = carListByTotalRange.poll();
			 
			 if(Double.compare(minTotalRange, a.getTotalRangeInMiles())<0 
				&& 
				Double.compare(maxTotalRange, a.getTotalRangeInMiles())>0)
				 
			 {
				 CarFunctions currentCar = a;
				 String currentCarString = currentCar.toString();
				 for(int i = 0; i < carList.size(); i++)
				 {
					 if(carList.get(i).equals(currentCar))
					 {
						 currentCarString = currentCarString + "	" + i;
						 
					 }
 
				 }
				
				 for(int i = 0; i < carList.size(); i++)
				 {
					 if(carList.get(i).getFuelEconomyInMilesPerGallon()==currentCar.getFuelEconomyInMilesPerGallon())
					 {
						 currentCarString = currentCarString + "	" + i;
						
					 }
				 }
				 StringCarList.add(currentCarString);
			 }
		 }
		 for(int j = 0; j < carList.size(); j++)
		 {
			 carListByTotalRange.add(carList.get(j));
		 }
		 return StringCarList;
	}
	
	public ArrayList<String> getCarListByRemainingRangeViaPoll(
							 double minRemainingRange, double maxRemainingRange)
	{
		ArrayList<String>StringCarList = new ArrayList<>();
		 
		 while(carListByRemainingRange.size()!=0) 
		 {
			 CarFunctions a = carListByRemainingRange.poll();
			 
			
			 if(Double.compare(minRemainingRange, a.getRemainingRangeInMiles())<0 
				&& 
				Double.compare(maxRemainingRange, a.getRemainingRangeInMiles())>0)
				 
			 {
				 CarFunctions currentCar = a;
				 
				 
				 String currentCarString = currentCar.toString();
				 for(int i = 0; i < carList.size(); i++)
				 {
					 if(carList.get(i).equals(currentCar))
					 {
						 currentCarString = currentCarString + "	" + i;
						  
					 }
					 
				 }
				 for(int i = 0; i < carList.size(); i++)
				 {
					 if(carList.get(i).getFuelEconomyInMilesPerGallon() ==
								currentCar.getFuelEconomyInMilesPerGallon())
					 {
						currentCarString = currentCarString + "	" + i;
							 
					 }
				 }
				 
				 StringCarList.add(currentCarString);
			 }
		 }
		 for(int j = 0; j < carList.size(); j++)
		 {
			 carListByRemainingRange.add(carList.get(j));
		 }
		 return StringCarList;
	}
	
	
}
