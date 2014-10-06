
public class RomanNumerals {
	  public int romanToInt(String s) {
		  s = s.toUpperCase();
		  char[] c = s.toCharArray();
		  
		  int sum = 0;
		  
		  for(int i = 0; i < c.length; i++)
		  {
			  if(c[i] == 'I')
				  sum++;
			  else if(c[i] == 'V')
				  sum += 5;
			  else if(c[i] == 'X')
				  sum += 10;
			  else if(c[i] == 'L')
				  sum += 50;
			  else if(c[i] == 'C')
				  sum += 100;
			  else if(c[i] == 'D')
				  sum += 500;
			  else if(c[i] == 'M')
				  sum += 1000;
			  
		  }
		  
		  return sum;
	    }
}
