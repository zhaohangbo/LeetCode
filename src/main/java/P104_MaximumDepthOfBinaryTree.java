
public class P104_MaximumDepthOfBinaryTree {

	
	
    public int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	if(root.left==null && root.right==null)
    		return 1;
    	//root !=null, so depth is at least 1
    	//left !=null  || right!= null
    	int depth = 1;
    	depth +=Math.max( maxDepth(root.left) , maxDepth(root.right));
        return depth;
    }
    
    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

}
