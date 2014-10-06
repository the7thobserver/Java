import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] digits = {9,9,9,9};
		System.out.println(Arrays.toString(p.plusOne(digits)));
	}

	public int[] plusOne(int[] digits) {
		if(digits.length == 0)
			return digits;
		
		int temp = digits[digits.length - 1] + 1;
		int carry = 0;
		if(temp >= 10)
		{
			digits[digits.length - 1] = temp % 10;
			carry = 1;
		}
		else
			digits[digits.length - 1] = temp;
		
		for(int i = digits.length - 2; i >= 0; i--)
		{
			System.out.println(digits[i]);
			
			temp = digits[i] + carry;
			
			if(temp >= 10)
			{
				digits[i] = temp % 10;
				carry = 1;
			}
			else
			{
				digits[i] = temp;
				carry = 0;
			}
		}
		
		int[] ans;
		
		if(digits[0] == 0)
		{
			ans = new int[digits.length + 1];
			
			for(int i = digits.length - 1; i >= 0; i--)
				ans[i + 1] = digits[i];
			
			ans[0] = 1;
		}
		else
			ans = digits.clone();
		
		
		return ans;
	}
}
