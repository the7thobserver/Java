public class RotateInt {
	public static void main(String[] args) {
		RotateInt r = new RotateInt();
		int x = -10;
		System.out.println(x + " : " + r.reverse(x));
	}

	public int reverse(int x) {
		char[] c = String.valueOf(x).toCharArray();
		int i = 0;
		boolean sign = false;

		if (c[0] == '-' || c[0] == '+') {
			sign = true;
			i = 1;
		}

		if (sign)
			for (; i <= c.length / 2; i++)
				swap(c, i, c.length - i);
		else
			for (; i < c.length / 2; i++) 
				swap(c, i, c.length - i - 1);
			
		// Java nicely takes care of the case where if there's 0's in front
		return Integer.parseInt(new String(c));
	}

	private void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
}
