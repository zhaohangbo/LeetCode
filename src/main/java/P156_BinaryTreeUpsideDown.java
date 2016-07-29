
public class P156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
    	if(root == null) return null;
    	if(root.left==null && root.right==null) 
    		return root;// Most left child
    	
    	//1. Most left becomes root_now
    	TreeNode root_now = upsideDownBinaryTree(root.left);
    	root.left.left = root.right;//2. root.right  becomes left_now 
    	root.left.right= root; //3. root becomes right_now
    	
    	//To cope with "Memory Limit Exceeded"
    	root.left=null;
    	root.right=null;
    	root=null;
    	
     return root_now;   
    }
    public class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    }
//    1      				4
//   / \       --->		   / \
//  2   3   UpsideDown    5   2
// / \     		  			 / \
//4   5     			 	3   1 
    
//We can see that for each 3 nodes (one parent, one left, one right).
//After the UpsideDown

//left   becomes parent_now
//parent becomes right_now
//right  becomes left_now 
    
//The process begins from the most left child
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
