import java.util.*;
class Statistician
{
	private double highest = Integer.MIN_VALUE;
	private double lowest = Integer.MAX_VALUE;
	private double total = 0;
	private int count = 0;
	private double last;

	public Statistician(double highest, double lowest, double total, int count)
	{
		this.highest = highest;
		this.lowest = lowest;
		this.total = total;
		this.count =count;
	}
	
	public void nextNumber(double number)
	{
		count++;
		last = number;
		
		if(highest < number)
			highest = number;
		if(lowest > number)
			lowest = number;
		
		total = total + number;
	}

	public double getHighest()
	{return highest;}
	public double getLowest()
	{return lowest;}
	public int getCount()
	{return count;}
	public double getTotal()
	{return total;}
	public double getLast()
	{
		return last;
	}
}
