public class Search2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };

//		 int[][] matrix = {{1,1},{3,3}};
//		int[][] matrix = 
//			{{-9,-9,-9,-7,-5,-3,-3,-3},{-2,-2,0,1,2,3,3,4},{5,5,5,7,9,11,11,12},{14,14,15,16,18,18,19,20},{21,23,24,25,27,29,30,31},{34,35,37,38,38,38,40,40},{42,44,44,45,47,47,47,48},{50,51,51,52,53,54,56,56},{58,59,60,62,64,64,64,66}};
//			 	{{1,3,5,7},{10,11,16,20},{23,30,34,50}};

		Search2DMatrix m = new Search2DMatrix();
		int target = 21;
		System.out.println(m.searchMatrix_b(matrix, target));
	}
	
	public boolean searchMatrix_b(int[][] matrix, int target) {
		// null
		if (matrix == null)
			return false;

		// out of bounds
		if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
			return false;
			
		// single
		if (matrix.length == 1 && matrix[0].length == 1)
			return (matrix[0][0] == target);
	
		// row
		if (matrix.length == 1)
			return searchRow(matrix, target);
		
		// column
		if (matrix[0].length == 1)
			return searchCol(matrix, target);
		
		int imin = 0;
		int imax = matrix.length - 1;
		int prev = -1;
		int row = -1;
		int imid = 0;
		
		// vertical
		while (imax >= imin) {
//			System.out.println(imin + " " + imax);

			imid = (imin + imax) / 2;

			System.out.println("MID "  + matrix[imid][0]);

			if(matrix[imid][0] == target)	// if we found it we're done
				return true;
			else if (prev == 0 && matrix[imid-1][0] < target && matrix[imid][0] > target)	// need to check if target is between the column values
			{
				row = imid - 1;
				break;
			}
			else if(prev == 1 && matrix[imid + 1][0] > target && matrix[imid][0] < target)	// checks if >
			{
				row = imid - 1;
				break;
			}
			else if (matrix[imid][0] < target)	// binary search
			{
				imin = imid + 1;
				prev = 0;
			}
			else if(matrix[imid][0] > target)
			{
				imax = imid - 1;
				prev = 1;
			}
//			System.out.println(imid + " " + imax);
		}
		
		System.out.println("IGNORE " + row);
		
		// pretty sure this isn't used anymore
		if(row == -1)
		{
			if(matrix[0][0] > target)
				return false;
			else if(matrix[imid][0] < target)
				row = imid;
		}
//		System.out.println("ROW " + row);
		
		imin = 0;
		imax = matrix[0].length;
		
		// binary horizontal
		while(imax >= imin)
		{
			imid = (imax + imin) / 2;
//			System.out.println(imid);
				
			if(imid >= matrix[0].length)
				return false;
			
			if(matrix[row][imid] == target)
				return true;
			else if(matrix[row][imid] < target)
			{
				imin = imid + 1;
				prev = matrix[row][imid];
			}
			else
			{
				imax = imid - 1;
				prev = matrix[row][imid];
			}
		}

		return false;
	}

	/**
	 * search a single colum matrix
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	private boolean searchCol(int[][] matrix, int target) {
		int imin = 0;
		int imax = matrix.length - 1;
		
		while(imax >= imin)
		{
			int imid = (imax + imin) / 2;
			if(matrix[imid][0] == target)
				return true;
			else if(matrix[imid][0] < target)
				imin = imid + 1;
			else
				imax = imid - 1;
		}
		
		return false;
	}

	/**
	 * search a single row matrix
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	private boolean searchRow(int[][] matrix, int target) {
		int imin = 0;
		int imax = matrix[0].length - 1;
		
		while(imax >= imin)
		{
			int imid = (imax + imin) / 2;
		
//			System.out.println(matrix[0][imid]);
			if(matrix[0][imid] == target)
				return true;
			else if(matrix[0][imid] < target)
				imin = imid + 1;
			else
				imax = imid - 1;
		}
		
		return false;
	}

	/**
	 * iterative approach
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0;
		int j = 0;

		// null
		if (matrix == null)
			return false;

		// single
		if (matrix.length == 1 && matrix[0].length == 1)
			return (matrix[0][0] == target);

		// row
		if (matrix.length == 1) {
			for (; i < matrix[0].length; i++) {
				if (matrix[j][i] == target)
					return true;
			}

			return false;
		}

		// col
		if (matrix[0].length == 1) {
			// System.out.println("col");

			for (; i < matrix.length; i++) {
				// System.out.println(matrix[i][j]);

				if (matrix[i][j] == target)
					return true;
			}

			return false;
		}

		while (true) {

			// System.out.println("LOOKING AT " + matrix[i + 1][j]);

			if (matrix[i + 1][j] == target)
				return true;
			if (matrix[i + 1][j] > target) {
				// binary search
				for (; j < matrix[0].length; j++) {
					// System.out.println("LOOKING AT " + matrix[i][j]);

					if (matrix[i][j] == target)
						return true;
				}

				return false;
			} else {
				i++;
			}

			if (i == matrix.length)
				break;
		}

		return false;
	}

}
