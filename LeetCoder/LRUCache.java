import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

// O(n) b/c search through Queue
// Can be O(1) is have hashmap go to node in queue.
public class LRUCache {
	public static void main(String[] args)
	{
		LRUCache c = new LRUCache(2);
		System.out.println(c.get(2));
		c.set(2, 1);
		c.set(2, 6);
		System.out.println(c.get(1));
		c.set(1, 5);
		c.set(1, 2);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
	}
	
	private int cur_size;
	private int max_size;
	private HashMap<Integer, Integer> cache;
	private LinkedList<Integer> recent;
	
    public LRUCache(int capacity) {
        max_size = capacity;
        cur_size = 0;
        cache = new HashMap<Integer, Integer>();
        recent = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key))
        {
        	recent.remove((Object) key);
        	recent.addFirst(key);
        	return cache.get(key);
        }
        else
        	return -1;
    }
    
    public void set(int key, int value) {        
    	// Put
    	if(!cache.containsKey(key))
    	{
    		System.out.println("Adding " + key + ":" + value);
    		recent.addFirst(key);
    		cache.put(key, value);
    		cur_size++;
    	}
    	// Set
    	else if(cache.containsKey(key))
    	{
    		System.out.println("Setting " + key + " to " + value);
    		
    		recent.remove((Object) key);
    		recent.addFirst(key);
    		
    		cache.put(key, value);
    	}
    	// Max capacity
    	else if(cur_size == max_size)
    	{
    		int temp = recent.removeLast();
    		System.out.println("Removing " + temp + " " + cache.get(temp));
    		// Invalidate least recently used
    		cache.remove((Object) temp);
    		cur_size--;
    	}
    }
}
