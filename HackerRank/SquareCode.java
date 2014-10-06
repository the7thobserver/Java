import java.util.Scanner;


public class SquareCode 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	    String code = in.next();
	    
	    //floor(sqrt( len(word) )) <= width, height <= ceil(sqrt( len(word) ))
	    int min = (int) Math.floor(Math.sqrt((code.length())));
	    int max = (int) Math.ceil(Math.sqrt((code.length())));
	    
//	    System.out.println(min + " " + max);
	    if(min + max < code.length())
	    	min += 1;
	    
	    char[][] x = new char[min][max];
	    
	    char[] c = code.toCharArray();
	    int index = 0;
	    
	    for(int i = 0; i < min; i++)
	    	for(int j = 0; j < max; j++)
	    	{
	    		if(index >= c.length)
	    			break;
	    		
	    		x[i][j] = c[index];
	    		index++;
	    	}
	    
	    // debug=================================
	
//	    for(int i = 0; i < min; i++)
//	    {
//	    	for(int j = 0; j < max; j++)
//	    	{
//	    		System.out.print(x[i][j]);
//	    	}
//	    	System.out.println(" ");
//	    }
	    
	    // =======================================
	    
	    for(int i = 0; i < max; i++)
	    {
	    	for(int j = 0; j < min; j++)
	    	{
	    		if(x[j][i] == '\u0000')
	    			continue;		

	    		System.out.print(x[j][i]);
	    	}
	    	System.out.print(" ");
	    }
	  	
	}
	 
}
