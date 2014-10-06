
public class MtBike extends Bike
{
	private int speed;
	
	public MtBike()
	{
		this.setSpeed(getSpeed()); 
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
