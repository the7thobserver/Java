public class Rotate90 {
	public static void main(String[] args) {
		Rotate90 r = new Rotate90();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		r.rotate(matrix);
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		int[][] rotate = new int[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				rotate[i][j] = matrix[matrix.length - 1 - j][i];
			}
		}
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
			{
				matrix[i][j] = rotate[i][j];
			}
		}
		
		
	}
}
