
public class P110_BalancedBinaryTree {

	//Top down
	//For the current node root, calling depth() for its left and right children has to access all of its children
	//thus the complexity is O(N).
	//We do this for every node in the tree, 
	//So the overall complexity of isBalanced will be O(N^2).
    public boolean isBalanced2(TreeNode root) {
    	if(root==null) return true;
    	if(Math.abs(depth(root.left)-depth(root.right))<=1
    	&&isBalanced2(root.left)&&isBalanced2(root.right)){
    		return true;
    	}
    	return false;
    }
    
    public int depth(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	int depth = Math.max(depth(root.left),depth(root.right)) +1;
    	return depth;
    }
	
	//Bottom up
	//Each node in the tree only needs to be accessed once
	//Thus time complexity is O(n)
    public boolean isBalanced(TreeNode root) {
    	isBalanced_Helper(root);
    	return isBalanced_Helper(root)[0]==1;
    }
    
    public int[] isBalanced_Helper(TreeNode root){
    	int[] result =new int[2];//result[0] --> ifBalance, result[1]-->height
    	if(root==null){	
    		result[0] = 1;
     		return result;
    	}
    	int[] left  = isBalanced_Helper(root.left);
    	int[] right = isBalanced_Helper(root.right);
    	
    	//left or right is unbalanced
    	if(left[0]==0 ||right[0]==0 || Math.abs(left[1] -right[1])>1)
    		return result;
    	
		//root is balanced only if 
		//1.both left and right are balanced
		//2.diff <= 1
    	if(left[0]==1 && right[0]==1 && Math.abs(left[1] -right[1])<=1){
    		result[0] =1; 
    		result[1] = Math.max(left[1], right[1])+1;//+1 here, do not forget
    	}
    	return result; 
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
