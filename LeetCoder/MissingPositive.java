public class MissingPositive {

	public static void main(String[] args) {
		MissingPositive x = new MissingPositive();
		int[] A = {1,2,3,0,4};
		
		System.out.println(x.firstMissingPositive_v2(A));
	}
	
	// DUPLICATES?
	/*
	 * 2,2 
	 * 1
	 * 
	 * 2,2,3,3,2,2
	 * 1
	 * 
	 */
	
	public int firstMissingPositive_v2(int[] A)
	{
        if (A.length == 0) return 1;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= A.length && A[i] > 0 && A[i] != i+1) {
            	
            	System.out.println(A[A[i] - 1] + " " + A[i]);
            	
                if (A[A[i]-1] != A[i]) { //line 9
                    int tmp = A[A[i]-1];
                    A[A[i]-1] = A[i];
                    A[i] = tmp;
                    i--; //line 13
                }
            }           
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) return i+1;
            System.out.println(A[i] + " " + i);
        }
        return A.length+1;
	}

	public int firstMissingPositive(int[] A) {
		if(A == null)
			return 0;
		if(A.length == 0)
			return 1;
		// 0 1 case || 1
		if((A.length == 1 || A[1] == 0) && A[0] == 1)
			return A[0] + 1;
		// 0 X case
		if((A.length == 1 || A[1] == 0)&& A[0] > 1)
			return 1;
		
		int max = 0;
		int sum = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] > max)
			{
				max = A[i];
			}
			
			if(A[i] > 0)
				sum += A[i];
		}
		
		// equation
		int posSum = (max * (max - 1));
		
		System.out.println(max + " " + sum + " " + posSum);
		
		//0 1 2 case
		if(posSum == 2 && sum == 3)
			return 3;
		
		if(sum == posSum)
			return max + 1;
		
		// what if need next one
		
		
		return sum - (posSum/2);
	}
}
