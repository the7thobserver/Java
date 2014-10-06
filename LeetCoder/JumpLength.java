import java.util.Arrays;

public class JumpLength {

	public static void main(String[] args) {
		JumpLength j = new JumpLength();
		int[] A = 
//			{1,0,1,1};
//			{2,0};
//		{ 1,0,1,0};
//			{2,0,0};
//		 {3,0,0,1,0,4};
//		 {2,3,0,0,4};
//		 {1,2,0,1,4};
//		 {10,9,8,7,6,5,4,3,2,1,0};
//			{1,1,1,1};
//		{1,1,1,1,2,1,1,0};
//		{1,1,2,0,1,1,2,0,1,0};
			{0,1};
		
		System.out.println(j.canJump(A));
	}

	public boolean canJump(int[] A) {
		// A is null or has nothing
		if (A == null || A.length == 0)
			return false;
		// A has one element, return true regardless
		if (A.length == 1)
			return true;
		// This never goes
		if (A[0] == 0 && A.length == 1)
			return true;
		
		// Table that I don't use - debugging
		boolean[] table = new boolean[A.length];

		// Loop over input and ignore last tile - doesn't matter what value it is
		for (int i = 0; i < A.length - 1; i++) {
			// If encounter a 0, can't go any further
			if(A[i] == 0)
				return false;
			// Depth first search-ish
			if (deapth(table, i, A))
				return true;
		}
		
		// Print debug info
		System.out.println(Arrays.toString(table));

		// If reached here, went through whole array and couldn't reach the end
		return false;
	}

	private boolean deapth(boolean[] table, int i, int[] A) {
		// Over jump == true
		if (i >= (table.length  - 1))
		{
			table[A.length - 1] = true;
			return true;
		}
		
		// If the next step A[i] is 0
		if (A[i] == 0)
			return false;
		
		// Same as first if
		if(i > A.length - 1)
			return true;
		
		// Debug info
		table[i] = true;
		
		// Reached the end, return true
		if (table[A.length - 1])
			return true;

		// Continue moving forward with new jump
		return deapth(table, i + A[i], A);
	}

	// Unused method
	private void print2d(boolean[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if (table[i][j])
					System.out.print("T ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
