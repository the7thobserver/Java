import java.util.Arrays;


public class SentenceRev 
{
	public static void main(String[] args)
	{
		System.out.println("\""+reverseWords(" 1")+"\"");
		System.out.println("\""+reverseWords("the blue sky there")+"\"");
		System.out.println("\""+reverseWords("     a           ")+"\"");
	}

	public static String reverseWords(String s) {
		// remove extra white spaces
		s = s.trim().replaceAll(" +", " ");
		// split by spaces
		String[] exp = s.split(" ");
		
//		System.out.println(Arrays.toString(exp));
		
		// 1 item + space case
		if(exp.length == 2)
		{
			if(exp[0].equals(""))
			{
				return exp[1];
			}
		}
		
		// flip words
		for(int i = 0; i < exp.length/2; i++)
		{
			String temp = exp[i];
			exp[i] = exp[exp.length - 1- i];
			exp[exp.length - 1 - i] = temp;
		}
		
		String ans = "";
		// concat together
		for(int i = 0; i < exp.length - 1; i++)
			ans += exp[i] + " ";
		
		// see if the last item to be added is a space
		if(exp.length != 0 && !(exp[exp.length - 1].equals(" ")))
		{	
			ans += exp[exp.length - 1];
		}
		
		return ans;
    }

}
