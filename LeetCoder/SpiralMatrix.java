import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
//		int[][] matrix =   {{ 1, 2, 3 },
//				 { 8, 9, 4 },
//				 { 7, 6, 5 }};
				 
//		int[][] matrix = {{1,2,3,4},
//						{10,11,12,5},
//						{9,8,7,6}};
		
//		int[][] matrix= {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48,49,50},{51,52,53,54,55,56,57,58,59,60},{61,62,63,64,65,66,67,68,69,70},{71,72,73,74,75,76,77,78,79,80},{81,82,83,84,85,86,87,88,89,90},{91,92,93,94,95,96,97,98,99,100}};
		
//		int[][] matrix =  	{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		
//		int[][] matrix = {{1,2},{3,4}};
				
//		int[][] matrix = {{2,5,8},{4,0,-1}};
		
		int[][] matrix = {{1,2,3,4},
						{12,13,14,5},
						{11,16,15,6},
						{10,9,8,7}};
		
		SpiralMatrix m = new SpiralMatrix();
		List<Integer> l = m.spiralOrder(matrix);
		
//		m.spiralOrder(matrix);
		
		for(int i = 0; i < l.size(); i++)
			System.out.print(l.get(i) + " ");
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		int v = matrix.length;
		
		if(matrix == null || (matrix.length == 0 || matrix[0].length == 0))
			return new ArrayList<Integer>();
		
		ArrayList<Integer> a = new ArrayList<Integer>();

		// row vector
		if(matrix.length == 1)
		{
			for(int i = 0; i < matrix[0].length; i++)
				a.add(matrix[0][i]);
			
			return a;
		}
		
		// column vector
		if(matrix[0].length == 1)
		{
			for(int i = 0; i < matrix.length; i++)
				a.add(matrix[i][0]);
			
			return a;
		}
		
		
		int start = 0;
		int end_h = matrix[0].length ;
		int end_v = matrix.length - 1;
		
		int row_h = 0;
		int col_h = 0;
		
		int row_v = end_v;
		int col_v = 0;
		
		int begin_x = 0;
		int begin_y = 0;
		
//		System.out.println(matrix.length + " " + matrix[0].length);
		
//		 Spirally
		while(true)
		{
			System.out.println(start + " " + end_h);
			
			// left
			for(int i = start; i < end_h; i++)
			{
				System.out.println(row_h + " " + i + " " + matrix[row_h][i]);
				a.add(matrix[row_h][row_h+i]);
			}
			
			col_h = end_h - 1;
			
			// down
			for(int i = start + 1; i <= end_v; i++)
			{
//				System.out.println(i + " " + col_h + " " + matrix[i][col_h]);
				a.add(matrix[i][col_h]);
			}
			
			row_h = col_h - 1;
			row_v--;
			// right
			for(int i = end_h - 2; i >= start; i--)
			{
//				System.out.println(row_h + " " + i + " " + matrix[row_v][i]);
				a.add(matrix[row_v][i]);
			}
			
			end_h = row_h;
			col_h = start;
				
//			System.out.println("Up");
			// up
			for(int i = end_h; i > start; i--)
			{
//				System.out.println(i + " " + col_h + " " + matrix[i][col_h]);
				a.add(matrix[i][col_h]);
			}
			
			begin_x++;
			begin_y++;
			row_h = begin_x;
//			end_h--;
			row_v = begin_x;
			end_v--;
			start++;
					
//			System.out.println("END " + matrix.length/2 + " " + matrix[0].length/2);
//			System.out.println("TAR " + begin_x + " " + begin_y);
			
			if(begin_y == matrix.length/2 || begin_x == matrix[0].length/2)
			{
				// add all to the right
//				System.out.println((begin_x - 1) + " " + (row_h + matrix[0].length - 1 - begin_x));
				if(matrix.length == 2)
					break;
				
//				System.out.println(matrix.length + " " + matrix[0].length);
				
				for(int i = begin_x - 1; i < row_h + matrix[0].length - 1 - begin_x; i++)
				{
					a.add(matrix[begin_y][i]);
				}
				break;
			}
		}
		return a;
	}
	
//	int j = 0;
//	
//	while(true)
//	{
//		for(int i = 0; i < matrix[0].length; i++)
//		{
//			a.add(matrix[j][i]);
//		}
//		j++;
//		if(j == matrix.length)
//			break;
//	}
//
//	return a;
	
	
}
