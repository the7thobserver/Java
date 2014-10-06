
public class Bolt 
{
	public int size;
	private boolean isShiny;
	Bolt bolt2;
	
	public Bolt()
	{
		isShiny = false;
	}
	
	public void setShiny()
	{
		isShiny = true;
	}
	
	public boolean isShiny()
	{
		return isShiny;
	}
	
	public void createBolt2()
	{
		bolt2 = new Bolt();
		bolt2.size = 50;
	}
	
	public boolean equals(Bolt b)
	{
		return b.size == size;
	}
}
