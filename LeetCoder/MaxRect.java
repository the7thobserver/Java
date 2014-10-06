import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxRect {
	public static void main(String[] args) {
		char[][] m = {
				{'1'}
		};
		
		MaxRect r = new MaxRect();
		System.out.println(r.maximalRectangle(m));
	}

	public int maximalRectangle(char[][] matrix) {

		int max = 0;

		// bfs rectangle -> keep track of size 8
		Queue<Character> q = new LinkedList<Character>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		q.add(matrix[0][0]);
		visited[0][0] = true;
		int i = 0, j = 0;
		
		int temp_max = 0;
		while(!q.isEmpty())
		{
			char temp = q.remove();
			
			if(temp == '0')
			{
				System.out.println("...");
			}
			
			if(temp == '1')
			{
				temp_max++;
				
				if(temp_max > max)
					max = temp_max;
				
				if(j != matrix[0].length - 1);
					q.add(matrix[i][j + 1]);
				if(i != matrix.length - 1)
					q.add(matrix[i + 1][j]);
				if(j != 0)
					q.add(matrix[i][j - 1]);
				if(i != 0)
					q.add(matrix[i - 1][j]);
			}
					
		}
		
		return max;
	}
}
