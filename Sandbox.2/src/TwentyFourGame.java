import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


public class TwentyFourGame 
{
	public static void main(String args[])
	{
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		int[] x = new int[4];
		
		for(int i = 0; i < 4; i++)
		{
			x[i] = rand.nextInt(10);
			System.out.println(x[i]);
		}
//		System.out.println("Answer!");
//		
//		String ans = null;
//		try {
//			ans = bufferRead.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Ans: " + ans);
		
		String ans = "9+3*4-1";
		
		char[] a = ans.toCharArray();
		
		for(int i = 0; i < a.length; i++)
		{
			// PEMDAS
			
		
		}
	}
	
}
