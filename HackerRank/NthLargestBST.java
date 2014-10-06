
public class NthLargestBST {
	class Node
	{
		Node right;
		Node left;
	}
	void NthLarget(Node node, int n)
	{
		 int count = 0;
		 
		 search(node, n, count);
		
	}

	private int search(Node node, int n, int count) {
		if(node == null)
			return count;
		
		count = search(node.right, n, count);
		count++;
		 
		if(count == n)
			System.out.println("DATA");
		
		count = search(node.left, n, count);
		
		return count;
	}

}
