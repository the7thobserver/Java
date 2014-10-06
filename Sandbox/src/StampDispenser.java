/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
	private int[] stampDenominations;
    /**
     * Constructs a new StampDispenser that will be able to dispense the given 
     * types of stamps.
     *
     * @param stampDenominations The values of the types of stamps that the 
     *     machine should have.  Should be sorted in descending order and 
     *     contain at least a 1.
     */
    public StampDispenser(int[] stampDenominations)
    {
    	// Check if int[] was sorted in decending order, if not end
    	if(!isInOrder(stampDenominations))
    	{
    		System.out.println("Array inputed not in descending order.");
    		return;
    	}
    	
    	this.stampDenominations = stampDenominations;
    }
 
    /**
     * Returns the minimum number of stamps that the machine can dispense to
     * fill the given request.
     *
     * @param request The total value of the stamps to be dispensed.
     */
    public int calcMinNumStampsToFillRequest(int request)
    {  
    	int startIndex = -1;
    	
    	// Find where the request # falls in the array
    	for(int i = 0; i < stampDenominations.length; i++)
    	{
    		if(stampDenominations[i] <= request)
    		{
    			startIndex = i;
    			break;
    		}
    	}
    	    	
    	int first = rec(startIndex, 0, 1, request);
    	int second = rec(startIndex + 1, 0, 1, request);
    	
    	System.out.println("MIN " + Math.min(first, second));
    	
        return 0;
    }
        
    
    private int rec(int i, int total, int numStamps, int request)
    {
    	// If went over, cant take this branch
    	if(total > request)
    	{
    		//System.out.println("OVERTOTAL: " + numStamps);
    		return Integer.MAX_VALUE;
    	}
    	
    	// Check bounds
    	if(i >= stampDenominations.length)
    	{
    		//System.out.println("REACHED END: " + numStamps + " " + total);
    		// check if over request
    		if(total > request)
    			return numStamps;
    		else
    			return Integer.MAX_VALUE;
    	}
    	
    	System.out.println(numStamps + " " + total);
    	total += stampDenominations[i];
    	System.out.println(numStamps + " " + total);
    
    	if(total == request)
    	{
    		//System.out.println("?" + numStamps);
    		return numStamps;
    	}
    	
    	numStamps++;
    	
    	// Take the next int
    	int first = rec(i, total, numStamps, request);
    	// Do not take
    	int second = rec(i+1, total, numStamps, request);
    	
    	//System.out.println("GOING UP:" + Math.min(first, second));
    	
    	//System.out.println("MIN " +Math.min(first, second)+ " : " + first + " " + second);
    	return Math.min(first, second);
    }
    
    
    private boolean isInOrder(int[] denominations)
    {
    	for(int i = 1; i < denominations.length; i++)
    	{
    		if(denominations[i - 1] < denominations[i])
    			return false;
    	}
    	
    	return true;
    }
    
    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        
        stampDispenser.calcMinNumStampsToFillRequest(91);
        
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;
    }
    
}
