public class SameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if (p == null)
			return false;
		if (q == null)
			return false;

		boolean left = isSameTree(p.left, q.left);

		if (p.val != q.val)
			return false;

		boolean right = isSameTree(p.right, q.right);

		if (left == false && right == false)
			return false;

		return left && right;
	}
}
