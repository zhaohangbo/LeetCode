
public class P106_ConstructBinaryTreefromInorderandPostorderTraversal {
	//       6
	//   3      8
	// 2   4  
	// 2 3 4 6 8
	// 2 4 3 8 6
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) return null;
    	
    	int rootPostIndex = postorder.length-1;
    	return buildSubTree(inorder,postorder,0, postorder.length-1, rootPostIndex);
    }

    //wrong
    //we can't use rootPostIndex as parameter, we don't know how many times it decreases in one buildSubTree()
    public TreeNode buildSubTree(int[] inorder, int[] postorder,int inStart, int inEnd, int rootPostIndex){
    	if(inEnd<inStart || rootPostIndex<0) return null;
    	TreeNode root = new TreeNode(postorder[rootPostIndex]);
    	
    	int rootPos = -2;
    	for(int i=inStart;i<=inEnd;i++){
    		if(inorder[i]==root.val){
    			rootPos = i;
    			break;
    		}
    	}
    	//right  before left
    	root.right=     buildSubTree(inorder, postorder, rootPos+1, inEnd, rootPostIndex-1);
    	if(root.right!=null)
    		root.left = buildSubTree(inorder, postorder, inStart, rootPos-1, rootPostIndex-1-1);//not -1-1,you don't know how many times
    	else
    		root.left = buildSubTree(inorder, postorder, inStart, rootPos-1, rootPostIndex-1);//not -1,you don't know how many times
    	return root;
    }
    
    //Right Answer
	int rootPostIndex;
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
    	if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) return null;
    	
    	rootPostIndex = postorder.length-1;
    	return buildSubTree(inorder,postorder,0, postorder.length-1);
    }
    //inStart <= i <= inEnd(excluding rootPos)
    public TreeNode buildSubTree(int[] inorder, int[] postorder,int inStart, int inEnd){
    	if(inEnd<inStart || rootPostIndex<0) return null;
    	TreeNode root = new TreeNode(postorder[rootPostIndex]);
    	rootPostIndex--;
    	
    	int rootPos = -2;
    	for(int i=inStart;i<=inEnd;i++){
    		if(inorder[i]==root.val){
    			rootPos = i;
    			break;
    		}
    	}
    	//right  before left
    	root.right= buildSubTree(inorder, postorder, rootPos+1, inEnd);
    	root.left = buildSubTree(inorder, postorder, inStart, rootPos-1);
    	return root;
    }
    
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
    // 1
	//2 3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder   = {2,1,3};
		int[] postorder = {2,3,1};
		new P106_ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder,postorder);
	}

}
