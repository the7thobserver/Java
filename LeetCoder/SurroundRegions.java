public class SurroundRegions {
	public static void main(String[] args) {
		 char[][] b = 
//		{ { 'X', 'X', 'X', 'X' }, 
//				{ 'X', 'O', 'O', 'X' },
//				{ 'X', 'X', 'O', 'X' }, 
//				{ 'X', 'O', 'X', 'X' },
//				{'X','X','X','X'}};
		
			{
				{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}

				};
	
		SurroundRegions r = new SurroundRegions();
		r.solve(b);
		r.print2D(b);
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
	        return;
	    
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'O' && !visited[i][j])
					depthCheck(i,j,i,j,visited,board);
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.')
					board[i][j] = 'X';
			}
		}
	}

	int count = 0;
	
	// 'dfs' -check around
	private boolean depthCheck(int ipre, int jpre, int icur, int jcur, boolean[][] visited, char[][] board) {
		if(icur == 0 || icur == board.length - 1 || jcur == 0 || jcur == board[0].length -1)
		{
			visited[icur][jcur] = true;
			return false;
		}
		// visited and X
		
		if(visited[icur][jcur] || board[icur][jcur] == 'X')
		{
			visited[icur][jcur] = true;
			return true;
		}
		
		visited[icur][jcur] = true;
		
		boolean t;
		
		t = depthCheck(icur,jcur,icur - 1, jcur, visited, board);
		if(!t) return false;
		t = t & depthCheck(icur,jcur,icur, jcur + 1, visited, board);
		if(!t) return false;
		t = t & depthCheck(icur,jcur,icur, jcur - 1, visited, board);
		if(!t) return false;
		t = t & depthCheck(icur,jcur,icur + 1, jcur, visited, board);
		if(!t) return false;

		if(board[icur][jcur] == 'O' && t)
			board[icur][jcur] = '.';
		
		
		return t;
	}

	private void print2D(char[][] table) {
		System.out.println("--");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
