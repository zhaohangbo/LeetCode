
public class P270_ClosestBinarySearchTreeValue {
	
	//Given a non-empty binary search tree and a target value
	//Find the value in the BST that is closest to the target.
    public int closestValue(TreeNode root, double target) {
    	TreeNode child = root.val<target?root.right:root.left;
    	
    	if(child==null) return root.val;
    	
    	int closestOfChild = closestValue(child, target);
    	
    	return Math.abs(closestOfChild-target)>Math.abs(root.val-target)?root.val:closestOfChild;
    }
    
	
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
