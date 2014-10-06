public class Palindrome {

	// explaination
	// https://dl.dropboxusercontent.com/u/5102757/palindrome.png
	// http://www.reddit.com/r/dailycode/comments/2dty2t/code_explaination_longest_palindrome_subsequence/

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		String str = "CABDBA";
		System.out.println(p.longestPalindromeDP(str));
	}

	String longestPalindromeDP(String str) {
		int n = str.length();
		char[] s = str.toCharArray();

		int longestBegin = 0;
		int maxLen = 1;

		boolean[][] table = new boolean[n][n];

		// for(int i = 0; i < n; i++)
		// for(int j = 0; j < n; j++)
		// table[i][j] = false;

		// diag to true
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}

		// compare items next to each other
		for (int i = 0; i < n - 1; i++) {
			if (s[i] == s[i + 1]) {
				table[i][i + 1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}

		for (int len = 3; len <= n; len++) { // check lens of 3+, already
												// checked 1,2 above
			for (int i = 0; i < n - len + 1; i++) { // move across string
				int j = i + len - 1; // mirror

				System.out.println(i + " " + j + " " + s[i] + " " + s[j]);
				if (s[i] == s[j] && table[i + 1][j - 1]) {
					table[i][j] = true;
					longestBegin = i;
					maxLen = len;

					// printTable(table, s);

				}
			}
		}

		return str.substring(longestBegin, longestBegin + maxLen);
	}

	private void printTable(boolean[][] table, char[] s) {
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i < table.length; i++)
			System.out.print(s[i] + " ");
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			System.out.print(s[i] + " ");

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
