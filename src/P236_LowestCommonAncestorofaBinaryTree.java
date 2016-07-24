import java.util.LinkedList;

public class P236_LowestCommonAncestorofaBinaryTree {

//       1
//    2     3

	//recursive and expands the meaning of the function. 
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||p==root||q==root) return root;
		TreeNode l_contains_P_or_Q  = lowestCommonAncestor(root.left,  p, q);
		TreeNode r_contains_P_or_Q = lowestCommonAncestor(root.right, p, q);
		
		if(l_contains_P_or_Q!=null && r_contains_P_or_Q !=null)//both left and right contain p or q
			return root;
		else if(l_contains_P_or_Q!=null&&r_contains_P_or_Q==null)//only left contains p or q
			return l_contains_P_or_Q;
		else if(l_contains_P_or_Q==null&&r_contains_P_or_Q!=null)//only right contains p or q
			return r_contains_P_or_Q;
		else//neither left or right contains p or q
			return null;
	}
	
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    	LinkedList<TreeNode> pPath = new LinkedList<TreeNode>();
    	pathToTarget(root, p, pPath);
    	
    	LinkedList<TreeNode> qPath = new LinkedList<TreeNode>();
    	pathToTarget(root, q, qPath);
    	
    	TreeNode res = null;
    	for(int i=0;i<Math.min(pPath.size(), qPath.size());i++){
    		if(pPath.get(i)==qPath.get(i)){
    			res=pPath.get(i);
    		}
    		else{
    			break;
    		}
    	}
    	return res;
    }
    public TreeNode pathToTarget(TreeNode root, TreeNode target, LinkedList<TreeNode> path){
		if (root == null)
			return null;

		if (root.val == target.val) {
			path.add(0, root);
			return root;
		}
		TreeNode left  = pathToTarget(root.left, target, path);
		TreeNode right = pathToTarget(root.right, target, path);
		if (left != null || right != null) {
			path.add(0, root);
			return root;
		}
		return null;
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
