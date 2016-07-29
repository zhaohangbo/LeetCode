import java.util.ArrayList;
import java.util.List;

public class P366_FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> res =new ArrayList<List<Integer>>();
    	List<Integer> leaves  = new ArrayList<Integer>();
    	while(root!=null){
    		if(isLeaf(root,leaves)) root=null;
    		res.add(leaves);
    		leaves= new ArrayList<Integer>();
    	}
    	return res;
    }
    
    public boolean isLeaf(TreeNode root, List<Integer> leaves ){
    	
    	if(root.left==null && root.right==null){
    		leaves.add(root.val);
    		return true;
    	}
    	
    	if(root.left!=null){
    		if(isLeaf(root.left,leaves))
    			root.left=null; //remove leaf
    	}
    	if(root.right!=null){
    		if(isLeaf(root.right,leaves))
    			root.right=null;//remove leaf
    	}
    	return false;
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
