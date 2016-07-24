public class P114_FlattenBinaryTreeToLinkedList {

	
	
	//Given a binary tree, flatten it to a linked list in-place.
    
	private TreeNode prev = null;
	public void flatten(TreeNode root) {
        if(root==null) return ;
        
        flatten(root.right);//right subTree turns into a flatten list
        flatten(root.left);	//left  subTree turns into a flatten list
        
        root.left = null;	
        root.right= prev;
        prev =root;
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
