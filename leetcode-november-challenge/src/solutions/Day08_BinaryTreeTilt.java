package solutions;

public class Day08_BinaryTreeTilt {
	private int totalTilt = 0;

	protected int valueSum(TreeNode node) {
		if (node == null)
			return 0;

		int leftSum = this.valueSum(node.left);
		int rightSum = this.valueSum(node.right);
		int tilt = Math.abs(leftSum - rightSum);
		this.totalTilt += tilt;

		// return the sum of values starting from this node.
		return node.val + leftSum + rightSum;
	}

	public int findTilt(TreeNode root) {
		this.totalTilt = 0;
		this.valueSum(root);
		return this.totalTilt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
