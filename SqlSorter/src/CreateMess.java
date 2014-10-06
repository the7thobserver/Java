import java.util.Random;


public class CreateMess 
{
	static Random rand = new Random();
	
	public static void main(String[] args)
	{
		String[] titles = {
			"rec_location_repeater",
			"rec_location_repeater_X_rec_loc_city",
			"rec_location_repeater_X_rec_loc_state",
			"rec_location_repeater_X_rec_loc_country",
		};
		
		
		
		int l = 0;
		int PID = getRandom(1000);
		String answer = "HI";
		int repeat = getRandom(5);
		
		// Total number of "cards"
		for(int i = 0; i < 3; i++)
		{
			System.out.println("INSERT INTO `a5048228_mess`.`mess` (`post_id`, `meta_key`, `meta_value`"
					+ ") VALUES (" + PID + ", \"" + titles[0] + "\", \"" + repeat +"\");");
			
			// repeats
			for(int k = 0; k < repeat; k++)
			{
				// card data
				for(int j = 1; j < titles.length; j++)
				{
					if(j == 1)
						answer = "City " + l;
					else if(j == 2)
						answer = "State " + l;
					else if(j == 3)
						answer = "Country " + l;
					
					System.out.println("INSERT INTO `a5048228_mess`.`mess` (`post_id`, `meta_key`, `meta_value`"
						+ ") VALUES (" + PID+ ", \"" + titles[j] + "\", \"" + answer + "\");");
				
				}
				l++;
			}
			repeat = getRandom(5);
			PID = getRandom(1000);
		}
		
		// INSERT INTO `sqlsorter`.`mess` (`ID`, `MetaKey`, `MetaData`, `Lang`, `Long`) 
		// VALUES (`512`, `THIS_DEFAULT_TITLE_0_OTHER_STUFF`, `title0`, `0`, `0`);
	}

	private static int getRandom(int m) {
		int x = rand.nextInt(m) + 1;
		
		if(x <= 0)
			return getRandom(m);
		
		return x;
	}
	
	

}
