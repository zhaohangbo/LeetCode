import java.util.LinkedList;
import java.util.List;

public class P113_PathSumII {

	//input: [-2,null,-3],-5, so sum might begin as a negative
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new LinkedList<List<Integer>>();
      dfs(root, 0, sum, new LinkedList<Integer>(), res);
      return res; 
    }
	
    public void dfs(TreeNode root, int curSum,int sum , List<Integer> path, List<List<Integer>> res){
    	if(root == null) return;

    	// root != null & curSum>=0
    	path.add(root.val);
    	curSum += root.val;
    	
    	if(curSum==sum && root.left==null && root.right==null) {
    		res.add(path);
    		return;
    	}
    	List<Integer> leftPath  = new LinkedList<Integer>(path);
    	List<Integer> rightPath = new LinkedList<Integer>(path);
    	dfs(root.left,  curSum, sum, leftPath, res);
    	dfs(root.right, curSum, sum, rightPath, res);
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
