package BoxAlgos;
import java.util.ArrayList;


public class QuickSort 
{	
	public ArrayList<Integer> sortQuickly(ArrayList<Integer> x)
	{	
		if(x.size() <= 1)
			return x;
		
		int pivot = x.remove(0);
		
		ArrayList<Integer> less = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		
		for(int i = 0; i < x.size(); i++)
		{
			if(x.get(i) < pivot)
				less.add(x.get(i));
			else
				greater.add(x.get(i));
		}

		ArrayList<Integer> merged = new ArrayList<Integer>();
		
		less = sortQuickly(less);
		
		for(int i = 0; i < less.size(); i++)
			merged.add(less.get(i));
		
		merged.add(pivot);
		
		greater = sortQuickly(greater);
		
		for(int i = 0; i < greater.size(); i++)
			merged.add(greater.get(i));
		
		return merged;
	}

}
