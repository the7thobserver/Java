import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle x = new PascalTriangle();
		
//		List<List<Integer>> z = x.generate(2);
//		
//		System.out.println("---");
//		for(int i = 0; i < z.size(); i++)
//		{
//			for(int j = 0; j < z.get(i).size(); j++)
//				System.out.print(z.get(i).get(j) + " ");
//			System.out.println();
//		}
		
		List<Integer> z = x.getRow(1);
		
		System.out.println("Size: " + z.size());
		
		for(int i = 0; i < z.size(); i++)
			System.out.print(z.get(i) + " ");
	}

	public List<List<Integer>> generate(int numRows) 
	{
		if(numRows <= 0)
			return new ArrayList<List<Integer>>();
		
		List<List<Integer>> x = new ArrayList<List<Integer>>();
		for(int i = 0; i < numRows; i++)
		{
			x.add(new ArrayList<Integer>());
		}
		generate(numRows, x, numRows);
		
		return x;
	}

	private void generate(int numRows, List<List<Integer>> x, int end) {
		// base, first element is a triangle
		if(numRows == 0)
		{
			x.get(0).add(1);
			return;
		}
		
		// up the triangle
		generate(numRows - 1, x, end);
		
		// leave if we're done
		if(numRows == end)
			return;
		
		// add the 1 at the beginning
		x.get(numRows).add(1);
		
		// follow pascals triangle rule and add it
		for(int i = 0; i < x.get(numRows - 1).size() - 1; i++)
			x.get(numRows).add(x.get(numRows - 1).get(i) + x.get(numRows - 1).get(i + 1));
		
		// add the 1 at the end
		x.get(numRows).add(1);
	}
	
	public List<Integer> getRow(int rowIndex) 
	{
		List<Integer> x = new ArrayList<Integer>();
		
		if(rowIndex <= 0)
		{
			x.add(1);
			return x;
		}
		x.add(1);
		
		return generateRow(rowIndex, x, rowIndex);
	}

	private List<Integer> generateRow(int rowIndex, List<Integer> x, int end) {
		// base, first element is a triangle
		if(rowIndex == 0)
		{
			x.add(1);
			return x;
		}

		// up the triangle
		x = generateRow(rowIndex - 1, x, end);
		
//		System.out.println("Return: " + x.size());
		
		// leave if we're done
		if(rowIndex == end)
			return x;
		
		List<Integer> temp = new ArrayList<Integer>();
		
		// add the 1 at the beginning
		temp.add(1);
		
		// follow pascals triangle rule and add it
		for(int i = 0; i < x.size() - 1; i++)
			temp.add(x.get(i) + x.get(i + 1));
		
		// add the 1 at the end
		temp.add(1);
		
		return temp;
	}	
}
