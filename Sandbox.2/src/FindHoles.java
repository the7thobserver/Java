
public class FindHoles 
{
	static int[][] data = {{ 0, 0, 0, 1, 0},
							{ 1, 0, 1, 0, 1},
							{ 1, 0, 1, 0, 0},
							{ 0, 0, 0, 1, 1}};
	
	static boolean[][] visited = new boolean[data.length][data[0].length];
	
	public static void main(String[] args)
	{
		int ans = findHoles();
		System.out.println("Num holes " + ans);
	}

	private static int findHoles() {
		int numHoles = 0;
		
		for(int i = 0; i < data.length; i++)
			for(int j = 0; j < data[0].length; j++)
				numHoles = visit(i,j, numHoles);
		
		return numHoles;
	}

	private static int visit(int i, int j, int numHoles) {
		if(visited[i][j])
			return numHoles;
		
		if(data[i][j] == 0)
		{
			explore(i, j);
			numHoles++;
		}
		else
			visited[i][j] = true;

		return numHoles;
	}

	private static void explore(int i, int j) {
		// Look N/S/W/E
		if(visited[i][j])
			return;
		
		visited[i][j] = true;
		
		// North
		if(i != 0)	// not a boundary
		{
			if(data[i][j] == 0)	// part of the hole
				explore(i - 1, j);
		}
		
		// East
		if(j != data[0].length - 1)
		{
			if(data[i][j] == 0)
				explore(i, j + 1);
		}
		
		// South
		if(i != data.length - 1)
		{
			if(data[i][j] == 0)
				explore(i + 1, j);
		}
		
		// West
		if(j != 0)
		{
			if(data[i][j] == 0)
				explore(i, j - 1);
		}
	}

}
