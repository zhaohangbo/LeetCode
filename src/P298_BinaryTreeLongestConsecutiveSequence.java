
public class P298_BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
    	if(root==null) return 0;
    	findPath(root,root.val,0);
    	return maxLen;
    }
    
    private int maxLen = 0;
    public void findPath(TreeNode root,int expected,int curLen){
    	if(root==null) return;
    	if(root.val == expected){
    		curLen++;
    		maxLen=Math.max(maxLen, curLen);
    	}
    	else{
    		curLen = 1;//reset
    	}
    		
    	findPath(root.left, root.val+1, curLen );
    	findPath(root.right, root.val+1, curLen );
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
