
public class P226_InvertBinaryTree {
	 
    public TreeNode invertTree(TreeNode root) {
    	if(root == null){
    		return root;
    	}
    	else if(root.left ==null && root.right==null)
    		return root;
    	else if(root.left!=null && root.right==null){
    		root.right = invertTree(root.left);
    		root.left  =null;
    		return root;
    	}
    	else if(root.left==null && root.right!=null){
    		root.left = invertTree(root.right);
    		root.right=null;
    		return root;
    	}
    	else{ // if(root.left!=null && root.right!=null)
    		TreeNode inverted_left  = invertTree(root.left);
    		TreeNode inverted_right = invertTree(root.right);
    		root.left = inverted_right;
    		root.right= inverted_left;
    		return root;
    	}
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
