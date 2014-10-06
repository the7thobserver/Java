import java.util.Scanner;


public class UniverseAnswer 
{
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
	   // int in = scn.nextInt();
	    int in = 0;
	    
	    while(in != 42)
	    {
	    	in = scn.nextInt();
	    	if(in == 42)
	    		break;
	    	System.out.println(in);
	    }
	}
}
