import java.util.Arrays;

public class AddBinary {
	public static void main(String[] args) {
		String a = "0";
		String b = "1";
		
		AddBinary c = new AddBinary();
		System.out.println(c.addBinary(a, b));
	}

	public String addBinary(String a, String b) {
		if(a == null || b == null || a.length() == 0 || b.length() == 0)
			return "";
		
		if(a.equals("0") && b.equals("0"))
			return "0";
		
		char[] a_ = a.toCharArray();
		char[] b_ = b.toCharArray();
		
		int min = 0, max = 0;
		boolean first = false;
		
		if(a.length() < b.length()) 
		{
			min = a.length();
			max = b.length();
		}
		else
		{
			min = b.length();
			max = a.length();
			first = true;
		}
		
		char[] ans = new char[max + 1];
		
		int carry = 0;
		int index = ans.length - 1;
		
		for(int i = min - 1; i >= 0; i--)
		{
			int sum = Integer.parseInt(a_[i] + "") + Integer.parseInt(b_[i] + "") + carry;
			
//			System.out.println(sum + " " + a_[i] + " " + b_[i] + " " + carry);
			if(sum == 2)
			{
				ans[index] = '0';
				carry = 1;
			}
			else if(sum == 3)
			{
				ans[index] = '1';
				carry = 1;
			}
			else if(sum == 1)
			{
				ans[index] = '1';
				carry = 0;
			}
			else
			{
				ans[index] = '0';
				carry = 0;
			}
			index--;
		}
			
		for(int i = min - 1; i < max; i++)
		{
//				System.out.println(a_[i] + " " + b_[i] + " " + carry);
			if(first)
			{
				int sum = Integer.parseInt(a_[i] + "") + carry;
				
				if(sum == 2)
				{
					ans[index] = '0';
					carry = 1;
				}
				else if(sum == 3)
				{
					ans[index] = '1';
					carry = 1;
				}
				else if(sum == 1)
				{
					ans[index] = '1';
					carry = 0;
				}
				else
				{
					ans[index] = '0';
					carry = 0;
				}
				index--;
			}
			else
			{
			
				int sum = Integer.parseInt(b_[i] + "") + carry;
								
				if(sum == 2)
				{
					ans[index] = '0';
					carry = 1;
				}
				else if(sum == 3)
				{
					ans[index] = '1';
					carry = 1;
				}
				else if(sum == 1)
				{
					ans[index] = '1';
					carry = 0;
				}
				else
				{
					ans[index] = '0';
					carry = 0;
				}
				index--;
			}
		}
				
		if(carry == 1)
			ans[0] = '1';
		
		// all 0's
		if(ans[0] == '0')
			for(int i = 0; i < ans.length; i++)
			{
				if(ans[i] == '0')
				{
					ans[i] = '\u0000';
				}
				else
					break;
			}
		
		return new String(ans);
	}
}
