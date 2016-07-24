import java.util.HashMap;

public class P337_HouseRobberIII {

	//Accepted, but slow, repeatedly
    public int rob_1(TreeNode root) {
    	if(root==null) return 0;
    	int v1 = rob_1(root.left)+ rob_1(root.right);
    	
    	int v2 = root.val;
    	if(root.left!=null)
    		v2 += (rob_1(root.left.left)+rob_1(root.left.right));
    	if(root.right!=null)
    		v2 += (rob_1(root.right.left)+rob_1(root.right.right));
    	
    	return Math.max(v1, v2);
    }
    //DP
    HashMap<TreeNode,Integer> map =new HashMap<TreeNode,Integer>();
    public int rob_2(TreeNode root) {
    	if(root == null) return 0;
    	if(map.containsKey(root)) return map.get(root);
    	
    	int v1 = rob(root.left)+ rob(root.right);
    	
    	int v2 = root.val;
    	if(root.left!=null)
    		v2 += (rob(root.left.left)+rob(root.left.right));
    	if(root.right!=null)
    		v2 += (rob(root.right.left)+rob(root.right.right));
    	
    	int result  = Math.max(v1, v2);
    	map.put(root, result);
    	return result;
    }
    //DFS
    public int rob(TreeNode root) {
    	return Math.max(helper(root)[0],helper(root)[1]);
    }
    
    public int[] helper(TreeNode root){
    	if(root==null) return new int[2];
    	
    	int[] left =helper(root.left);
    	int[] right=helper(root.right);
    	int[] result =new int[2];
    	
    	//if(root is not robbed){
    	//	left  can have 2 situations.(robbed, not robbed)
    	//	right can have 2 situations.(robbed, not robbed) 
    	//}
    	//if(root is robbed){
    	//	left  must not be robbed
    	//	right must mot be robbed
    	//}
    	result[0] = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
    	result[1] = root.val + left[0] + right[0];
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
