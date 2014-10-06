import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class FindTriplets{
    public static void main(String args[])
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
      
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
  
        for(int i=0;i<n;i++)
        {
        	int temp = scn.nextInt();
        	
        	if(!m.containsKey(temp))
        	{
        		arr.add(temp);
        		m.put(temp, 1);
        	}
        }
        
        int triplets=0;	
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.size() - 2; i++)
        {
        	ans.add(arr.get(i));
        	ans = findDup(arr, i , ans);
        	
        	for(int j = 0; j < ans.size(); j++)
        		System.out.print(ans.get(j) + " ");
        	System.out.println();
        	ans.clear();
        }
        
        System.out.println(triplets);
    }

	private static ArrayList<Integer> findDup(ArrayList<Integer> arr, int t, ArrayList<Integer> ans) {
			
		return ans;
	}

}
