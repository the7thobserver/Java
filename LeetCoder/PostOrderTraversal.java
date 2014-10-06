import java.util.ArrayList;
import java.util.List;


public class PostOrderTraversal {
	static class TreeNode
	{
		TreeNode left, right;
		int val;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args)
	{
		TreeNode n = new TreeNode(1);
		n.right = new TreeNode(2);
		n.right.left = new TreeNode(3);
		
		List<Integer> x = postorderTraversal(n);
		System.out.println("Size: " + x.size());
		for(int i = 0; i < x.size(); i++)
			System.out.print(x.get(i) + " ");
		
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();

        l = postTra(root, l);
        
        return l;
    }

	private static List<Integer> postTra(TreeNode root, List<Integer> l) {
		if(root == null)
			return l;
		
		l.addAll(postorderTraversal(root.left));
        l.addAll(postorderTraversal(root.right)); 
		
        l.add(root.val);
        
        return l;
        
	}
}
