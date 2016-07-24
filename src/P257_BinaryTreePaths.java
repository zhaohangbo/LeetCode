import java.util.ArrayList;
import java.util.List;

public class P257_BinaryTreePaths {
	
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res =new ArrayList<String>();
    	if(root!=null) 
    		dfs(root,"",res);
    	return res;
    }
	
    public void dfs(TreeNode root, String pathSoFar, List<String> res) {
    	if(root.left==null && root.right==null){
    		res.add(pathSoFar+root.val);
    	};
    	if(root.left!=null)
    		dfs(root.left,  pathSoFar+root.val+"->", res);
    	if(root.right!=null)
    		dfs(root.right, pathSoFar+root.val+"->", res);
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
