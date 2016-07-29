
public class P100_SameTree {

	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	 
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null)
    		return true;
    	else if(p!=null && q!=null){
    		if(p.val== q.val)
    			return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    		else
				return false;
    	}
    	else{
    		//p==null && q!=null, or ,p!=null && q==null, return must be false
    		return false;
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
