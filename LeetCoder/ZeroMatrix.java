public class ZeroMatrix {
	public static void main(String[] args) {
		ZeroMatrix z = new ZeroMatrix();
		int[][] matrix = {
//				{1,0,0,1},
//				{0,1,1,1},
//				{1,1,1,1},
//				{1,1,1,1}
				
//				{1,1,1},
//				{0,1,2}
	
//				{0,1}
				
//				{1,2,3,4},
//				{5,0,5,2},
//				{8,9,2,0},
//				{5,7,2,1}	
	
//				{1,2,3},
//					{4,0,6},
//					{7,8,9}
				
//				{0,0,0,5},
//				{4,3,1,4},
//				{0,1,1,4},
//				{1,2,1,3},
//				{0,0,1,1}
				
				{-4,-2147483648,6,-7,0},
				{-8,6,-8,-6,0},
				{2147483647,2,-9,-6,-10}
				};
		z.setZeroes(matrix);
		
		z.print2D(matrix);
	}

	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
		
		boolean zeroRow = false;
		boolean zeroCol = false;
		
		// See if first row/col have any zeroes
		for(int i = 0; i < matrix.length; i++)
			if(matrix[i][0] == 0)
				zeroCol = true;
		
		for(int i = 0; i < matrix[0].length; i++)
			if(matrix[0][i] == 0)
				zeroRow = true;
		
		// Find zeroes
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{	
				if(matrix[i][j] == 0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = Integer.MAX_VALUE - 4;
				}
			}
		}
			
//		print2D(matrix);
		
		// Check row
		for(int i = 0; i < matrix.length; i++)
		{
			if(matrix[i][0] == 0)
				zeroRow(i, matrix);
		}
			
		// Check col
		for(int i = 0; i < matrix[0].length; i++)
		{
			if(matrix[0][i] ==  Integer.MAX_VALUE - 4)
				zeroCol(i, matrix);
		}
		
		// Zero first row/col
		if(zeroRow)
			zeroRow(0, matrix);
		
		if(zeroCol)
			zeroCol(0, matrix);
	}

	private void zeroCol(int a, int[][] matrix) {
		for(int i = 0; i < matrix.length; i++)
		{
			matrix[i][a] = 0;
		}
	}

	private void zeroRow(int a, int[][] matrix) {
		
		for(int i = 0; i < matrix[0].length; i++)
		{
			// The case:
//			{-4,-2147483648,6,-7,0},
//			{-8,6,-8,-6,0},
//			{2147483647,2,-9,-6,-10}
//			Skips if we found an edge, IE in this case it would skip the last row, so it would catch the -10
//			on the zeroCol(...)
			
			if(matrix[a][i] == Integer.MAX_VALUE - 4)
				continue;
			
			matrix[a][i] = 0;
		}
		
	}
	
	private void print2D(int[][] table) {
		System.out.println("--");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
