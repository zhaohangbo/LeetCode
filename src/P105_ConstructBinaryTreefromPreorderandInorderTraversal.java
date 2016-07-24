
public class P105_ConstructBinaryTreefromPreorderandInorderTraversal {

	//[1,2]
	//[1,2]
	
	//        6 
	//     4     7
	//       5  

	// 6 4 5 7
	// 4 5 6 7
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(inorder==null || preorder==null || inorder.length==0 || preorder.length==0) return null;
    	prePointer = 0;
    	return helper(preorder,inorder,0,inorder.length-1);
    }
    
    int prePointer;
    public TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd){
    	if(inStart>inEnd) return null;
    	TreeNode root = new TreeNode(preorder[prePointer]);
    	prePointer++;//preOrder should start from 0th, and use ++ 
    	
    	int rootIndex = -2;
    	for(int i=inStart; i<=inEnd; i++){
    		if(inorder[i]==root.val){
    			rootIndex = i;
    			break;
    		}
    	}
    	
    	root.left = helper(preorder, inorder, inStart, rootIndex-1);
    	root.right= helper(preorder, inorder, rootIndex+1, inEnd);
    	return root;
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
