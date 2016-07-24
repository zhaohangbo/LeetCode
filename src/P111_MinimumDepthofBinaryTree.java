
public class P111_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
    	//null
    	if(root==null) return 0;
    	
    	//is leaf
    	if(root.left==null && root.right==null) 
    		return 1;
    	
    	if(root.left==null)
    		return 1+minDepth(root.right);
    	
    	if(root.right==null)
    		return 1+minDepth(root.left);
    	
    	int minLeft =  1+minDepth(root.left);
    	int minRight = 1+minDepth(root.right);
    	return Math.min(minLeft,minRight);    
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
