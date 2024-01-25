import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class demir_Car implements CarFunctions
{
	
	private final String Id;
	private final int FuelEconomyInMilesPerGallon;
	private final int FuelCapacityInGallons;
	private double CurrentFuelInGallons;
	
	
	public demir_Car(String id, int eco, int cap, double fuel)
	{
		this.Id = String.valueOf(id);
		this.FuelEconomyInMilesPerGallon = Integer.valueOf(eco);
		this.FuelCapacityInGallons = Integer.valueOf(cap);
		this.CurrentFuelInGallons = Double.valueOf(fuel);
	}
	
	public String getId()
	{
		return this.Id;
	}
	
	public int getFuelEconomyInMilesPerGallon()
	{
		return this.FuelEconomyInMilesPerGallon;
	}
	
	public int getFuelCapacityInGallons()
	{
		return this.FuelCapacityInGallons;
	}
	
	public double getCurrentFuelInGallons()
	{
		return this.CurrentFuelInGallons;
	}
	
	public void setCurrentFuelInGallons(double v)
	{
		this.CurrentFuelInGallons = v;
	}
	
	// get the total range of the car in miles 
	public double getTotalRangeInMiles()
	{
		return getFuelCapacityInGallons()*getFuelEconomyInMilesPerGallon();
	}
	
	// get the remaining range of the car in miles
	public double getRemainingRangeInMiles()
	{
		return getCurrentFuelInGallons()*getFuelEconomyInMilesPerGallon();
	}
	
	
	
	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
