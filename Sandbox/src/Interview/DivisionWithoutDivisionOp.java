package Interview;

public class DivisionWithoutDivisionOp {

	public static void main(String[] args) {
		System.out.println("Answer Remainder");
		div(2,4);
		div(3,18);
		div(11,100);
		div(2,1);
		div(2,10);
	}

	private static void div(int i, int j) {
		int exp = 1;
		int temp = j; 
		
		// Fractions
		if(j < i)
		{
			System.out.println("0 " + i);
			return;
		}
		
		while(temp > 0)
		{
			temp -= i;
			exp++;
		}
		
		// If go too far
		if(temp < 0)
		{
			temp += i;
			exp--;
		}
		
		
		System.out.println((exp-1) + " " + temp);
	}
}
