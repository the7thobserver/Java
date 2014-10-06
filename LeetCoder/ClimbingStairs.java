import java.util.ArrayList;

public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		int n = 7;
		System.out.println(c.climbStairs(1));
	}
	//[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 
//	28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 
//	14930352, 24157817, 39088169]

	
	/*
	 * 1 1 1 1 1
	 * 2 1 1 1 
	 * 1 2 1 1
	 * 1 1 2 1
	 * 1 1 1 2
	 * 2 2 1
	 * 2 1 2
	 * 1 2 2
	 * 
	 * 1 1 1 1
	 * 2 1 1
	 * 1 2 1
	 * 1 1 2
	 * 2 2
	 * 
	 * 
	 * 1 1 1
	 * 2 1
	 * 1 2
	 */
	
	// 1 2 3 5 8... wow it's the fib seq...

	int total = 0;

	public int climbStairs(int n) {
		total = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(1);
		
		climbHelper(n, 1, path);
		
		path.clear();
		path.add(2);
		climbHelper(n, 2, path);
		
		return total;
	}
	
	public void climbHelper(int n, int total_steps_taken, ArrayList<Integer> path)
	{
		if(total_steps_taken > n)
			return;
		
		if(total_steps_taken == n)
		{
//			for(int i = 0; i < path.size(); i++)
//				System.out.print(path.get(i) + " ");
//			
//			System.out.println();
			total++;
		}
		
		ArrayList<Integer> path1 = (ArrayList<Integer>) path.clone();
		path1.add(1);
		climbHelper(n, total_steps_taken + 1, path1);
		
		
		ArrayList<Integer> path2 = (ArrayList<Integer>) path.clone();
		path2.add(2);
		climbHelper(n, total_steps_taken + 2, path2);
	}
}
