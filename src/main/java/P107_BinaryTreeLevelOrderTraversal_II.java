import java.util.ArrayList;
import java.util.List;

public class P107_BinaryTreeLevelOrderTraversal_II {

	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> top_to_bottom = new ArrayList<List<Integer>>();
    	List<List<Integer>> bottom_to_top = new ArrayList<List<Integer>>();
    	helper(root,0,top_to_bottom);
    	//其实，这是笨办法。为何不在递归的时候，直接将各层Nodes按照倒序，见Helper2 and levelOrderBottom2
    	for(int i=top_to_bottom.size()-1;i>=0;i--){
    		bottom_to_top.add(top_to_bottom.get(i));
    	}
    	return bottom_to_top;
    }
    public void helper (TreeNode node, int depth, List<List<Integer>> result){
    	if(node==null) return;
    	if(result.size()==depth){//result.size==1,depth==0 ; result.size==2,depth==1
    		List<Integer> level = new ArrayList<Integer>();
    		result.add(level);
    	}
    	helper(node.left , depth+1,result);
    	helper(node.right, depth+1,result);
    	result.get(depth).add(node.val);
    }
    
    
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    	List<List<Integer>> result_list = new ArrayList<List<Integer>>();
    	helper2(root,0,result_list);
    	return result_list;
    }
    public void helper2 (TreeNode node, int depth, List<List<Integer>> result_list){
    	if(node==null) return;
    	if(result_list.size()==depth){//result.size==1,depth==0 ; result.size==2,depth==1
    		List<Integer> level = new ArrayList<Integer>();
    		//result_list.add(level);// append at the tail
    		result_list.add(0,level);//insert at the head
    	}
    	helper(node.left , depth+1,result_list);
    	helper(node.right, depth+1,result_list);
    	//result_list.size()-1 - depth
    	result_list.get(result_list.size()-1 - depth).add(node.val);
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
