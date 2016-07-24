import java.util.PriorityQueue;
import java.util.Queue;

public class P250_CountUnivalueSubtrees {

//	Given a binary tree, count the number of uni-value subtrees.
//
//	A Uni-value subtree means all nodes of the subtree have the same value.
//
//	For example:
//	Given binary tree,
	
	int count = 0;
    public int countUnivalSubtrees2(TreeNode root) {
    	allSubtNodesSame(root,0);
        return count;
    }
	public boolean allSubtNodesSame(TreeNode node,int parent_val){
		if(node==null)
			return true;
		if(!allSubtNodesSame(node.left,node.left.val) || !allSubtNodesSame(node.right,node.right.val))
			return false;
		count ++;
		return node.val==parent_val;
	}
	
    public int countUnivalSubtrees(TreeNode root) {
        return helper(root)[0];
    }
    
    public int[] helper(TreeNode root){
    	int[] res =new int[2];
    	if (root == null){
    		res[0] = 0;//number of UnivalSub trees
    		res[1] = 0;//notUnivalSub
    	}
    	else if(root.left ==null && root.right ==null){
    		res[0] = 1;//number of UnivalSub trees
    		res[1] = 1;//isUnivalSub
    	}
    	else if(root.left !=null && root.right ==null){
    		int[] left  = helper(root.left);
    		if(left[1]==1 && root.val==root.left.val){
    			res[0] = 1+left[0];//number of UnivalSub trees
        		res[1] = 1;		   //isUnivalSub
    		}
    		else
        		res[0] = left[0];
    	}
    	else if(root.left ==null && root.right !=null){
    		int[] right = helper(root.right);
    		if(right[1]==1 && root.val==root.right.val){
    			res[0] = 1+right[0];//number of UnivalSub trees
        		res[1] = 1;		    //isUnivalSub
    		}
    		else
        		res[0] = right[0];
    	}
    	else if(root.left !=null && root.right !=null){
    		int[] left  = helper(root.left); 
    		int[] right = helper(root.right);
    		if(left[1]==1 && right[1]==1 && root.val==root.left.val && root.val==root.right.val){
    			res[0] = 1+left[0]+right[0];
	    		res[1] = 1;		    //isUnivalSub
			}
    		else
        		res[0] = left[0]+right[0];
    	}
        return res;
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
