
public class Bike 
{
	private int speed = 10;
	
	public Bike()
	{
		
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int i)
	{
		speed = i;
	}

	public boolean equals(Bike bike)
	{
		return speed == bike.speed;
	}
}
