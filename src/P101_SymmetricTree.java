import java.util.LinkedList;
import java.util.Queue;

public class P101_SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetricHelper(root.left,root.right);
	}
	
	public boolean isSymmetricHelper(TreeNode left,TreeNode right){
		if(left==null && right==null) return true;
		else if(left==null || right==null) return false;
		
		if(left.val==right.val){
			return isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right, right.left);
		}
		return false;
	}
	
    public boolean isSymmetric2(TreeNode root) {
        if(root ==null) return true;
    	Queue<TreeNode> left  = new LinkedList<TreeNode>(); 
    	left.add(root.left);
    	Queue<TreeNode> right = new LinkedList<TreeNode>();
    	right.add(root.right);
    	
    	while(!left.isEmpty() || !right.isEmpty()){
    		if( left.isEmpty()&&!right.isEmpty()) return false;
    		if(!left.isEmpty()&& right.isEmpty()) return false;
    		if(!left.isEmpty()&&!right.isEmpty()){
    			TreeNode  l = left.poll();
    			TreeNode  r = right.poll();
    			if(l!=null && r!=null && l.val!=r.val) return false;
    			if((l==null&&r!=null) || (l!=null&&r==null)) return false;
    			
    			if(l!=null){
    				left.add(l.left);left.add(l.right);
    			}
    			if(r!=null){
    				right.add(r.right);
    				right.add(r.left);
    			}
    		}
    	}
    	return true;
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
